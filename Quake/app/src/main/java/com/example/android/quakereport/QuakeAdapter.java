package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;

public class QuakeAdapter extends ArrayAdapter<quakeData> {

    QuakeAdapter(Context context, ArrayList<quakeData> earthquakes)
    {
        super(context,0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView==null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        quakeData currentQuake = getItem(position);

        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(Double.parseDouble(currentQuake.getMag()));

        TextView magTextView = (TextView)listItemView.findViewById(R.id.mag);
        magTextView.setText(""+output);

        if(currentQuake.getPlace().contains("of")) {
            int of = currentQuake.getPlace().indexOf("f");
            TextView placeTextView = (TextView) listItemView.findViewById(R.id.place);
            placeTextView.setText(currentQuake.getPlace().substring(0, of + 2));

            String place2 = currentQuake.getPlace().substring(of + 2);

            TextView placeTextView2 = (TextView) listItemView.findViewById(R.id.place2);
            placeTextView2.setText(place2);
        }

        else
        {
            TextView placeTextView = (TextView) listItemView.findViewById(R.id.place);
            placeTextView.setText("NEAR THE");


            TextView placeTextView2 = (TextView) listItemView.findViewById(R.id.place2);
            placeTextView2.setText(currentQuake.getPlace());
        }

        Date dateObject = new Date(currentQuake.getTimeInMilliseconds());

        TextView dateTextView = (TextView)listItemView.findViewById(R.id.date);
        String formattedDate = formatDate(dateObject);
        dateTextView.setText(formattedDate);

        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeTextView.setText(formattedTime);

        GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        double a = Double.parseDouble(currentQuake.getMag());
        int c = (int)a;
        int magnitudeColor = getMagnitudeColor(c);

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        return listItemView;

    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
//        Log.v("DATE_SHIZZ","Bizzare Date? "+dateFormat.format(dateObject));
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private int getMagnitudeColor(int c)
    {
        int magColor;
        switch(c)
        {
            case 0:
            case 1: magColor = ContextCompat.getColor(getContext(), R.color.magnitude1); break;
            case 2: magColor = ContextCompat.getColor(getContext(), R.color.magnitude2); break;
            case 3: magColor = ContextCompat.getColor(getContext(), R.color.magnitude3); break;
            case 4: magColor = ContextCompat.getColor(getContext(), R.color.magnitude4); break;
            case 5: magColor = ContextCompat.getColor(getContext(), R.color.magnitude5); break;
            case 6: magColor = ContextCompat.getColor(getContext(), R.color.magnitude6); break;
            case 7: magColor = ContextCompat.getColor(getContext(), R.color.magnitude7); break;
            case 8: magColor = ContextCompat.getColor(getContext(), R.color.magnitude8); break;
            case 9: magColor = ContextCompat.getColor(getContext(), R.color.magnitude9); break;
            case 10:
            default: magColor = ContextCompat.getColor(getContext(), R.color.magnitude10plus); break;
        }

        return magColor;
    }
}
