package com.example.Zapitor.a20.sub.learn;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Zapitor.a20.R;

import java.util.Random;

/**
 * Created by Zapitor on 15-12-2016.
 */

public class learn3 extends Activity implements View.OnClickListener {

    String enteredAnswer;
    int operand1,operand2,answer=0,qid=1,enteredAnswer1=0,score=0,mins,secs,wrong=0,prev=0;
    private Random random;
    CustomKeyboard mCustomKeyboard;
    EditText editText ;
    TextView question,responseT,responseTxt,lesson_name,quest_number;
    ImageView response,back;
    Button btn_sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oneinput);

        back = (ImageView)findViewById(R.id.back);
        response = (ImageView)findViewById(R.id.response);
        lesson_name = (TextView)findViewById(R.id.lesson_name);
        question = (TextView)findViewById(R.id.question);
        responseT = (TextView)findViewById(R.id.responseT);
        quest_number = (TextView)findViewById(R.id.quest_number);
        responseTxt = (TextView)findViewById(R.id.responseTxt);
        btn_sub = (Button)findViewById(R.id.btn_sub);
        editText  = (EditText) findViewById(R.id.answer1);
        lesson_name.setText("Lesson 3");

        mCustomKeyboard= new CustomKeyboard(this, R.id.keyboardview, R.xml.number );
        mCustomKeyboard.registerEditText(R.id.answer1);

        responseTxt.setVisibility(View.INVISIBLE);
        responseT.setVisibility(View.INVISIBLE);
        response.setVisibility(View.INVISIBLE);
        btn_sub.setOnClickListener(this);
        backClickListener();
        random = new Random();
        selectQuestion();
    }

    private void backClickListener() {
        final Context context = this;
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    }

    private void selectQuestion() {

        operand1 = getOperand1();
        operand2 = 0;
        editText.setText("");
        responseT.setText("");
        responseTxt.setText("");
        if(operand1 == prev){
            selectQuestion();
        }
        quest_number.setText("Q"+qid);
        question.setText(operand1 + "-" + operand2);
        answer = operand1 - operand2;
        qid++;
        prev = operand1;

    }

    private int getOperand1() {
        operand1 = random.nextInt(9 - 1) + 1;
        return operand1;
    }

    private void gotoNextActivity() {
        Intent intent=new Intent(learn3.this,last.class);
        Bundle b= new Bundle();
        b.putInt("qid",qid);
        b.putInt("score",score);
        intent.putExtras(b);
        startActivity(intent);
        finish();
    }

    public void showDialog(String messageText)
    {
        LayoutInflater inflater = LayoutInflater.from(learn3.this);
        View subView = inflater.inflate(R.layout.dialog_with_input, null);
        TextView textMessage = (TextView) subView.findViewById(R.id.dialog_message);
        final AlertDialog.Builder builder = new AlertDialog.Builder(learn3.this);
        textMessage.setText(messageText);
        builder.setView(subView);
        builder.setPositiveButton("OK", null);
        final AlertDialog dialog = builder.create();
        dialog.show();

        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dialog.dismiss();
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_sub){
            enteredAnswer  = editText.getText().toString().trim();

            Spannable word = new SpannableString("Correct");
            word.setSpan(new ForegroundColorSpan(Color.GREEN), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            Spannable wordTwo = new SpannableString("Try again.!");
            wordTwo.setSpan(new ForegroundColorSpan(Color.RED), 0, wordTwo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            if (enteredAnswer.equals("")){
                showDialog("Please enter a valid answer");
            }
            else {
                enteredAnswer1 = Integer.parseInt(enteredAnswer);
                if (enteredAnswer1 == answer) {
                    wrong = 0;
                    score++;
                    Log.e("tag", "score" + score);
                    Log.e("tag", "wrong" + wrong);
                    responseT.setText("Correct");
                    responseT.setTextColor(getResources().getColor(R.color.dark_green));
                    responseT.setVisibility(View.VISIBLE);
                    response.setImageResource(R.drawable.tick1);
                    response.setVisibility(View.VISIBLE);
                    btn_sub.setEnabled(false);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            responseT.setVisibility(View.VISIBLE);
                            response.setVisibility(View.INVISIBLE);
                            btn_sub.setEnabled(true);
                            responseT.setText("");
                            if (qid < 11) {
                                selectQuestion();
                            } else {
                                gotoNextActivity();
                            }

                        }
                    }, 1000);

                } else if (wrong < 1) {
                    wrong++;
                    responseT.setText(wordTwo);
                    responseT.setVisibility(View.VISIBLE);
                    response.setImageResource(R.drawable.cross1);
                    response.setVisibility(View.VISIBLE);
                    btn_sub.setEnabled(false);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            responseT.setText("");
                            editText.setText("");
                            response.setVisibility(View.INVISIBLE);
                            responseT.setVisibility(View.INVISIBLE);
                            btn_sub.setEnabled(true);
                        }
                    }, 1500);
                } else {
                    wrong = 0;
                    Log.e("tag", "ans" + answer);
                    responseTxt.setText("" + answer);
                    responseTxt.setVisibility(View.VISIBLE);
                    responseT.setText("answer");
                    responseT.setTextColor(getResources().getColor(R.color.textBlack));
                    responseT.setVisibility(View.VISIBLE);
                    response.setImageResource(R.drawable.cross1);
                    response.setVisibility(View.VISIBLE);
                    btn_sub.setEnabled(false);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            response.setVisibility(View.INVISIBLE);
                            responseT.setVisibility(View.INVISIBLE);
                            btn_sub.setEnabled(true);
                            if (qid < 11) {
                                selectQuestion();
                            } else {
                                gotoNextActivity();
                            }
                        }
                    }, 3000);

                }
            }
        }
    }
}
