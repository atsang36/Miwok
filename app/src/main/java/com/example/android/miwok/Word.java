package com.example.android.miwok;

import android.media.Image;

/**
 * Created by AndyTsang on 2018-06-17.
 * {@link Word} represents a vocabulary word that the user wants to learn
 * It contains the default translation and the Miwok translation
 */

public class Word {

    private final static int NO_IMAGE_PROVIDED = -1;

    /** Default translation **/
    private String mDefaultTranslation;

    /** Miwok translation **/
    private String mMiwokTranslation;

    /** Image Resource ID **/
    private int mNumberResourceId = NO_IMAGE_PROVIDED;

    /** Set the pair of Default language and Miwok words **/
    public Word(String defaultTranslation, String MiwokTranslation){
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = MiwokTranslation;
    }
    /** Set the pair of Default language and Miwok words for Words with Image Resources **/
    public Word(String defaultTranslation, String MiwokTranslation, int defaultImageResource){
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = MiwokTranslation;
        this.mNumberResourceId = defaultImageResource;
    }

    /** Get default translation **/
    public String getDefaultTranslation(){
        return mDefaultTranslation;

    }

    /** Get Miwok translation **/
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public int getmImageResourceId(){return mNumberResourceId;}

    public boolean hasImage(){

        return (mNumberResourceId != NO_IMAGE_PROVIDED);
    }
}
