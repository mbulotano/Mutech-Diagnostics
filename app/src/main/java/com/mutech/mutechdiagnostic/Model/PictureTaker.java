package com.mutech.mutechdiagnostic.Model;

import android.content.Intent;
import android.provider.MediaStore;

/**
 * Created by ZawMai on 4/30/2015.
 * Last Updated on 4/30/2015
 */

public class PictureTaker {
    static final int REQUEST_IMAGE_CAPTURE = 1;

    public void sendTakePictureIntent(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);   }
}
