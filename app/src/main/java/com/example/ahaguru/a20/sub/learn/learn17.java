package com.example.Zapitor.a20.sub.learn;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Zapitor.a20.R;

import java.util.Random;

/**
 * Created by Zapitor on 19-12-2016.
 */

public class learn17 extends Activity implements View.OnClickListener {

    String ea1,ea2,ea3;
    int qid = 1,score=0,mins,secs,wrong=0,op1=0,op2=0,op3=0,op4=0,op5=0,op6=0,op7=0,text=0;
    private int answer=0,operand1=0,operand2=0;
    private Random random;
    CustomKeyboard mCustomKeyboard;
    private int enteredAnswer = 0,enteredAnswer1=0,enteredAnswer2=0,enteredAnswer3=0;
    private ImageView response,back;
    private EditText hund_ans,unit_ans,ten_ans,carry1,carry3,carry4;
    private Button btn_sub;
    private ObliqueStrikeTextView hund_ques1,ten_ques1,unit_ques1;
    private ObliqueStrikeEditText carry2;
    private TextView responseTxt,question,lesson_name,hund_ques2,ten_ques2,unit_ques2,responseT,h,quest_number;
    Animation animBlink ,animBlink1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn2);
        lesson_name = (TextView)findViewById(R.id.lesson_name);
        lesson_name.setText("Lesson 17");

        animBlink = AnimationUtils.loadAnimation(getApplicationContext() , R.anim.blink);
        animBlink1 = AnimationUtils.loadAnimation(getApplicationContext() , R.anim.blink);

        question = (TextView)findViewById(R.id.question);
        quest_number = (TextView)findViewById(R.id.quest_number);
        carry1 = (EditText)findViewById(R.id.carry1);
        carry1.setBackgroundResource(R.drawable.disable_carry);

        carry2 = (ObliqueStrikeEditText) findViewById(R.id.carry2);
        carry2.setBackgroundResource(R.drawable.disable_carry);

        carry3 = (EditText)findViewById(R.id.carry3);
        carry3.setBackgroundResource(R.drawable.disable_carry);

        carry4 = (EditText)findViewById(R.id.carry4);
        carry4.setBackgroundResource(R.drawable.disable_carry);

        unit_ques1 = (ObliqueStrikeTextView) findViewById(R.id.unit_ques1);
        ten_ques1 = (ObliqueStrikeTextView) findViewById(R.id.ten_ques1);
        hund_ques1 = (ObliqueStrikeTextView) findViewById(R.id.hund_ques1);
        unit_ques2 = (TextView)findViewById(R.id.unit_ques2);
        ten_ques2 = (TextView)findViewById(R.id.ten_ques2);
        hund_ques2 = (TextView)findViewById(R.id.hund_ques2);
        unit_ans = (EditText)findViewById(R.id.unit_ans);
        ten_ans = (EditText)findViewById(R.id.ten_ans);
        hund_ans = (EditText)findViewById(R.id.hund_ans);
        back = (ImageView)findViewById(R.id.back);
        response = (ImageView)findViewById(R.id.response);
        responseT = (TextView)findViewById(R.id.responseT);
        responseTxt = (TextView)findViewById(R.id.responseTxt);
        h = (TextView)findViewById(R.id.h);
        btn_sub = (Button)findViewById(R.id.btn_sub);
        response.setVisibility(View.INVISIBLE);
        responseT.setVisibility(View.INVISIBLE);
        responseTxt.setVisibility(View.INVISIBLE);
        backClickListener();
        btn_sub.setOnClickListener(this);

        mCustomKeyboard= new CustomKeyboard(this, R.id.keyboardview, R.xml.number );
        mCustomKeyboard.registerEditText(R.id.unit_ans);
        mCustomKeyboard.registerEditText(R.id.ten_ans);
        mCustomKeyboard.registerEditText(R.id.hund_ans);
        mCustomKeyboard.registerEditText(R.id.carry2);
        mCustomKeyboard.registerEditText(R.id.carry3);
        mCustomKeyboard.registerEditText(R.id.carry1);
        mCustomKeyboard.registerEditText(R.id.carry4);

        hund_ques1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                hund_ques1.setStroke();
                hund_ques1.clearAnimation();
                carry1.setBackgroundResource(R.drawable.editcarry_style);
                carry1.setCursorVisible(true);
                carry1.setFocusableInTouchMode(true);
                carry1.requestFocus();
            }
        });
        carry1.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                Integer textlength1 = carry1.getText().length();
                if(text == 0) {
                    if (textlength1 > 0) {
                        carry1.setCursorVisible(false);
                        ten_ques1.startAnimation(animBlink);

                    } else if (textlength1 < 0) {
                        carry3.requestFocus();
                    }
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
        ten_ques1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ten_ques1.setStroke();
                ten_ques1.clearAnimation();
                carry2.setBackgroundResource(R.drawable.editcarry_style);
                carry2.setFocusableInTouchMode(true);
                carry2.setText("10");
//                carry2.setUnStroke2();
                carry2.setStroke1();
                carry4.setBackgroundResource(R.drawable.editcarry_style);
                carry4.setCursorVisible(true);
                carry4.setFocusableInTouchMode(true);
                carry4.requestFocus();
            }
        });
        carry4.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                Integer textlength1 = carry4.getText().length();

                if (textlength1 > 0) {
                    carry4.setCursorVisible(false);
                    unit_ques1.startAnimation(animBlink);
                }
                else if(textlength1 < 0)
                {
                    carry4.requestFocus();

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
        unit_ques1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                unit_ques1.setStroke();
                unit_ques1.clearAnimation();
                carry3.setBackgroundResource(R.drawable.editcarry_style);
                carry3.setFocusableInTouchMode(true);
                carry3.requestFocus();
            }
        });
        carry3.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                Integer textlength1 = carry3.getText().length();

                if (textlength1 > 1) {
                    unit_ques1.setBackgroundResource(R.drawable.disable_editstyle);
                    unit_ans.setBackgroundResource(R.drawable.editanswer_style);
                    unit_ans.setFocusableInTouchMode(true);
                    unit_ans.requestFocus();
                }
                else if(textlength1 < 0)
                {
                    carry3.requestFocus();

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

        unit_ans.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                Integer textlength3 = unit_ans.getText().length();

                if(text == 0) {
                    if (textlength3 > 0) {
                        carry2.setBackgroundResource(R.drawable.disable_carry);
                        ten_ques1.setBackgroundResource(R.drawable.disable_editstyle);
                        ten_ans.setBackgroundResource(R.drawable.editanswer_style);
                        ten_ans.setFocusableInTouchMode(true);
                        ten_ans.requestFocus();
                    } else if (textlength3 < 0) {
                        unit_ans.requestFocus();
                    }
                }

                else if(text > 0){
                    if (textlength3 > 0) {
                        if (textlength3 > 0) {
                            ten_ques1.setBackgroundResource(R.drawable.disable_editstyle);
                            ten_ans.setBackgroundResource(R.drawable.editanswer_style);
                            ten_ans.setFocusableInTouchMode(true);
                            ten_ans.requestFocus();
                        } else if (textlength3 < 0) {
                            unit_ans.requestFocus();
                        }
                    }
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

        ten_ans.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

                Integer textlength1 = ten_ans.getText().length();

                if (textlength1 > 0) {
                    hund_ques1.setBackgroundResource(R.drawable.disable_editstyle);
                    hund_ans.setBackgroundResource(R.drawable.editanswer_style);
                    hund_ans.setFocusableInTouchMode(true);
                    hund_ans.requestFocus();
                }
                else if(textlength1 < 0)
                {
                    ten_ans.requestFocus();

                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
        });

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
        op1= getOp1();
        op2 = getOp2();
        op3= getOp3();
        op4= getOp4();
        op5 = getOp5();
        op6 = getOp6();
        text= 0;
        responseTxt.setText("");
        unit_ans.setText("");
        ten_ans.setText("");
        hund_ans.setText("");
        carry1.setText("");
        carry2.setText("");
        carry3.setText("");
        carry4.setText("");
        unit_ques1.setBackgroundResource(R.drawable.edittext_style);
        ten_ques1.setBackgroundResource(R.drawable.edittext_style);
        hund_ques1.setBackgroundResource(R.drawable.edittext_style);
        carry2.setBackgroundResource(R.drawable.editcarry_style);
        unit_ans.setBackgroundResource(R.drawable.disable_answer);
        hund_ans.setBackgroundResource(R.drawable.disable_answer);
        ten_ans.setBackgroundResource(R.drawable.disable_answer);
        unit_ans.setFocusable(false);
        ten_ans.setFocusable(false);
        hund_ans.setFocusable(false);
        carry3.setFocusable(false);
        carry2.setFocusable(false);
        carry1.setFocusable(false);
        carry4.setFocusable(false);
        carry1.setBackgroundResource(R.drawable.disable_carry);
        carry2.setBackgroundResource(R.drawable.disable_carry);
        carry3.setBackgroundResource(R.drawable.disable_carry);
        carry4.setBackgroundResource(R.drawable.disable_carry);
        hund_ques1.setAnimation(animBlink);
        quest_number.setText("Q"+qid);

        // if unit digits of question 1 and 2 are equal
        if(op1 == op4)
        {
            if(op1 > 8){          // if unit digits are 9
                op1 = op1 - 1;
            }
            else if(op1 < 2 ){    //  if unit digits are 1
                op4 = op4 + 1;
            }
            else {               // if unit digits are 2 to 8
                op4 = op4 + 1 ;
            }
        }
        //if ten digits of question 1 and 2 are equal
        if(op2 == op5)
        {
            if(op2 > 8){          // if unit digits are 9
                op2 = op2 - 1;
            }
            else if(op2 < 2 ){    //  if unit digits are 1
                op5 = op5 + 1;
            }
            else {               // if unit digits are 2 to 8
                op5 = op5 + 1 ;
            }
        }
        //if hundred digits of question 1 and 2 are equal
        if(op3 == op6){
            op6 = op6 - 1;
        }

        if(op1 < op4)
        {
            if(op2 < op5) {

                if (op3 >= op6) {
                    operand1 = op3 * 100 + op2 * 10 + op1;
                    operand2 = op6 * 100 + op5 * 10 + op4;
                    unit_ques1.setText("" + op1);
                    ten_ques1.setText("" + op2);
                    hund_ques1.setText("" + op3);
                    unit_ques2.setText("" + op4);
                    ten_ques2.setText("" + op5);
                    hund_ques2.setText("" + op6);
                }
                else {
                    operand1 = op6 * 100 + op2 * 10 + op1;
                    operand2 = op3 * 100 + op5 * 10 + op4;
                    unit_ques1.setText("" + op1);
                    ten_ques1.setText("" + op2);
                    hund_ques1.setText(""+ op6);
                    unit_ques2.setText("" + op4);
                    ten_ques2.setText("" + op5);
                    hund_ques2.setText("" + op3);
                }
            }
            else if( op2 > op5)
            {
                if (op3 >= op6) {

                    operand1 = op3 * 100 + op5 * 10 + op1;
                    operand2 = op6 * 100 + op2 * 10 + op4;
                    unit_ques1.setText("" + op1);
                    ten_ques1.setText("" + op5);
                    hund_ques1.setText("" + op3 );
                    unit_ques2.setText("" + op4);
                    ten_ques2.setText("" + op2);
                    hund_ques2.setText("" + op6);
                }
                else{
                    operand1 = op6 * 100 + op5 * 10 + op1;
                    operand2 = op3 * 100 + op2 * 10 + op4;
                    unit_ques1.setText("" + op1);
                    ten_ques1.setText("" + op5);
                    hund_ques1.setText("" + op6 );
                    unit_ques2.setText("" + op4);
                    ten_ques2.setText("" + op2);
                    hund_ques2.setText("" + op3);
                }
            }
        }
        else if(op1 > op4)
        {
            if (op2 < op5) {

                if (op3 >= op6) {
                    operand1 = op3 * 100 + op2 * 10 + op4;
                    operand2 = op6 * 100 + op5 * 10 + op1;
                    unit_ques1.setText("" + op4);
                    ten_ques1.setText("" + op2);
                    hund_ques1.setText("" + op3);
                    unit_ques2.setText("" + op1);
                    ten_ques2.setText("" + op5);
                    hund_ques2.setText("" + op6);
                }
                else
                {
                    operand1 = op6 * 100 + op2 * 10 + op4;
                    operand2 = op3 * 100 + op5 * 10 + op1;
                    unit_ques1.setText("" + op4);
                    ten_ques1.setText("" + op2);
                    hund_ques1.setText("" + op6);
                    unit_ques2.setText("" + op1);
                    ten_ques2.setText("" + op5);
                    hund_ques2.setText("" + op3);
                }
            }
            else if(op2 > op5){

                if(op3 >= op6 ) {

                    operand1 = op3 * 100 + op5 * 10 + op4;
                    operand2 = op6 * 100 + op2 * 10 + op1;
                    unit_ques1.setText("" + op4);
                    ten_ques1.setText("" + op5);
                    hund_ques1.setText("" + op3);
                    unit_ques2.setText("" + op1);
                    ten_ques2.setText("" + op2);
                    hund_ques2.setText("" + op6);
                }
                else{
                    operand1 = op6 * 100 + op5 * 10 + op4;
                    operand2 = op3 * 100 + op2 * 10 + op1;
                    unit_ques1.setText("" + op4);
                    ten_ques1.setText("" + op5);
                    hund_ques1.setText("" + op6);
                    unit_ques2.setText("" + op1);
                    ten_ques2.setText("" + op2);
                    hund_ques2.setText("" + op3);
                }
            }
        }

        question.setText(operand1 + " - " + operand2 + " = \t ?");
        answer = operand1 - operand2;
        carry2.setUnStroke1();
        hund_ques1.setUnStroke();
        ten_ques1.setUnStroke();
        unit_ques1.setUnStroke();

        qid++;
    }
    private int getOp6() {
        op6 = random.nextInt(9 - 1) + 1;
        return op6;
    }

    private int getOp3() {
        op3 = random.nextInt(9 - 1) + 1;
        return op3;
    }

    private int getOp5() {
        op5 = random.nextInt(9 - 1) + 1;
        return op5;
    }

    private int getOp4() {
        op4 = random.nextInt(9 - 1) + 1;
        return op4;
    }

    private int getOp2() {
        op2 = 0;
        return op2;
    }

    private int getOp1() {
        op1 = 0;
        return op1;
    }

    private void gotoNextActivity() {
        Intent intent=new Intent(learn17.this,last.class);
        Bundle b= new Bundle();
        b.putInt("qid",qid);
        b.putInt("score",score);
        intent.putExtras(b);
        startActivity(intent);
        finish();

    }
    public void showDialog(String messageText)
    {
        LayoutInflater inflater = LayoutInflater.from(learn17.this);
        View subView = inflater.inflate(R.layout.dialog_with_input, null);
        TextView textMessage = (TextView) subView.findViewById(R.id.dialog_message);
        final AlertDialog.Builder builder = new AlertDialog.Builder(learn17.this);
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

            ea1  = unit_ans.getText().toString().trim();
            ea2  = ten_ans.getText().toString().trim();
            ea3  = hund_ans.getText().toString().trim();

            Spannable wordTwo = new SpannableString("Try again.!");
            wordTwo.setSpan(new ForegroundColorSpan(Color.RED), 0, wordTwo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

           if (ea1.equals("") || ea2.equals("") || ea3.equals("")) {
                showDialog("Please enter a valid answer");
            }

            else {
               enteredAnswer1 = Integer.parseInt(ea1);
               enteredAnswer2 = Integer.parseInt(ea2);
               enteredAnswer3 = Integer.parseInt(ea3);
               enteredAnswer = enteredAnswer3 * 100 + enteredAnswer2 * 10 + enteredAnswer1;

               if (enteredAnswer == answer) {
                   wrong = 0;
                   score++;
                   Log.e("tag", "score" + score);
                   Log.e("tag", "wrong" + wrong);
                   responseT.setText("Correct");
                   responseT.setTextColor(getResources().getColor(R.color.dark_green));
                   responseT.setVisibility(View.VISIBLE);
                   response.setImageResource(R.drawable.tick1);
                   response.setVisibility(View.VISIBLE);
                   new Handler().postDelayed(new Runnable() {
                       public void run() {
                           responseT.setVisibility(View.VISIBLE);
                           response.setVisibility(View.INVISIBLE);
                           responseT.setText("");
                           if (qid < 10) {
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
                   new Handler().postDelayed(new Runnable() {
                       public void run() {
                           carry1.setText("");
                           carry2.setText("");
                           carry3.setText("");
                           carry4.setText("");
                           responseT.setText("");
                           unit_ans.setText("");
                           ten_ans.setText("");
                           hund_ans.setText("");
                           hund_ans.setFocusable(false);
                           ten_ans.setFocusable(false);
                           unit_ans.setFocusable(false);
                           hund_ques1.setBackgroundResource(R.drawable.edittext_style);
                           ten_ques1.setBackgroundResource(R.drawable.edittext_style);
                           ten_ques1.setUnStroke();
                           carry2.setUnStroke1();
                           unit_ques1.setBackgroundResource(R.drawable.edittext_style);
                           unit_ques1.setUnStroke();
                           hund_ques1.setUnStroke();
                           carry2.setBackgroundResource(R.drawable.disable_carry);
                           carry3.setBackgroundResource(R.drawable.disable_carry);
                           carry4.setBackgroundResource(R.drawable.disable_carry);
                           carry1.setBackgroundResource(R.drawable.disable_carry);
                           carry1.setFocusable(false);
                           carry2.setFocusable(false);
                           carry3.setFocusable(false);
                           carry4.setFocusable(false);
                           ten_ans.setBackgroundResource(R.drawable.disable_answer);
                           hund_ans.setBackgroundResource(R.drawable.disable_answer);
                           unit_ans.setBackgroundResource(R.drawable.disable_answer);
                           hund_ques1.startAnimation(animBlink);
                           response.setVisibility(View.INVISIBLE);
                           responseT.setVisibility(View.INVISIBLE);

                       }
                   }, 1500);
               } else {
                   wrong = 0;
                   Log.e("tag", "ans" + answer);
                   responseTxt.setText("" + answer);
                   responseTxt.setVisibility(View.VISIBLE);
                   responseT.setText("Answer");
                   responseT.setTextColor(getResources().getColor(R.color.textBlack));
                   responseT.setVisibility(View.VISIBLE);
                   response.setImageResource(R.drawable.cross1);
                   response.setVisibility(View.VISIBLE);
                   new Handler().postDelayed(new Runnable() {
                       public void run() {
                           response.setVisibility(View.INVISIBLE);
                           responseT.setVisibility(View.INVISIBLE);
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
