package com.example.android.sqlitedatabase;

public class Word {

    private String mEnglishTranslation;
    private String mMiwokTranslation;
    /** Audio resource ID for the word */
    private int mAudioResourceId;

    /** Image resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String english, String miwok, int audioResourceId) {
        mEnglishTranslation = english;
        mMiwokTranslation = miwok;
        mAudioResourceId = audioResourceId;
    }

    public Word(String english, String miwok, int imageID, int audioResourceId) {
        mEnglishTranslation = english;
        mMiwokTranslation = miwok;
        mAudioResourceId = audioResourceId;
        mImageResourceId = imageID;
    }

    public String getEnglishTranslation() {
        return mEnglishTranslation;
    }

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }


    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getAudioResourceId() {
        return mAudioResourceId;
    }


}




