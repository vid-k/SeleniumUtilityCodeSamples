package com.MockPreps;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatetimeExample {

    public static void main(String args[]) {
        Date date = new Date();
        System.out.println("Just date: " + date);

        SimpleDateFormat f = new SimpleDateFormat("mm/dd/yyyy-HH:mm:ss");
        System.out.println("Formatted date: " + f.format(date));

        System.out.println("Calendar getinstance(): " + Calendar.getInstance().toString());

        System.out.println("currentTimeMillis(): " + System.currentTimeMillis());
    }

}


