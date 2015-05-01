package com.mutech.mutechdiagnostic.UI;

/**
 * Created by ZawMai on 4/30/2015.
 * Last Updated by ZawMai 5/01/2015
 */

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.mutech.mutechdiagnostic.Model.PageList;
import com.mutech.mutechdiagnostic.R;

public class DiagnosticActivity extends ActionBarActivity {

    private PageList pages = new PageList();
    private TextView mHeading;
    private TextView mDescription;
    private Button mTopChoice;
    private Button mBottomChoice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostic);
    }


}
