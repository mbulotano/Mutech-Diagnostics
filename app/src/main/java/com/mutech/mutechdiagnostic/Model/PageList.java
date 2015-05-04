package com.mutech.mutechdiagnostic.Model;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.MediaStore;

import com.mutech.mutechdiagnostic.R;

/**
 * Created by ZawMai on 4/30/2015.
 * Last Updated by ZawMai 5/01/2015
 */
public class PageList {

    // Member Variables
    private Page[] mPages;

    // Constructs an object with specified texts, choices and intents for each page
    // The page array REQUIRES further population with pages according to the design
    public PageList(){

        mPages = new Page[5];
        Resources resource = App.getContext().getResources();

        /*Pages are initialized with string values from the "/values/strings.xml" file.
        * Also, choices are set with the associated next page number when it is clicked.
        */

        // ****** Where would you like to start screen ****** //
        mPages[0] = new Page(
                            resource.getString(R.string.page_0_heading),
                            resource.getString(R.string.page_0_description),
                            new Choice[2]);
        mPages[0].getChoices()[1].setText(resource.getString(R.string.page_0_choice1));
        mPages[0].getChoices()[1].setNextStep(1);
        mPages[0].getChoices()[2].setText(resource.getString(R.string.page_0_choice2));
        mPages[0].getChoices()[2].setNextStep(2);


        // ****** Initial Tutorial Screen: Video or picture? ****** //
        // The tutorial will guide user on how to use the device.
        mPages[1] = new Page(
                            resource.getString(R.string.page_1_heading),
                            resource.getString(R.string.page_1_description),
                            new Choice[1]);
        mPages[1].getChoices()[0].setText(resource.getString(R.string.page_1_choice1));
        mPages[1].getChoices()[0].setNextStep(3);


        // ****** Initial Picture Analysis Screen ****** //
        mPages[2] = new Page(
                            resource.getString(R.string.page_2_heading),
                            resource.getString(R.string.page_2_description),
                            new Choice[1]);
        mPages[2].getChoices()[0].setText(resource.getString(R.string.page_2_choice1));
        mPages[2].getChoices()[0].setNextStep(4);

        // ****** Tutorial Step #2 Screen ****** //
        mPages[3] = new Page(
                            resource.getString(R.string.page_3_heading),
                            resource.getString(R.string.page_3_description),
                            new Choice[1]);
        mPages[3].getChoices()[0].setText(resource.getString(R.string.page_3_choice1));
        mPages[3].getChoices()[0].setNextStep(5);


        // ****** Capture Picture Screen ****** //
        mPages[4] = new Page(
                            resource.getString(R.string.page_2_heading),
                            resource.getString(R.string.page_2_heading),
                            new Choice[1],
                            new Intent[1]);
        mPages[4].getChoices()[0].setText(resource.getString(R.string.page_4_Tip));
        mPages[4].getChoices()[0].setNextStep(6);
        // create Intent to take a picture and return control to the calling application
        mPages[4].getIntents()[0].setAction(MediaStore.ACTION_IMAGE_CAPTURE);

    }


    public Page getPage(int pageNumber){return mPages[pageNumber];}

}
