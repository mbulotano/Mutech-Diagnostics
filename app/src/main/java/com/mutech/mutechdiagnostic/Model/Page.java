package com.mutech.mutechdiagnostic.Model;

import android.content.Intent;

/**
 * Created by ZawMai on 4/30/2015.
 * Last Updated by ZawMai on 5/01/2015
 */
public class Page {

    private String mHeading;
    private String mDescription;
    private Choice mChoice1;
    private Choice mChoice2;
    private Intent mIntent;

    public Page(String heading, String description, Choice choice1, Choice choice2){
        this.mHeading = heading;
        this.mDescription = description;
        this.mChoice1 =  choice1;
        this.mChoice2 = choice2;
        this.mIntent = null;

    }

    public Page(String heading, String description, Choice choice2, Choice choice1, Intent intent) {
        mHeading = heading;
        mDescription = description;
        mChoice2 = choice2;
        mChoice1 = choice1;
        this.mIntent = intent;
    }

    // Getter
    public String getHeading() { return mHeading; }

    public String getDescription() { return mDescription; }

    public Choice getChoice1() {
        return mChoice1;
    }

    public Choice getChoice2() {
        return mChoice2;
    }

    public Intent getIntent() { return mIntent; }


    // Setter
    public void setHeading(String heading) { mHeading = heading; }

    public void setChoice1(Choice choice1) {
        mChoice1 = choice1;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public void setChoice2(Choice choice2) {
        mChoice2 = choice2;
    }

    public void setIntent(Intent intent) { mIntent = intent; }

}
