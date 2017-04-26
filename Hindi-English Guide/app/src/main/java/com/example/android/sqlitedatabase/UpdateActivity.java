package com.example.android.sqlitedatabase;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        openHelper = new SQLiteDBHelper(this);
         Button update= (Button) findViewById(R.id.btn_up);
          final EditText _txtfullname = (EditText) findViewById(R.id.txtname_reg);
          final EditText _txtemail = (EditText) findViewById(R.id.txtemail_reg);
         final EditText _txtpass = (EditText) findViewById(R.id.txtpass_reg);
         final EditText _txtmobile = (EditText) findViewById(R.id.txtmobile_reg);
        Intent i= getIntent();
        final String id= i.getStringExtra("id");


        update.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                db = openHelper.getWritableDatabase();
                final String _name = _txtfullname.getText().toString();
                final String _email = _txtemail.getText().toString();
                final String _pass = _txtpass.getText().toString();
                final String _mobile = _txtmobile.getText().toString();
                boolean res = updateUser(_name, _email, _pass, _mobile, id);
                if(res==true)
                Toast.makeText(UpdateActivity.this, "Account credentials updated!" , Toast.LENGTH_SHORT).show();
                else

                    Toast.makeText(UpdateActivity.this, "Account credentials not updated!" , Toast.LENGTH_SHORT).show();

            }
        });



    }


    public boolean updateUser(String name,String email,String pass,String mobile,String id){

        ContentValues values = new ContentValues();
        values.put(SQLiteDBHelper.COLUMN_FULLNAME,name);
        values.put(SQLiteDBHelper.COLUMN_ID,id);
        values.put(SQLiteDBHelper.COLUMN_EMAIL,email);
        values.put(SQLiteDBHelper.COLUMN_PASSWORD,pass);
        values.put(SQLiteDBHelper.COLUMN_MOBILE,mobile);
        db.update(SQLiteDBHelper.TABLE_NAME, values, "userid = ?", new String[] {id});
//        Toast.makeText(UpdateActivity.this, res , Toast.LENGTH_SHORT).show();
        return true;

    }



}
