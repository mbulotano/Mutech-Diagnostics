package com.mutech.mutechdiagnostic.UI;

/**
 * Created by ZawMai on 4/30/2015.
 * Last Updated by ZawMai 5/01/2015
 */

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mutech.mutechdiagnostic.Model.Page;
import com.mutech.mutechdiagnostic.Model.PageList;
import com.mutech.mutechdiagnostic.R;

public class DiagnosticActivity extends ActionBarActivity {

    // Member variables
    private PageList mPages = new PageList();
    private TextView mHeading;
    private TextView mDescription;
    private Button mTopChoice;
    private Button mBottomChoice;
    private Page mCurrentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostic);

        mHeading = (TextView) findViewById(R.id.Heading);
        mDescription = (TextView) findViewById(R.id.Description);
        mTopChoice = (Button) findViewById(R.id.ChoiceButton1);
        mBottomChoice = (Button) findViewById(R.id.ChoiceButton2);

        loadPage(0);
    }


    private void loadPage(int choice){
        mCurrentPage = mPages.getPage(choice);

        // If current page is the last page, then direct user to the result of picture analysis and prompt
        // user to restart the test or exit the app.
        if(mCurrentPage.isFinal()){
            // Put Your Code Here //
        }

        // Else.... load the page as the next page.
        else{
            // Set Text for Heading and Description TextView objects
            mHeading.setText(mCurrentPage.getHeading());
            mDescription.setText(mCurrentPage.getDescription());

            // Set Text for Top and Bottom Buttons
            mTopChoice.setText(mCurrentPage.getChoices()[0].getText());
            mBottomChoice.setText(mCurrentPage.getChoices()[1].getText());

            mTopChoice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Put your code here//
                    loadPage(mCurrentPage.getChoices()[0].getNextStep());
                }
            });

            mBottomChoice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Put your code here //
                    loadPage(mCurrentPage.getChoices()[1].getNextStep());
                }
            });


            if (!(mCurrentPage.getIntents() == null)){
                // Start Intents if there are any for for the page
                // Put Intents or create resources and objects
            }

        }
    }







}
