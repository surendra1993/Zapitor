package com.example.Zapitor.a20.sub;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.Zapitor.a20.R;
import com.example.Zapitor.a20.sub.learn.learn10;
import com.example.Zapitor.a20.sub.learn.learn11;
import com.example.Zapitor.a20.sub.learn.learn12;
import com.example.Zapitor.a20.sub.learn.learn13;
import com.example.Zapitor.a20.sub.learn.learn14;
import com.example.Zapitor.a20.sub.learn.learn15;
import com.example.Zapitor.a20.sub.learn.learn16;
import com.example.Zapitor.a20.sub.learn.learn17;
import com.example.Zapitor.a20.sub.learn.learn18;
import com.example.Zapitor.a20.sub.learn.learn2;
import com.example.Zapitor.a20.sub.learn.learn3;
import com.example.Zapitor.a20.sub.learn.learn4;
import com.example.Zapitor.a20.sub.learn.learn5;
import com.example.Zapitor.a20.sub.learn.learn6;
import com.example.Zapitor.a20.sub.learn.learn7;
import com.example.Zapitor.a20.sub.learn.learn8;
import com.example.Zapitor.a20.sub.learn.learn9;
import com.example.Zapitor.a20.sub.learn.level19;


public class sub_levels extends AppCompatActivity {

    Toolbar toolbar;
    TextView lesson1_id,lesson2_id,lesson3_id,lesson4_id,lesson5_id,lesson6_id,lesson7_id,lesson8_id,lesson9_id,
            lesson10_id,lesson11_id,lesson12_id,lesson13_id,lesson14_id,lesson15_id,lesson16_id,lesson17_id,lesson18_id,lesson19_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_levels);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("SUBTRACTION");
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        lesson2_learn();
        lesson3_learn();
        lesson4_learn();
        lesson5_learn();
        lesson6_learn();
        lesson9_learn();
        lesson8_learn();
        lesson7_learn();
        lesson11_learn();
        lesson12_learn();
        lesson13_learn();
        lesson14_learn();
        lesson15_learn();
        lesson16_learn();
        lesson17_learn();
        lesson18_learn();
        lesson10_learn();
        lesson19_learn();

    }

    private void lesson19_learn() {
        final Context context = this;
        lesson19_id = (TextView) findViewById(R.id.lesson19_id);
        lesson19_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, level19.class);
                startActivity(intent);
            }
        });
    }

    private void lesson10_learn() {
        final Context context = this;
        lesson10_id = (TextView) findViewById(R.id.lesson10_id);
        lesson10_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, learn10.class);
                startActivity(intent);
            }
        });
    }

    private void lesson18_learn() {
        final Context context = this;
        lesson18_id = (TextView) findViewById(R.id.lesson18_id);
        lesson18_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, learn18.class);
                startActivity(intent);
            }
        });
    }

    private void lesson17_learn() {
        final Context context = this;
        lesson17_id = (TextView) findViewById(R.id.lesson17_id);
        lesson17_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, learn17.class);
                startActivity(intent);
            }
        });
    }

    private void lesson16_learn() {
        final Context context = this;
        lesson16_id = (TextView) findViewById(R.id.lesson16_id);
        lesson16_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, learn16.class);
                startActivity(intent);
            }
        });
    }

    private void lesson15_learn() {
        final Context context = this;
        lesson15_id = (TextView) findViewById(R.id.lesson15_id);
        lesson15_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, learn15.class);
                startActivity(intent);
            }
        });
    }

    private void lesson14_learn() {
        final Context context = this;
        lesson14_id = (TextView) findViewById(R.id.lesson14_id);
        lesson14_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, learn14.class);
                startActivity(intent);
            }
        });
    }

    private void lesson13_learn() {
        final Context context = this;
        lesson13_id = (TextView) findViewById(R.id.lesson13_id);
        lesson13_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, learn13.class);
                startActivity(intent);
            }
        });
    }

    private void lesson12_learn() {
        final Context context = this;
        lesson12_id = (TextView) findViewById(R.id.lesson12_id);
        lesson12_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, learn12.class);
                startActivity(intent);
            }
        });
    }

    private void lesson7_learn() {
        final Context context = this;
        lesson7_id = (TextView) findViewById(R.id.lesson7_id);
        lesson7_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, learn7.class);
                startActivity(intent);
            }
        });
    }

    private void lesson11_learn() {
        final Context context = this;
        lesson11_id = (TextView) findViewById(R.id.lesson11_id);
        lesson11_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, learn11.class);
                startActivity(intent);
            }
        });
    }

    private void lesson8_learn() {
        final Context context = this;
        lesson8_id = (TextView) findViewById(R.id.lesson8_id);
        lesson8_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, learn8.class);
                startActivity(intent);
            }
        });
    }

    private void lesson6_learn() {
        final Context context = this;
        lesson6_id = (TextView) findViewById(R.id.lesson6_id);
        lesson6_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, learn6.class);
                startActivity(intent);
            }
        });
    }

    private void lesson9_learn() {
        final Context context = this;
        lesson9_id = (TextView) findViewById(R.id.lesson9_id);
        lesson9_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, learn9.class);
                startActivity(intent);
            }
        });
    }

    private void lesson5_learn() {
        final Context context = this;
        lesson5_id = (TextView) findViewById(R.id.lesson5_id);
        lesson5_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, learn5.class);
                startActivity(intent);
            }
        });
    }

    private void lesson4_learn() {
        final Context context = this;
        lesson4_id = (TextView) findViewById(R.id.lesson4_id);
        lesson4_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, learn4.class);
                startActivity(intent);
            }
        });
    }

    private void lesson3_learn() {
        final Context context = this;
        lesson3_id = (TextView) findViewById(R.id.lesson3_id);
        lesson3_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, learn3.class);
                startActivity(intent);
            }
        });
    }

    private void lesson2_learn() {
        final Context context = this;
        lesson2_id = (TextView) findViewById(R.id.lesson2_id);
        lesson2_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, learn2.class);
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
