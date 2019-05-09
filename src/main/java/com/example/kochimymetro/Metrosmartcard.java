    package com.example.kochimymetro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Metrosmartcard extends AppCompatActivity {
    Spinner s1,s2;
    Button b1;
    EditText name,nid,add,mail,mob,dob;
    RadioGroup rg;
    RadioButton rb;
    SQLiteDatabase db;

    String list1[]={"BMTC","KMRL"};
    String list2[]={"Passport","Driving License","PAN Number","Voter ID"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metrosmartcard);
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

        s1=(Spinner)findViewById(R.id.s1);
        s2=(Spinner)findViewById(R.id.s2);
        b1=(Button)findViewById(R.id.button);
        name=(EditText)findViewById(R.id.name);
        nid=(EditText)findViewById(R.id.nid);
        add=(EditText)findViewById(R.id.add);
        mail=(EditText)findViewById(R.id.mail);
        mob=(EditText)findViewById(R.id.mob);
        rg=(RadioGroup)findViewById(R.id.rg);
        dob=(EditText)findViewById(R.id.dob);

        ArrayAdapter<String> dataadapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list1);
        s1.setAdapter(dataadapter);

        ArrayAdapter<String> dataadapter1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list2);
        s2.setAdapter(dataadapter1);



        db = openOrCreateDatabase("EmployeeDB", Context.MODE_PRIVATE, null);
        if (db != null) {
           // Toast.makeText(this, "Ctreated", Toast.LENGTH_SHORT).show();
        }
        db.execSQL("CREATE TABLE IF NOT EXISTS smartcard(cardtype VARCHAR,name VARCHAR,gender VARCHAR,dob VARCHAR,idtype VARCHAR,idnumber VARCHAR,adderess VARCHAR,mail VARCHAR,mob VARCHAR);");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sel=rg.getCheckedRadioButtonId();

                rb=(RadioButton)findViewById(sel);
                int pos1=s1.getSelectedItemPosition();
                String text= list1[pos1].toString();
                int pos2=s1.getSelectedItemPosition();
                String text1= list2[pos1].toString();



                if (
                        name.getText().toString().trim().length() == 0 ||
                        dob.getText().toString().trim().length() == 0 ||
                        nid.getText().toString().trim().length() == 0 ||
                        add.getText().toString().trim().length() == 0 ||
                        mail.getText().toString().trim().length() == 0 ||
                        mob.getText().toString().trim().length() == 0) {
                    showMessage("Error", "Please enter all values");
                    return;
                }
                db.execSQL("INSERT INTO smartcard VALUES('" + text + "','" + name.getText() +
                        "','" + rb + "','" + dob.getText() + "', '" + text1 + "','" + nid.getText() +"','" + add.getText() +"','" + mail.getText() +"','" + mob.getText()+ "');");
                showMessage("Success", "Registered successfully  \n\n your card will delivered to your registered address");
                clearText();


            }
        });


    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void clearText() {
        name.setText("");
        nid.setText("");
        add.setText("");
        mail.setText("");
        mob.setText("");

    }
}



