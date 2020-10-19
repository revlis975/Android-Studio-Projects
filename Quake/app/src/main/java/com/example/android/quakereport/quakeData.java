package com.example.android.quakereport;


import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class quakeData {

    private String mMag;
    private String mPlace;
    private Long mDate;
    private String mUrl;
    quakeData(String mag, String place, Long date, String url)
    {
        mMag = mag;
        mPlace = place;
        mDate = date;
        mUrl = url;
    }

    public String getMag()
    {
        return mMag;
    }

    public String getPlace()
    {
        return mPlace;
    }

    public String getDate()
    {
        /*long timeInMilliseconds = mDate;
        Date dateObject = new Date(timeInMilliseconds);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("LLL DD, yyyy");
        String mDate = dateFormatter.format(dateObject);
        Log.v("DATE_SHIZZ","Bizzare Date? "+mDate+timeInMilliseconds);*/
        return mDate.toString();
    }

    public long getTimeInMilliseconds()
    {
        return mDate;
    }

    public String getUrl()
    {
        return mUrl;
    }


}
