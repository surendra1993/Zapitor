package com.example.Zapitor.a20.sub.learn;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
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

import static com.example.Zapitor.a20.R.id.responseTxt;

public class level19 extends Activity implements View.OnClickListener {
    String enteredAnswer;
    int qid=1,op1,op2,op3,op4,op5,op6,op7,op8,operand1,operand2,op9,op10,operand3,operand4,answer,score=0,enteredAnswer1,wrong;
    ImageView response,back;
    private Random random;
    TextView quest_number,question,o1,o2,o3,o4,o5,o6,o7,o8,responsetxt,anstxt;
    EditText a1,a2,a3,answer1 ;
    CustomKeyboard mCustomKeyboard;
    Button btn_sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level19);
        response = (ImageView)findViewById(R.id.response);
        back = (ImageView)findViewById(R.id.back);
        quest_number = (TextView)findViewById(R.id.quest_number);
        question = (TextView)findViewById(R.id.question);
        o1 = (TextView)findViewById(R.id.o1);
        o2 = (TextView)findViewById(R.id.o2);
        o3 = (TextView)findViewById(R.id.o3);
        o4 = (TextView)findViewById(R.id.o4);
        o5 = (TextView)findViewById(R.id.o5);
        o6 = (TextView)findViewById(R.id.o6);
        o7 = (TextView)findViewById(R.id.o7);
        o8 = (TextView)findViewById(R.id.o8);
        responsetxt = (TextView)findViewById(responseTxt);
        anstxt = (TextView)findViewById(R.id.ansTxt);

        a1  = (EditText) findViewById(R.id.a1);
        a2  = (EditText) findViewById(R.id.a2);
        a3  = (EditText) findViewById(R.id.a3);
        answer1  = (EditText) findViewById(R.id.answer1);
        btn_sub = (Button)findViewById(R.id.btn_sub);

        mCustomKeyboard= new CustomKeyboard(this, R.id.keyboardview, R.xml.number );
        mCustomKeyboard.registerEditText(R.id.a1);
        mCustomKeyboard.registerEditText(R.id.a2);
        mCustomKeyboard.registerEditText(R.id.a3);
        mCustomKeyboard.registerEditText(R.id.answer1);

        response.setVisibility(View.INVISIBLE);
        responsetxt.setVisibility(View.INVISIBLE);
        anstxt.setVisibility(View.INVISIBLE);

        random = new Random();
        selectQuestion();
        backClickListener();
        btn_sub.setOnClickListener(this);

        a1.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                Integer textlength3 = a1.getText().length();

                if (textlength3 > 0) {
                    a2.requestFocus();
                }
                else if(textlength3 < 0)
                {
                    a1.requestFocus();
                }
            }

            @Override
             public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
        });
        a2.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                Integer textlength3 = a2.getText().length();

                if (textlength3 > 1) {
                    a3.requestFocus();
                }
                else if(textlength3 < 0)
                {
                    a2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
        });

        a3.addTextChangedListener(new TextWatcher() {

             public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                Integer textlength3 = a3.getText().length();

                if (textlength3 > 2) {
                    answer1.requestFocus();
                }
                else if(textlength3 < 0)
                {
                    a3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
        });

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
        a1.setText("");
        a2.setText("");
        a3.setText("");
        answer1.setText("");
        a1.requestFocus();
        response.setVisibility(View.INVISIBLE);
        anstxt.setText("");
        op1= getOp1();
        op2 = 0;
        op3= 0;
        operand1 = op1 * 100 + op2 * 10 + op3;

        op4 = getOp4();
        op5= getOp5();
        op6 = getOp6();

        if(op1-1 <= op4){
            selectQuestion();
        }
        else {
            operand2 = op4 * 100 + op5 * 10 + op6;
            quest_number.setText("Q" + qid);
            question.setText("" + operand1 + "-" + operand2 + "= ?");
            answer = operand1 - operand2;
            Log.e("tag", "answer" + answer);

            o1.setText("" + operand2);
            o6.setText("" + operand1);
            o7.setText("" + operand2);
            o8.setText("" + operand1);

            //  op7 = op4 * 10;
            op7 = operand2 / 10;
            op8 = op7 + 1;
            operand3 = op8 * 10;
            o2.setText("" + operand3);
            o3.setText("" + operand3);

            op9 = op4 + 1;
            operand4 = op9 * 100;
            o4.setText("" + operand4);
            o5.setText("" + operand4);
            qid++;

        }
    }

    private int getOp4() {
        op4=random.nextInt(9 - 1) + 1;
        return op4;
    }

    private int getOp5() {
        op5=random.nextInt(9 - 0) + 0;
        return op5;
    }

    private int getOp6() {
        op6 = random.nextInt(9 - 1) + 1;
        return op6;
    }

    private int getOp1() {
        op1=random.nextInt(9 - 3) + 3;
        return op1;
    }

    private void gotoNextActivity() {
        Intent intent=new Intent(level19.this,last.class);
        Bundle b= new Bundle();
        b.putInt("qid",qid);
        b.putInt("score",score);
        intent.putExtras(b);
        startActivity(intent);
        finish();

    }
    public void showDialog(String messageText)
    {
        LayoutInflater inflater = LayoutInflater.from(level19.this);
        View subView = inflater.inflate(R.layout.dialog_with_input, null);
        TextView textMessage = (TextView) subView.findViewById(R.id.dialog_message);
        final AlertDialog.Builder builder = new AlertDialog.Builder(level19.this);
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
            enteredAnswer  = answer1.getText().toString().trim();

            Spannable wordTwo = new SpannableString("Try again.!");
            wordTwo.setSpan(new ForegroundColorSpan(Color.RED), 0, wordTwo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            if (enteredAnswer.equals("")){
                showDialog("Please enter all answer fields");
            }
            else{
                enteredAnswer1 = Integer.parseInt(enteredAnswer);

                if (enteredAnswer1 == answer) {
                    wrong=0;
                    score++;
                    response.setBackgroundResource(R.drawable.tick1);
                    response.setVisibility(View.VISIBLE);
                    Log.e("tag","score"+ score);
                    Log.e("tag","wrong"+ wrong);
                    responsetxt.setTextColor(getResources().getColor(R.color.dark_green));
                    responsetxt.setText("Correct Answer");
                    responsetxt.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            response.setVisibility(View.INVISIBLE);
                            responsetxt.setVisibility(View.VISIBLE);
                            responsetxt.setText("");
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
                    responsetxt.setText(wordTwo);
                    responsetxt.setVisibility(View.VISIBLE);

                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            response.setVisibility(View.INVISIBLE);
                            responsetxt.setText("");
                            answer1.setText("");
                            a1.setText("");
                            a2.setText("");
                            a3.setText("");
                            a1.requestFocus();

                            responsetxt.setVisibility(View.INVISIBLE);
                        }
                    }, 1500);
                }

                else {
                    wrong=0;
                    Log.e("tag","ans"+ operand2);
                    response.setBackgroundResource(R.drawable.cross1);
                    response.setVisibility(View.VISIBLE);
                    responsetxt.setTextColor(getResources().getColor(R.color.textBlack));
                    responsetxt.setText("The Answer is");
                    anstxt.setTextColor(getResources().getColor(R.color.dark_green));
                    anstxt.setText(""+answer);
                    responsetxt.setVisibility(View.VISIBLE);
                    anstxt.setVisibility(View.VISIBLE);

                    new Handler().postDelayed(new Runnable() {
                        public void run() {

                            response.setVisibility(View.VISIBLE);
                            responsetxt.setVisibility(View.INVISIBLE);
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
