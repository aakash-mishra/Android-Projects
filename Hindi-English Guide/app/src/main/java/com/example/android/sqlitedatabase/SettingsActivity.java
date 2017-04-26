package com.example.android.sqlitedatabase;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        openHelper = new SQLiteDBHelper(this);

        Intent intent = getIntent();
        final String loginPass = intent.getStringExtra("pass");
        final String  contact = intent.getStringExtra("contact");
        final String name = intent.getStringExtra("name");
        final String email = intent.getStringExtra("email");
        final String loginID = intent.getStringExtra("id");



//        if(loginPass==null)
//            Toast.makeText(SettingsActivity.this, "Pass not found", Toast.LENGTH_SHORT).show();
//        else
//            Toast.makeText(SettingsActivity.this, loginPass , Toast.LENGTH_SHORT).show();




        TextView del = (TextView) findViewById(R.id.deleteUser);
        TextView update = (TextView) findViewById(R.id.updateUser);



        del.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View v) {
                db = openHelper.getWritableDatabase();

                final AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
                builder.setTitle("Confirm");
                builder.setMessage("Are you sure you want to delete this user account?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                       int res= deleteUser(loginPass);
                        if(res<=0)
                            Toast.makeText(SettingsActivity.this, "User cant be deleted", Toast.LENGTH_SHORT).show();


                        Toast.makeText(SettingsActivity.this, "User deleted", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(SettingsActivity.this,MainActivity.class);
                            startActivity(intent);


                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
                return false;
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                            Toast.makeText(SettingsActivity.this, "Long press to delete!", Toast.LENGTH_SHORT).show();

            }
        });

        update.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i= new Intent(SettingsActivity.this, UpdateActivity.class);
                i.putExtra("name",name);
                i.putExtra("email",email);
                i.putExtra("contact",contact);
                i.putExtra("pass",loginPass);
                i.putExtra("id",loginID);




                startActivity(i);
            }
        });




    }



    public Integer deleteUser(String pass){

        return db.delete(SQLiteDBHelper.TABLE_NAME,"password = ?", new String[] {pass});

    }

}
