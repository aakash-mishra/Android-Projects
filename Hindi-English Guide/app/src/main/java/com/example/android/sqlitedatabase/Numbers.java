package com.example.android.sqlitedatabase;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;


    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words= new ArrayList<Word>();


        words.add(new Word("One","Ek",R.drawable.number_one,R.raw.number_ek));
        words.add(new Word("Two","Do",R.drawable.number_two,R.raw.number_do));
        words.add(new Word("Three","Teen",R.drawable.number_three,R.raw.number_teen));
        words.add(new Word("Four","Chaar",R.drawable.number_four,R.raw.number_chaar));
        words.add(new Word("Five","Paanch",R.drawable.number_five,R.raw.number_panch));
        words.add(new Word("Six","Cheh",R.drawable.number_six,R.raw.number_che));
        words.add(new Word("Seven","Saat",R.drawable.number_seven,R.raw.number_saat));
        words.add(new Word("Eight","Aath",R.drawable.number_eight,R.raw.number_aath));
        words.add(new Word("Nine","Nau",R.drawable.number_nine,R.raw.number_nau));
        words.add(new Word("Ten","Das",R.drawable.number_ten,R.raw.number_das));


        WordAdapter itemsAdapter = new WordAdapter(this,words,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        // Add Click Listener to play word
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();

                Word word = words.get(position);

//                Log.v("NumbersActivity", "Current word: " + word);

                mMediaPlayer = MediaPlayer.create(Numbers.this, word.getAudioResourceId());
                mMediaPlayer.start();

                // Setup a listener on the media player, so that we can stop and release the
                // media player once the sound has finished playing.
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });




    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}

