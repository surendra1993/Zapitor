package com.example.Zapitor.a20.sub.learn;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.example.Zapitor.a20.R;

public class last extends AppCompatActivity {

    TextView scoretxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        scoretxt =(TextView)findViewById(R.id.score);

        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");

        Spannable wordTwo = new SpannableString(""+score);
        wordTwo.setSpan(new ForegroundColorSpan(Color.GREEN), 0, wordTwo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        int qid = b.getInt("qid");
        scoretxt.setText("You got "+ wordTwo + " / 10 Correct");
    }
}
