package com.example.kmpcustomviews;

import android.graphics.drawable.GradientDrawable;

public class CreateCustomDrawable  {
    public CreateCustomDrawable() {
    }

    public static CreateCustomDrawable  getInstance(){
        return new CreateCustomDrawable();
    }

    public  GradientDrawable getOvalDrawableGradient(int startColor,int middleColor,int endColor,int strokeSize ,int strokeColor){
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.OVAL);
        drawable.setColors(new int[]{startColor, middleColor,endColor});
        drawable.setStroke(strokeSize, strokeColor);
        return drawable;
    }

    public  GradientDrawable getOvalDrawable(int color,int strokeSize ,int strokeColor){
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.OVAL);
        drawable.setColor(color);
        drawable.setStroke(strokeSize, strokeColor);
        return drawable;
    }

    public  GradientDrawable getRectDrawableGradient(int startColor,int middleColor,int endColor,int strokeSize ,int strokeColor,float cornerRadius)
    {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setColors(new int[]{startColor, middleColor,endColor});
        drawable.setStroke(strokeSize, strokeColor);
        drawable.setCornerRadius(cornerRadius);
        return drawable;
    }

    public  GradientDrawable getRectDrawable(int color,int strokeSize ,int strokeColor,float cornerRadius)
    {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setColor(color);
        drawable.setStroke(strokeSize, strokeColor);
        drawable.setCornerRadius(cornerRadius);
        return drawable;
    }

    public  GradientDrawable getRectDrawableGradient(int startColor,int middleColor,int endColor,int strokeSize ,int strokeColor,float topLeftRad,float topRightRad,float bottomLeftRad,float bottomRightRad)
    {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setColors(new int[]{startColor, middleColor,endColor});
        drawable.setStroke(strokeSize, strokeColor);
        drawable.setCornerRadii( new float []{topLeftRad,topLeftRad, topRightRad, topRightRad, bottomRightRad, bottomRightRad,bottomLeftRad,bottomLeftRad});
        return drawable;
    }

    public  GradientDrawable getRectDrawable(int color,int strokeSize ,int strokeColor,float topLeftRad,float topRightRad,float bottomLeftRad,float bottomRightRad){
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setColor(color);
        drawable.setStroke(strokeSize, strokeColor);
        drawable.setCornerRadii( new float []{topLeftRad,topLeftRad, topRightRad, topRightRad, bottomRightRad, bottomRightRad,bottomLeftRad,bottomLeftRad});    return drawable;
    }
}
