package com.example.kochimymetro;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class metrofare extends AppCompatActivity {


    TextView t1, t2, t3;

    String ary[] = {

            "1. All fare are in Indian Rupees."
    };

    String arry[] = {
            "2. The tickets is valid for exit at destination station Automatic gate up to 90 minutes" +
                    "after entry through automatic gate at origin station. in case of same station entry and " +
                    "exit, ticket is valid only for 20 minutes after entry though automatic Gate. "};
    String arya[] = {
            "3. For more details, please refer http://kochimetro.org or public notice on kochi metro fares."
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metrofare);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        t1 = (TextView) findViewById(R.id.textView);
        for (int i = 0; i < ary.length; i++) {
            t1.setText(ary[i]);
        }

        t2 = (TextView) findViewById(R.id.textView3);
        for (int i = 0; i < arry.length; i++) {
            t2.setText(arry[i]);
        }

        t3 = (TextView) findViewById(R.id.textView4);
        for (int i = 0; i < arya.length; i++) {
            t3.setText(arya[i]);
        }


    }


}
