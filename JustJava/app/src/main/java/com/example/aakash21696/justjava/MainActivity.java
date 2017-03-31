package com.example.aakash21696.justjava;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 1;
    ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void submitOrder(View view) {

        EditText editText = (EditText) findViewById(R.id.name);
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox_whipped);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox_choc);
        if (quantity <= 0) {
            Toast.makeText(this, "Cannot place order.", Toast.LENGTH_SHORT).show();

        } else {
            int ans = calculatePrice();
            //displayMessage(ans);
            String name = editText.getText().toString();
            String statusWhipped = "";
            String statusChoc = "";

            if (checkBox2.isChecked()) {
                statusChoc = "true";
            } else statusChoc = "false";

            if (checkBox.isChecked()) {
                statusWhipped = "true";
            } else statusWhipped = "false";
            String msg = name + "\n Quantity:" + quantity + "\n Price:" + ans + "\n Whipped cream?:" + statusWhipped + "\n Chocolate topping?" + statusChoc;
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                    "Just Java App by Aakash Mishra");

            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                    msg);

            if (emailIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(emailIntent);

            }
        }
    }

    private int calculatePrice() {

        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox_whipped);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox_choc);
        int priceWhipped = 0;
        int priceChoc = 0;
        if (checkBox.isChecked()) {
            priceWhipped = 1;
        }
        if (checkBox2.isChecked()) {
            priceChoc = 2;
        }
        int price = 5 + priceWhipped + priceChoc;
        return (price * quantity);
    }

    private void displayQty(int n) {

        TextView textView = (TextView) findViewById(R.id.quantity_text_view);
        textView.setText("" + n);
    }

//    public void displayMessage(int n)
//    {
//        EditText editText= (EditText) findViewById(R.id.name);
//
//        String name = editText.getText().toString();
//        CheckBox checkBox= (CheckBox) findViewById(R.id.checkbox_whipped);
//        CheckBox checkBox2= (CheckBox) findViewById(R.id.checkbox_choc);
//
//        String statusWhipped="";
//        String statusChoc="";
//
//        if(checkBox2.isChecked())
//        {
//            statusChoc="true";
//        }
//        else statusChoc="false";
//
//        if(checkBox.isChecked())
//        {
//             statusWhipped="true";
//        }
//        else statusWhipped="false";
//
//        TextView textView= (TextView) findViewById(R.id.order_summary_text_view);
//        String msg= name+"\n Quantity:"+quantity+"\n Price:"+n+"\n Whipped cream?:"+statusWhipped+"\n Chocolate topping?"+statusChoc;
//        textView.setText(msg);
//    }

    public void increment(View view) {

        quantity = quantity + 1;
        displayQty(quantity);

    }

    public void decrement(View view) {
        quantity = quantity - 1;
        displayQty(quantity);

    }


}
