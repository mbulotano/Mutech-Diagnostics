package com.mutech.mutechdiagnostic.Model;

import android.content.Intent;

/**
 * Created by ZawMai on 4/30/2015.
 * Last Updated by ZawMai 5/01/2015
 */
public class PageList {

    private Page[] mPages;

    public PageList(){

        mPages = new Page[4];

        // Where would you like to start screen
        mPages[0] = new Page(
                    "/WRITE HEADING HERE/",
                    "/WRITE DESCRIPTION HERE/",
                    new Choice("/WRITE TOP BUTTON DESCRIPTION HERE/", 1),
                    new Choice("/WRITE Bottom BUTTON DESCRIPTION HERE/",2));

        // Initial Tutorial Screen: Video or picture?
        // The tutorial will guide user on how to use the device.
        mPages[1] = new Page(
                "/WRITE HEADING HERE/",
                "/WRITE DESCRIPTION HERE/",
                new Choice("/WRITE TOP BUTTON DESCRIPTION HERE/", 3),
                null);

        // Initial Screen to begin picture analysis
        mPages[2] = new Page(
                "/WRITE HEADING HERE/",
                "/WRITE DESCRIPTION HERE/",
                new Choice("/WRITE TOP BUTTON DESCRIPTION HERE/", 4),
                null,
                new Intent());

        // Screen with an intent to capture picture
        mPages[3] = new Page(
                "/WRITE HEADING HERE/",
                "/WRITE TIP HERE/",
                null,
                null,
                new Intent());

    }


    public Page getPage(int pageNumber){return mPages[pageNumber];}

}
