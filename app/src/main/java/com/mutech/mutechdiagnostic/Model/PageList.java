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

        mPages = new Page[7];
        //App applica = new App();
        //Resources resource = applica.getContext().getResources();
        StringResources resource = new StringResources();

        /*Pages are initialized with string values from the "/values/strings.xml" file.
        * Also, choices are set with the associated next page number when it is clicked.
        */

        // ****** Initialization ****** //
        mPages[0] = new Page(
                resource.page0heading(),
                resource.page0description(),
                new Choice[2]);

        mPages[1] = new Page(
                resource.page1heading(),
                resource.page1description(),
                new Choice[1]);


        mPages[2] = new Page(
                resource.page2heading(),
                resource.page2description(),
                new Choice[1]);

        mPages[3] = new Page(
                resource.page3heading(),
                resource.page3description(),
                new Choice[2]);

        mPages[4] = new Page(
                resource.page2heading(),
                resource.page2heading(),
                new Choice[1],
                new Intent[1]);

        mPages[5] = new Page(
                resource.page5heading(),
                resource.page5description(),
                new Choice[1]);

        mPages[6] = new Page(
                resource.page6heading(),
                resource.page6description(),
                new Choice[2]);

        for(int q = 0; q < mPages.length; q++) {
            for (int i = 0; i < mPages[q].getChoices().length; i++) {
                mPages[q].getChoices()[i] = new Choice("test", 0);
            }
        }
        // ****** Where would you like to start screen, microfluidics or photoanalysis? ****** //
        mPages[0].getChoices()[0].setText(resource.page0choice1());
        mPages[0].getChoices()[0].setNextStep(0);
        mPages[0].getChoices()[1].setText(resource.page0choice2());
        mPages[0].getChoices()[1].setNextStep(1);


        // ****** Photoanalysis Tutorial, Step 1:  ****** //
        // The tutorial will guide user on how to use the device.
        mPages[1].getChoices()[0].setText(resource.page1choice1());
        mPages[1].getChoices()[0].setNextStep(2);


        // ****** Initial Picture Analysis Screen ****** //
        //Starts camera intent
        mPages[2].getChoices()[0].setText(resource.page2choice1());
        mPages[2].getChoices()[0].setNextStep(3);

        // ****** Picture confirmation Step ****** //
        //User confirms whether the photo taken is good
        mPages[3].getChoices()[0].setText(resource.page3choice1());
        mPages[3].getChoices()[0].setNextStep(4);
        mPages[3].getChoices()[1].setText(resource.page3choice2());
        mPages[3].getChoices()[1].setNextStep(2);


        // ****** Begin Picture Analysis ****** //
        mPages[4].setDescription(resource.page4heading());
        mPages[4].setDescription(resource.page4description());
        mPages[4].getChoices()[0].setText(resource.page4choice1());
        mPages[4].getChoices()[0].setNextStep(5);

        // ****** Capture Picture Screen ****** //
        mPages[5].getChoices()[0].setNextStep(6);

        // results

        mPages[6].getChoices()[0].setText("Take new test");
        mPages[6].getChoices()[1].setText("Save");
        mPages[6].getChoices()[0].setNextStep(0);

        // create Intent to take a picture and return control to the calling application
        //mPages[4].getIntents()[0].setAction(MediaStore.ACTION_IMAGE_CAPTURE);

    }


    public Page getPage(int pageNumber){return mPages[pageNumber];}

}
