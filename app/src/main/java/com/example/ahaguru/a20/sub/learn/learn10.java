package com.example.Zapitor.a20.sub.learn;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.Zapitor.a20.R;

public class learn10 extends Activity {

    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn10);

        back = (ImageView)findViewById(R.id.back);

        backClickListener();
        addListenerOnMax10();
        addListenerOnMax20();
        addListenerOnMax50();
        addListenerOnMax100();

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

    private void addListenerOnMax50() {
        final Context context = this;
        Button max_ten = (Button) findViewById(R.id.max_50);
        max_ten.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, make_50.class);
                startActivity(intent);
            }
        });
    }

    private void addListenerOnMax100() {
        final Context context = this;
        Button max_ten = (Button) findViewById(R.id.max_100);
        max_ten.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, make_100.class);
                startActivity(intent);
            }
        });
    }

    private void addListenerOnMax20() {
        final Context context = this;
        Button max_ten = (Button) findViewById(R.id.max_20);
        max_ten.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, make_20.class);
                startActivity(intent);
            }
        });
    }


    private void addListenerOnMax10() {
        final Context context = this;
        Button max_ten = (Button) findViewById(R.id.max_10);
        max_ten.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, make_10.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }
}
