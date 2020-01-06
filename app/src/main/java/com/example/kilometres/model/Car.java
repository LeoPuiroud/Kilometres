package com.example.kilometres.model;

import java.util.Date;

public class Car {

    private String mName;
    private int mMaxKilometers;
    private int mCurrentKilometers;
    private int mNumberofMonths;
    private String  mStartDate;

    public int getMaxKilometers() {
        return mMaxKilometers;
    }

    public void setMaxKilometers(int maxKilometers) {
        mMaxKilometers = maxKilometers;
    }

    public int getCurrentKilometers() {
        return mCurrentKilometers;
    }

    public void setCurrentKilometers(int currentKilometers) {
        mCurrentKilometers = currentKilometers;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getNumberofMonths() {
        return mNumberofMonths;
    }

    public void setNumberofMonths(int numberofMonths) {
        mNumberofMonths = numberofMonths;
    }

    public String getStartDate() {
        return mStartDate;
    }

    public void setStartDate(String startDate) {
        mStartDate = startDate;
    }
}
