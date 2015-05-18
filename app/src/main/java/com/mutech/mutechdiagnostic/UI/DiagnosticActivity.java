package com.mutech.mutechdiagnostic.UI;

/**
 * Created by ZawMai on 4/30/2015.
 * Last Updated by ZawMai 5/01/2015
 */

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mutech.mutechdiagnostic.Model.Page;
import com.mutech.mutechdiagnostic.Model.PageList;
import com.mutech.mutechdiagnostic.Model.StringResources;
import com.mutech.mutechdiagnostic.R;

public class DiagnosticActivity extends ActionBarActivity {

    // Member variables
    private PageList mPages = new PageList();
    private TextView mHeading;
    private TextView mDescription;
    private Button mTopChoice;
    private Button mBottomChoice;
    private Page mCurrentPage;
    private ImageView mImageView;
    private StringResources resource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostic);

        mHeading = (TextView) findViewById(R.id.Heading);
        mDescription = (TextView) findViewById(R.id.Description);
        mTopChoice = (Button) findViewById(R.id.ChoiceButton2);
        mBottomChoice = (Button) findViewById(R.id.ChoiceButton1);
        mImageView = (ImageView)findViewById(R.id.imageViewG);
        ActionBar bar = getSupportActionBar();
        bar.setLogo(R.drawable.mutechtransparency4);
        bar.setDisplayUseLogoEnabled(true);
        bar.setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.RED));
        loadPage(0);
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
     protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            mImageView.setImageBitmap(photo);
        }
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
            // HEADING and DESCRIPTION ALWAYS EXIST, so this code is always executed
            mHeading.setText(mCurrentPage.getHeading());
            mDescription.setText(mCurrentPage.getDescription());

            //Align the heading/description

            mHeading.setGravity(Gravity.CENTER);
            mDescription.setGravity(Gravity.CENTER);

            // Set Text for Top and Bottom Buttons
            // TOP BUTTON may not always exist! So let's make a case-by-case checker:
            switch(choice) {
                case 0: setTitle("MuTech Diagnostic");
                        mTopChoice.setText(mCurrentPage.getChoices()[0].getText());
                        mBottomChoice.setText(mCurrentPage.getChoices()[1].getText());
                        mTopChoice.setGravity(Gravity.CENTER);
                        mBottomChoice.setGravity(Gravity.CENTER);

                        mTopChoice.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // Put your code here//
                                System.out.println("Next step: " + mCurrentPage.getChoices()[0].getNextStep());
                                loadPage(mCurrentPage.getChoices()[0].getNextStep());
                            }
                        });

                        mBottomChoice.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // Put your code here //
                                System.out.println("Next step: " + mCurrentPage.getChoices()[1].getNextStep());
                                loadPage(mCurrentPage.getChoices()[1].getNextStep());
                            }
                        }); System.out.println("ERROR!"); break;
                case 1: setTitle("Photoanalysis, Step 1");
                        mTopChoice.setVisibility(View.GONE);
                        mBottomChoice.setText(mCurrentPage.getChoices()[0].getText());

                        mBottomChoice.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // Put your code here //
                                loadPage(mCurrentPage.getChoices()[0].getNextStep());
                            }
                        }); break;
                case 2: setTitle("Photoanalysis, Step 2");
                        mTopChoice.setVisibility(View.GONE);
                        mBottomChoice.setText(mCurrentPage.getChoices()[0].getText());

                        mBottomChoice.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // Put your code here //
                                dispatchTakePictureIntent();
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {

                                    @Override
                                    public void run() {
                                        loadPage(mCurrentPage.getChoices()[0].getNextStep());
                                    }

                                }, 5000); // 5000ms delay
                            }
                        }); break;
                case 3: setTitle("Photoanalysis, Step 3");
                        mTopChoice.setVisibility(View.VISIBLE);
                        mImageView.setVisibility(View.VISIBLE);
                        mTopChoice.setText(mCurrentPage.getChoices()[1].getText());
                        mBottomChoice.setText(mCurrentPage.getChoices()[0].getText());


                        mTopChoice.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // Put your code here //
                                mImageView.setVisibility(View.GONE);
                                loadPage(mCurrentPage.getChoices()[1].getNextStep());
                            }
                        });
                        mBottomChoice.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // Put your code here //
                                mImageView.setVisibility(View.GONE);
                                loadPage(mCurrentPage.getChoices()[0].getNextStep());
                            }
                        }); break;
                case 4: setTitle("Photoanalysis, Step 4");
                        mTopChoice.setVisibility(View.GONE);
                        mBottomChoice.setText(mCurrentPage.getChoices()[0].getText());

                        mBottomChoice.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // Put your code here //
                                loadPage(mCurrentPage.getChoices()[0].getNextStep());
                            }
                        }); break;
                default: System.out.println("ERROR!"); break;
            }


            if (!(mCurrentPage.getIntents() == null)){
                // Start Intents if there are any for for the page
                // Put Intents or create resources and objects
            }

        }
    }







}
