package com.example.android.miwok;
/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */

public class Word
{
    private String mDefaultTranslation;
    private String mArabicTranslation;

    /** Image resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    /** Audio resource ID for the word */
    private int mAudioResourceId;

    // constructor for phrases activity
    public Word(String mDefaultTranslation, String mArabicTranslation, int mAudioResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mArabicTranslation = mArabicTranslation;
        this.mAudioResourceId = mAudioResourceId;
    }
//constructor for the rest activity
    public Word(String mDefaultTranslation, String mArabicTranslation, int mImageResourceId, int mAudioResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mArabicTranslation = mArabicTranslation;
        this.mImageResourceId = mImageResourceId;
        this.mAudioResourceId = mAudioResourceId;
    }


    // Get the default translation of the word.
    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    // Get the Arabic translation of the word.
    public String getmArabicTranslation() {
        return mArabicTranslation;
    }
         //Return the image resource ID of the word.
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
    // Get the audio of the word.
    public int getmAudioResourceId() {
        return mAudioResourceId;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mArabicTranslation='" + mArabicTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }
}
