package com.mutech.mutechdiagnostic;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.mutech.mutechdiagnostic.UI.DiagnosticActivity;
import com.mutech.mutechdiagnostic.UI.PatientActivity;


public class MainActivity extends ActionBarActivity {

    // Member Variables
    private Button mStartButton; // Top Button
    private Button mLoadButton; // Bottom Button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create Button Objects with the respective ids, associated with
        // the graphical buttons on the welcome/starting activity(screen)
        mStartButton = (Button) findViewById(R.id.ChoiceButton1);
        mLoadButton = (Button) findViewById(R.id.ChoiceButton2);

        //Load Images and background
        ImageView image = (ImageView) findViewById(R.id.imageView1);
        image.setImageResource(R.drawable.mutechtitle);
        RelativeLayout rl = (RelativeLayout)findViewById(R.id.mainlayout);
        rl.setBackgroundColor(Color.WHITE);
        ActionBar bar = getSupportActionBar();
        //bar.setIcon(R.drawable.mutechtitle);
        bar.setLogo(R.drawable.mutechtransparency4);
        bar.setDisplayUseLogoEnabled(true);
        bar.setDisplayShowHomeEnabled(true);
        //bar.setBackgroundDrawable(new ColorDrawable(Color.GRAY));

        // Set a Click listener to monitor if the button is clicked or not
        // If the user click the button, it invokes the "onClick" methods
        // to execute to the specified statements
        // Click Listener for the Start Button
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Put your code here
                startDiagnostic();
            }
        });

        // Click Listener for the Load Button
        mLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Put Your Code Here
                loadPatient();
            }
        });
    }

    // Begin Diagnostic steps
    private void startDiagnostic(){
        Intent intent = new Intent(this, DiagnosticActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_top);
    }

    // Directs patient directory or load patient data from a user-specified filepath
    private void loadPatient(){
        Intent intent = new Intent(this, PatientActivity.class);
        startActivity(intent);
    }

    protected void onResume() {
        super.onResume();
    }

}
