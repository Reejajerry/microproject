package com.example.kochimymetro;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton b,b1,b2,b3,b4,b6,b5,b7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(ImageButton)findViewById(R.id.imageButton8);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent(MainActivity.this,metrofare.class);
                startActivity(in);
            }
        });

        b6=(ImageButton)findViewById(R.id.imageButton6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent i= new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com/maps/search/metrostations+/@10.0459887,76.3178712,12z"));
                startActivity(i);
            }
        });
        b3=(ImageButton)findViewById(R.id.imageButton3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in =new Intent(MainActivity.this,metrotrains.class);
                startActivity(in);
            }
        });


        b=(ImageButton)findViewById(R.id.imageButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent in = new Intent(MainActivity.this,MetroAbout.class);
                startActivity(in);
            }
        });

        b4=(ImageButton)findViewById(R.id.imageButton4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,Metrosmartcard.class);
                startActivity(in);

            }
        });


        b5=(ImageButton)findViewById(R.id.imageButton5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,Metropassenger.class);
                startActivity(in);

            }
        });

        b2=(ImageButton)findViewById(R.id.imageButton2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,Metrostations.class);
                startActivity(in);

            }
        });

        b7=(ImageButton)findViewById(R.id.imageButton7);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.youtube.com/watch?v=WVVbdx3XgWA"));
                startActivity(i);
            }
        });


    }


    }
