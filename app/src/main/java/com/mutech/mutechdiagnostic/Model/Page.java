package com.mutech.mutechdiagnostic.Model;

import android.content.Intent;

/**
 * Created by ZawMai on 4/30/2015.
 * Last Updated by ZawMai on 5/01/2015
 */
public class Page {

    // Memeber Variables
    private String mHeading;
    private String mDescription;
    private Choice[] mChoices;
    private Intent[] mIntents;
    private boolean mIsFinal = false;       //boolean to check if it is the final page

    // Constructors
    // The first constructor has a null intent
    // The second one will have initialized intent for processes other than displaying texts.
    public Page(String heading, String description, Choice[] choices){
        this.mHeading = heading;
        this.mDescription = description;
        this.mChoices = choices;
        this.mIntents = null;
    }

    public Page(String heading, String description, Choice[] choices, Intent[] intents) {
        mHeading = heading;
        mDescription = description;
        this.mChoices = choices;
        this.mIntents = intents;
    }


    // Getter
    public String getHeading() {
        return mHeading;
    }

    public boolean isFinal() {
        return mIsFinal;
    }

    public Intent[] getIntents() {
        return mIntents;
    }

    public Choice[] getChoices() {
        return mChoices;
    }

    public String getDescription() {
        return mDescription;
    }


    // Setter
    public void setHeading(String heading) {
        mHeading = heading;
    }

    public void setIsFinal(boolean isFinal) {
        mIsFinal = isFinal;
    }

    public void setIntents(Intent[] intents) {
        mIntents = intents;
    }


    public void setChoices(Choice[] choices) {
        mChoices = choices;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
