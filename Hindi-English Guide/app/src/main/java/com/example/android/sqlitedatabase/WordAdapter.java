package com.example.android.sqlitedatabase;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aakash on 4/4/17.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId){

        super(context,0,words);
        mColorResourceId = colorResourceId;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Word currentWord= getItem(position);

        View listItemView= convertView;
        if(listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);
        }

        TextView english= (TextView) listItemView.findViewById(R.id.default_text_view);
        english.setText(currentWord.getEnglishTranslation());

        TextView miwok= (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwok.setText(currentWord.getmMiwokTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentWord.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }





        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}