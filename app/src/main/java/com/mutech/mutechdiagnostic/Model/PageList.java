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
                new Choice[1]);

        mPages[4] = new Page(
                resource.page2heading(),
                resource.page2heading(),
                new Choice[1],
                new Intent[1]);

        for(int q = 0; q < mPages.length; q++) {
            for (int i = 0; i < mPages[q].getChoices().length; i++) {
                mPages[q].getChoices()[i] = new Choice("test", 0);
            }
        }
        // ****** Where would you like to start screen ****** //
        mPages[0].getChoices()[0].setText(resource.page0choice1());
        mPages[0].getChoices()[0].setNextStep(0);
        mPages[0].getChoices()[1].setText(resource.page0choice2());
        mPages[0].getChoices()[1].setNextStep(1);


        // ****** Initial Tutorial Screen: Video or picture? ****** //
        // The tutorial will guide user on how to use the device.
        mPages[1].getChoices()[0].setText(resource.page1choice1());
        mPages[1].getChoices()[0].setNextStep(3);


        // ****** Initial Picture Analysis Screen ****** //
        mPages[2].getChoices()[0].setText(resource.page2choice1());
        mPages[2].getChoices()[0].setNextStep(4);

        // ****** Tutorial Step #2 Screen ****** //
        mPages[3].getChoices()[0].setText(resource.page3choice1());
        mPages[3].getChoices()[0].setNextStep(5);


        // ****** Capture Picture Screen ****** //
        // mPages[4].getChoices()[0].setText(resource.getString(R.string.page_4_Tip));
        mPages[4].getChoices()[0].setNextStep(6);
        // create Intent to take a picture and return control to the calling application
        //mPages[4].getIntents()[0].setAction(MediaStore.ACTION_IMAGE_CAPTURE);

    }


    public Page getPage(int pageNumber){return mPages[pageNumber];}

}
