package com.mutech.mutechdiagnostic.Model;

/**
 * Created by ZawMai on 4/30/2015.
 * Last Updated by ZawMai on 5/01/2015
 */

// Possible choice to be displayed with a text and states which next step to go.
public class Choice {
    private String mText;
    private int mNextStep;

    // Constructor
    public Choice(String text, int nextStep){
        mText = text;
        mNextStep = nextStep;
    }

    // Getters
    public String getText() {
        return mText;
    }

    public int getNextStep() {
        return mNextStep;
    }

    // Setters
    public void setText(String text) {
        mText = text;
    }

    public void setNextStep(int nextStep) {
        mNextStep = nextStep;
    }
}
