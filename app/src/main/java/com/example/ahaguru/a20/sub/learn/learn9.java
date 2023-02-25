package com.example.Zapitor.a20.sub.learn;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
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

public class learn9 extends Activity implements View.OnClickListener {

    String ea1,ea2,ea3,ea4,ea5;
    int qid = 1,score=0,mins,secs,wrong=0,op1=0,op2=0,operand1,operand2,op3=0,op4=0,op5=0,op6=0,
                               answer,enteredAnswer1,enteredAnswer2,enteredAnswer3,
                               enteredAnswer,enteredAnswer4,enteredAnswer5,opd1,opd2;
    TextView h;
    Random random;
    ImageView response,back;
    TextView question,responseT,responseTxt,lesson_name,quest_number;
    CustomKeyboard mCustomKeyboard;
    Button btn_sub;
    EditText carry1,carry2,carry3,unit_ques1,ten_ques1,hund_ques1,unit_ques2,
            ten_ques2,hund_ques2,unit_ans,ten_ans,hund_ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_input);
        h =  (TextView)findViewById(R.id.h);
        back = (ImageView)findViewById(R.id.back);
        response = (ImageView)findViewById(R.id.response);
        lesson_name = (TextView)findViewById(R.id.lesson_name);
        question = (TextView)findViewById(R.id.question);
        quest_number = (TextView)findViewById(R.id.quest_number);
        responseT = (TextView)findViewById(R.id.responseT);
        responseTxt = (TextView)findViewById(R.id.responseTxt);
        btn_sub = (Button)findViewById(R.id.btn_sub);

        carry1 = (EditText)findViewById(R.id.carry1);
        carry2 = (EditText)findViewById(R.id.carry2);
        carry3 = (EditText)findViewById(R.id.carry3);
        unit_ques1 = (EditText)findViewById(R.id.unit_ques1);
        unit_ques2 = (EditText)findViewById(R.id.unit_ques2);
        ten_ques1 = (EditText)findViewById(R.id.ten_ques1);
        ten_ques2 = (EditText)findViewById(R.id.ten_ques2);
        hund_ques1 = (EditText)findViewById(R.id.hund_ques1);
        hund_ques2 = (EditText)findViewById(R.id.hund_ques2);
        hund_ans = (EditText)findViewById(R.id.hund_ans);
        ten_ans = (EditText)findViewById(R.id.ten_ans);
        unit_ans = (EditText)findViewById(R.id.unit_ans);
        lesson_name.setText("Lesson 9");

        mCustomKeyboard= new CustomKeyboard(this, R.id.keyboardview, R.xml.number );
        mCustomKeyboard.registerEditText(R.id.unit_ques1);
        mCustomKeyboard.registerEditText(R.id.unit_ques2);
        mCustomKeyboard.registerEditText(R.id.ten_ques1);
        mCustomKeyboard.registerEditText(R.id.ten_ques2);
        mCustomKeyboard.registerEditText(R.id.hund_ques1);
        mCustomKeyboard.registerEditText(R.id.hund_ques2);

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
        response.setVisibility(View.INVISIBLE);
        responseTxt.setText("");
        unit_ques2.setTextColor(getResources().getColor(R.color.textBlack));
        unit_ques1.setTextColor(getResources().getColor(R.color.textBlack));
        ten_ques1.setTextColor(getResources().getColor(R.color.textBlack));
        ten_ques2.setTextColor(getResources().getColor(R.color.textBlack));
        hund_ques1.setTextColor(getResources().getColor(R.color.textBlack));
        hund_ques2.setTextColor(getResources().getColor(R.color.textBlack));
        hund_ques1.setText("");
        ten_ques1.setText("");
        unit_ques1.setText("");
        unit_ques2.setText("");
        ten_ques2.setText("");
        hund_ques2.setText("");
        operand1=getOperand1();
        operand2=getOperand2();
        op1= operand1 / 10;
        op2 = operand1 % 10;
        op5= op1 / 10;
        op6= op1 % 10;
        op3= operand2 / 10;
        op4 = operand2 % 10;

        quest_number.setText("Q+qid");
        question.setText("Place"+"\t"+operand1 + " - " + operand2+"\t"+"in the correct boxes.");
        answer = operand1 - operand2;
        Log.e("tag"," Answer" +answer);
        qid++;
    }

    private int getOperand2() {
        operand2= random.nextInt(99 - 10) + 10;
        return operand2;
    }

    private int getOperand1() {
        operand1= random.nextInt(999 - 101) + 101;
        return operand1;
    }

    private void gotoNextActivity() {
        Intent intent=new Intent(learn9.this,last.class);
        Bundle b= new Bundle();
        b.putInt("qid",qid);
        b.putInt("score",score);
        intent.putExtras(b);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        ea1  = unit_ques1.getText().toString().trim();
        ea2  = ten_ques1.getText().toString().trim();
        ea3  = unit_ques2.getText().toString().trim();
        ea4  = ten_ques2.getText().toString().trim();
        ea5  =  hund_ques1.getText().toString().trim();
        if (ea1.equals("") || ea2.equals("") || ea3.equals("") || ea4.equals("") || ea5.equals("")) {

            if(wrong == 0) {
                wrong++;
                responseTxt.setText("Try again");
                responseTxt.setTextColor(getResources().getColor(R.color.red));
                response.setBackgroundResource(R.drawable.cross1);
                response.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        responseTxt.setText("");
                        hund_ques2.setText("");
                        ten_ques2.setText("");
                        unit_ques2.setText("");
                        hund_ques1.setText("");
                        unit_ques1.setText("");
                        ten_ques1.setText("");
                        response.setVisibility(View.INVISIBLE);
                    }
                }, 1500);
            }

            else if (wrong >= 1){
                wrong = 0;
                responseTxt.setText("Again wrong");
                responseTxt.setTextColor(getResources().getColor(R.color.red));
                response.setBackgroundResource(R.drawable.cross1);
                response.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        responseTxt.setText("Correct Answer");
                        responseTxt.setTextColor(getResources().getColor(R.color.dark_green));
                        response.setBackgroundResource(R.drawable.left);
                        hund_ques1.setText("");
                        hund_ques2.setText("");
                        ten_ques2.setText("");
                        hund_ques1.setTextColor(getResources().getColor(R.color.dark_green));
                        hund_ques1.setText(""+op5);
                        ten_ques2.setTextColor(getResources().getColor(R.color.dark_green));
                        ten_ques2.setText(""+op3);
                        unit_ques2.setTextColor(getResources().getColor(R.color.dark_green));
                        unit_ques2.setText(""+op4);
                        unit_ques1.setTextColor(getResources().getColor(R.color.dark_green));
                        unit_ques1.setText(""+op2);
                        ten_ques1.setTextColor(getResources().getColor(R.color.dark_green));
                        ten_ques1.setText(""+op6);
                    }
                },1000);

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        if(qid < 11) {
                            selectQuestion();
                        }
                        else
                        {
                            gotoNextActivity();
                        }
                    }
                }, 3000);
            }
            return;
        }

        else{
            enteredAnswer1 = Integer.parseInt(ea1);
            enteredAnswer2 = Integer.parseInt(ea2);
            enteredAnswer3 = Integer.parseInt(ea3);
            enteredAnswer4 = Integer.parseInt(ea4);
            enteredAnswer5 = Integer.parseInt(ea5);
            opd1 = enteredAnswer5 * 100 + enteredAnswer2 * 10 + enteredAnswer1;
            opd2 = enteredAnswer4 * 10 + enteredAnswer3;
            enteredAnswer = opd1 - opd2;
            Log.e("tag","entered Answer" + enteredAnswer);
            if(enteredAnswer == answer) {
                wrong = 0;
                score++;
                responseTxt.setText("Correct");
                responseTxt.setTextColor(getResources().getColor(R.color.dark_green));
                response.setBackgroundResource(R.drawable.tick1);
                response.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        if (qid < 11) {
                            selectQuestion();
                        } else {
                            gotoNextActivity();
                        }
                    }
                }, 1500);
            }

            else if(wrong == 0){
                wrong++;
                responseTxt.setText("Try again");
                responseTxt.setTextColor(getResources().getColor(R.color.red));
                response.setBackgroundResource(R.drawable.cross1);
                response.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        responseTxt.setText("");
                        hund_ques2.setText("");
                        ten_ques2.setText("");
                        unit_ques2.setText("");
                        hund_ques1.setText("");
                        unit_ques1.setText("");
                        ten_ques1.setText("");
                        response.setVisibility(View.INVISIBLE);
                    }
                }, 1500);
            }

            else{
                wrong = 0;
                responseTxt.setText("Again Wrong");
                responseTxt.setTextColor(getResources().getColor(R.color.red));
                response.setBackgroundResource(R.drawable.cross1);
                response.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        responseTxt.setText("Correct Answer");
                        responseTxt.setTextColor(getResources().getColor(R.color.dark_green));
                        response.setBackgroundResource(R.drawable.left);
                        hund_ques1.setText("");
                        hund_ques2.setText("");
                        ten_ques2.setText("");
                        hund_ques1.setTextColor(getResources().getColor(R.color.dark_green));
                        hund_ques1.setText(""+op5);
                        ten_ques2.setTextColor(getResources().getColor(R.color.dark_green));
                        ten_ques2.setText(""+op3);
                        unit_ques2.setTextColor(getResources().getColor(R.color.dark_green));
                        unit_ques2.setText(""+op4);
                        unit_ques1.setTextColor(getResources().getColor(R.color.dark_green));
                        unit_ques1.setText(""+op2);
                        ten_ques1.setTextColor(getResources().getColor(R.color.dark_green));
                        ten_ques1.setText(""+op6);
                    }
                },1000);

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        if(qid < 11) {
                            selectQuestion();
                        }
                        else
                        {
                            gotoNextActivity();
                        }
                    }
                }, 3000);
            }
        }

    }
}
