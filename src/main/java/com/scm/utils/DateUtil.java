package com.scm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static Date StringtoDate(String dateString){
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(dateString);
        } catch (
                ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
