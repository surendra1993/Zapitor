package com.example.Zapitor.a20;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.Zapitor.a20.sub.sub_levels;

public class MainActivity extends AppCompatActivity {

    Button add,sub,mul,div;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonSub();
    }

    private void addListenerOnButtonSub() {
        final Context context = this;
        sub = (Button) findViewById(R.id.sub);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, sub_levels.class);
                startActivity(intent);
            }
        });
    }
}
