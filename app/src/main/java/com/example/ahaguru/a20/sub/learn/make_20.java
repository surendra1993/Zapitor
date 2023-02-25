package com.example.Zapitor.a20.sub.learn;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
 * Created by Zapitor on 24-12-2016.
 */

public class make_20 extends Activity implements View.OnClickListener  {
    String enteredAnswer;
    int operand1,operand2,qid=1,enteredAnswer1=0,score=0,mins,secs,wrong=0;
    private Random random;
    CustomKeyboard mCustomKeyboard;
    EditText ques2 ;
    TextView ques1,responseTxt,lesson_name,answer,quest_number,ansTxt;
    ImageView back,response;
    Button btn_sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make);

        back = (ImageView) findViewById(R.id.back);
        response = (ImageView)findViewById(R.id.response);

        lesson_name = (TextView) findViewById(R.id.lesson_name);
        quest_number = (TextView)findViewById(R.id.quest_number);
        ansTxt = (TextView)findViewById(R.id.ansTxt);
        ques1 = (TextView) findViewById(R.id.ques1);
        responseTxt = (TextView) findViewById(R.id.responseTxt);
        btn_sub = (Button) findViewById(R.id.btn_sub);
        ques2 = (EditText) findViewById(R.id.ques2);
        answer = (TextView)findViewById(R.id.answer) ;
        lesson_name.setText("Lesson 10 - MAKE 20");

        mCustomKeyboard = new CustomKeyboard(this, R.id.keyboardview, R.xml.number);
        mCustomKeyboard.registerEditText(R.id.ques2);
        ques2.setFocusable(true);
        ques2.requestFocus();

        responseTxt.setVisibility(View.INVISIBLE);
        response.setVisibility(View.INVISIBLE);

        backClickListener();
        btn_sub.setOnClickListener(this);

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
        ques2.setText("");
        answer.setText("20");
        operand1 = getOperand1();
        quest_number.setText("Q"+qid);
        ques1.setText(""+operand1);
        operand2 = 20 - operand1 ;
        qid++;
        response.setVisibility(View.INVISIBLE);
        ansTxt.setVisibility(View.INVISIBLE);
    }
    private int getOperand1() {
        operand1=random.nextInt(20 - 0) + 0;
        return operand1;
    }
    private void gotoNextActivity() {
        Intent intent=new Intent(make_20.this,last.class);
        Bundle b= new Bundle();
        b.putInt("qid",qid);
        b.putInt("score",score);
        intent.putExtras(b);
        startActivity(intent);
        finish();

    }
    public void showDialog(String messageText)
    {
        LayoutInflater inflater = LayoutInflater.from(make_20.this);
        View subView = inflater.inflate(R.layout.dialog_with_input, null);
        TextView textMessage = (TextView) subView.findViewById(R.id.dialog_message);
        final AlertDialog.Builder builder = new AlertDialog.Builder(make_20.this);
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
            enteredAnswer  = ques2.getText().toString().trim();


            Spannable wordTwo = new SpannableString("Try again.!");
            wordTwo.setSpan(new ForegroundColorSpan(Color.RED), 0, wordTwo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            if (enteredAnswer.equals("")){
                showDialog("Please enter a valid answer");
            }
            else{
                enteredAnswer1 = Integer.parseInt(enteredAnswer);

                if (enteredAnswer1 == operand2) {
                    wrong=0;
                    score++;
                    response.setBackgroundResource(R.drawable.tick1);
                    response.setVisibility(View.VISIBLE);
                    Log.e("tag","score"+ score);
                    Log.e("tag","wrong"+ wrong);
                    responseTxt.setTextColor(getResources().getColor(R.color.dark_green));
                    responseTxt.setText("Correct Answer");
                    responseTxt.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            response.setVisibility(View.INVISIBLE);
                            responseTxt.setVisibility(View.VISIBLE);
                            responseTxt.setText("");
                            if (qid < 11) {
                                selectQuestion();
                            } else
                            {
                                gotoNextActivity();
                            }

                        }
                    }, 1000);

                }else if(wrong < 1){
                    wrong ++;
                    response.setBackgroundResource(R.drawable.cross1);
                    response.setVisibility(View.VISIBLE);
                    responseTxt.setText(wordTwo);
                    responseTxt.setVisibility(View.VISIBLE);

                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            response.setVisibility(View.INVISIBLE);
                            responseTxt.setText("");
                            ques2.setText("");

                            responseTxt.setVisibility(View.INVISIBLE);
                        }
                    }, 1500);
                }

                else {
                    wrong=0;
                    Log.e("tag","ans"+ operand2);
                    response.setBackgroundResource(R.drawable.cross1);
                    response.setVisibility(View.VISIBLE);
                    responseTxt.setTextColor(getResources().getColor(R.color.textBlack));
                    responseTxt.setText("The Answer is");
                    ansTxt.setTextColor(getResources().getColor(R.color.dark_green));
                    ansTxt.setText(""+operand2);
                    ansTxt.setVisibility(View.VISIBLE);
                    responseTxt.setVisibility(View.VISIBLE);



                    new Handler().postDelayed(new Runnable() {
                        public void run() {

                            response.setVisibility(View.VISIBLE);
                            responseTxt.setVisibility(View.INVISIBLE);
                            if (qid < 11){
                                selectQuestion();
                            }
                            else{
                                gotoNextActivity();
                            }
                        }
                    }, 3000);

                }
            }
        }
    }
}
