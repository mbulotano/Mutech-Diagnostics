package com.mutech.mutechdiagnostic.Model;

import android.graphics.Bitmap;
import android.graphics.Color;

import java.util.ArrayList;

/**
 * Created by Zaw Mai on 5/19/2015.
 */
public class Histogram {

    private int mBinNum = 0;
    private Bin mRedBins;
    private Bin mGreenBins;
    private Bin mBlueBins;
    private Bin[] mBinList;
    private int mBinInterval = 0;

    public Histogram(int binNum, Bitmap bMap){
        mBinNum = binNum;
        mRedBins = new Bin(binNum);
        mGreenBins = new Bin(binNum);
        mBlueBins = new Bin(binNum);
        mBinList = new Bin[3];

        mBinList[0] = mRedBins;
        mBinList[1] = mGreenBins;
        mBinList[2] = mBlueBins;

        mBinInterval = 256/binNum;

        createBins(bMap);
    }

    private void createBins(Bitmap bMap){
        int pixel;
        int height = bMap.getHeight();
        int width = bMap.getWidth();

        for(int h = 0; h < height; h++){
            for(int w = 0; w < width; w++){
                pixel = bMap.getPixel(w,h);
                putColorIntoBin(pixel);
            }
        }
    }

    private void putColorIntoBin(int pixel){
        int r = Color.red(pixel);
        int g = Color.green(pixel);
        int b = Color.blue(pixel);

        try {
            mBinList[0].getBin().get(whichBin(r, mBinInterval, mBinNum)).add(r);
            mBinList[1].getBin().get(whichBin(g, mBinInterval, mBinNum)).add(g);
            mBinList[2].getBin().get(whichBin(b, mBinInterval, mBinNum)).add(b);

        } catch (IndexOutOfBoundsException e){
            System.out.println("No appropriate bin for color.");
        }
    }


    private int whichBin(int color, int binSize, int binNum) {

        for(int bin = 0; bin < binNum; bin++){
            int min = bin*binSize;
            int max = ((bin + 1) * binSize) - 1;
            if( (min <= color) && (color <= max ) ) {
                return bin;
            }
        }
        return -1;
    }

    public void printStuff() {
        System.out.println("Blue Bins");
        getBlueBinsSize();
        System.out.println("Red Bins");
        getRedBinsSize();
        System.out.println("Green Bins");
        getGreenBinsSize();
    }

    // Getter
    public void getBlueBinsSize() {
        for(int i = 0; i < mBinList[2].getBin().size(); i++) {
            System.out.println(i + ": " + mBinList[2].getBin().get(i).size());
        }
    }

    public void getRedBinsSize() {
        for(int i = 0; i < mBinList[0].getBin().size(); i++) {
            System.out.println(i + ": " + mBinList[0].getBin().get(i).size());
        }
    }

    public void getGreenBinsSize() {
        for(int i = 0; i < mBinList[1].getBin().size(); i++) {
            System.out.println(i + ": " + mBinList[1].getBin().get(i).size());
        }
    }

    // Bin Nested Class
    class Bin{
        private ArrayList<ArrayList<Integer>> mMainBin;

        public Bin(int count){
            mMainBin = new ArrayList<>();
            for(int i = 0; i < count; i++) {
                mMainBin.add(new ArrayList<Integer>());
            }
        }

        public ArrayList<ArrayList<Integer>> getBin(){
            return mMainBin;
        }
    }

}
