package com.example.android.sqlitedatabase;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembers extends AppCompatActivity {

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


        words.add(new Word("Father","Pita",R.drawable.family_father,R.raw.pita));
        words.add(new Word("Mother","Maa",R.drawable.family_mother,R.raw.ma));
        words.add(new Word("Sister","Behen",R.drawable.family_younger_sister,R.raw.behen));
        words.add(new Word("Brother","Bhaai",R.drawable.family_younger_brother,R.raw.bhai));
        words.add(new Word("Paternal Grandfather","Daada",R.drawable.family_grandfather,R.raw.dada));
        words.add(new Word("Paternal GrandMother","Daadi",R.drawable.family_grandmother,R.raw.dadi));
        words.add(new Word("Son","Beta",R.drawable.family_son,R.raw.beta));
        words.add(new Word("Daughter","Beti",R.drawable.family_daughter,R.raw.beti));



        WordAdapter itemsAdapter = new WordAdapter(this,words,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();

                Word word = words.get(position);
                mMediaPlayer = MediaPlayer.create(FamilyMembers.this,
                        word.getAudioResourceId());
                mMediaPlayer.start();

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
