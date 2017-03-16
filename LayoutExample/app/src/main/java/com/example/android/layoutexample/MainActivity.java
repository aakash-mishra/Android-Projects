package com.example.android.layoutexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void image1(View view)
    {
        ImageView img=(ImageView) findViewById(R.id.img_view_id);

        img.setImageResource(R.drawable.mp6);

    }

    public void image2(View view)
    {
        ImageView img=(ImageView) findViewById(R.id.img_view_id);

        img.setImageResource(R.drawable.mp2);

    }
    public void image3(View view)
    {
        ImageView img=(ImageView) findViewById(R.id.img_view_id);

        img.setImageResource(R.drawable.mp3);

    }



}
