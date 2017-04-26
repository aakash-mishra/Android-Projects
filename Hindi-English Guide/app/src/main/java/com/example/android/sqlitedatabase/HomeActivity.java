package com.example.android.sqlitedatabase;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        openHelper = new SQLiteDBHelper(this);

        Intent intent = getIntent();

        final String loginPass = intent.getStringExtra("password");
        final String loginName = intent.getStringExtra("fullname");
        final String loginContact = intent.getStringExtra("contact");
        final String loginEmail= intent.getStringExtra("email");
        final String loginID= intent.getStringExtra("id");



        TextView numbersView = (TextView) findViewById(R.id.numbers);
        TextView familView = (TextView) findViewById(R.id.family);
        TextView colorsView = (TextView) findViewById(R.id.colors);
        TextView phrasesView = (TextView) findViewById(R.id.phrases);
        Button settings= (Button) findViewById(R.id.settings);
        Button logout= (Button) findViewById(R.id.logout);

        numbersView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(HomeActivity.this, Numbers.class);
                startActivity(i);
            }


        });

        familView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(HomeActivity.this, FamilyMembers.class);
                startActivity(i);
            }


        });

        colorsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(HomeActivity.this, Colors.class);
                startActivity(i);
            }


        });

        phrasesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(HomeActivity.this, Phrases.class);
                startActivity(i);
            }


        });


        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(HomeActivity.this, SettingsActivity.class);
                i.putExtra("pass",loginPass);
                i.putExtra("name",loginName);
                i.putExtra("email",loginEmail);
                i.putExtra("contact",loginContact);
                i.putExtra("id",loginID);

                startActivity(i);
            }


        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
                builder.setTitle("Info");
                builder.setMessage("Do you want to logout ??");
                builder.setPositiveButton("Take me away!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                        startActivity(intent);

                        finish();

                    }
                });

                builder.setNegativeButton("Not now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }


        });




    }


    public Cursor getData(){

        Cursor res = db.rawQuery("select * from "+SQLiteDBHelper.TABLE_NAME,null);
        return res;
    }
}
