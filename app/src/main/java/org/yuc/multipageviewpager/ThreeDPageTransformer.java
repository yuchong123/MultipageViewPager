package org.yuc.multipageviewpager;

import android.annotation.SuppressLint;
import android.support.v4.view.ViewPager;
import android.view.View;

public class ThreeDPageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.5f;
    private static final float MIN_angle = 30f;

    private float excursion = 0;

    public ThreeDPageTransformer(){
    }

    public ThreeDPageTransformer(float excursion){
        this.excursion = excursion;
    }

    @SuppressLint("NewApi")
    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();  

        position = position + excursion;

        if (position < -1) { // [-Infinity,-1)
//            view.setAlpha(1);
            view.setScaleX(MIN_SCALE);
            view.setScaleY(MIN_SCALE);
            view.setTranslationX(pageWidth/4);
            view.setRotationY(MIN_angle);
//        	float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
//        	view.setScaleX(scaleFactor);
//            view.setScaleY(scaleFactor);
        	
        } else if (position <= 0) { // [-1,0]
//            view.setAlpha(1);  
//            view.setTranslationX(0);
//            view.setScaleX(1);  
//            view.setScaleY(1);  
        	float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
        	view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
            
            view.setTranslationX(pageWidth/4*Math.abs(position));
            view.setRotationY(MIN_angle*Math.abs(position));
            
        } else if (position <= 1) { // (0,1]
        	float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
            view.setScaleX(scaleFactor);  
            view.setScaleY(scaleFactor);  
            view.setTranslationX(-pageWidth/4*Math.abs(position));
            view.setRotationY(-MIN_angle*Math.abs(position));
  
        } else { // (1,+Infinity]  
            // This page is way off-screen to the right.  
//            view.setAlpha(0);
        	view.setScaleX(MIN_SCALE);
            view.setScaleY(MIN_SCALE);
            view.setTranslationX(-pageWidth/4);
            view.setRotationY(-MIN_angle);
        }  
    }  
}  