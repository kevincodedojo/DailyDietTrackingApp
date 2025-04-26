package com.example.dailydiettrackingapp.data;

import androidx.room.TypeConverter;

import java.util.Date;

public class Converters {

    @TypeConverter
    public static Date fromTimestamp(Long value) {
        if (value == null) {
            return null;
        } else {
            return new Date(value);
        }
    }
    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        if (date == null) {
            return null;
        } else {
            return date.getTime();
        }
    }
}