package com.justonetech.system.utils;

/**
 * HQL格式化类
 * @author Chen Junping
 * copy from mpmis
 */
public class FormatUtil
{


    public static final String format(String s, Long tag)
    {
        return format(s, String.valueOf(tag));
    }

    public static final String format(String s, Long tag1, Long tag2)
    {
        return format(s, String.valueOf(tag1), String.valueOf(tag2));
    }

    public static final String format(String s, Long tag1, Long tag2, Long tag3)
    {
        return format(s, String.valueOf(tag1), String.valueOf(tag2), String.valueOf(tag3));
    }

    public static final String format(String s, Long tag1, Long tag2, Long tag3, Long tag4)
    {
        return format(s, String.valueOf(tag1), String.valueOf(tag2), String.valueOf(tag3), String.valueOf(tag4));
    }

    public static final String format(String s, Integer tag)
    {
        return format(s, String.valueOf(tag));
    }

    public static final String format(String s, Integer tag1, Integer tag2)
    {
        return format(s, String.valueOf(tag1), String.valueOf(tag2));
    }

    public static final String format(String s, Integer tag1, Integer tag2, Integer tag3)
    {
        return format(s, String.valueOf(tag1), String.valueOf(tag2), String.valueOf(tag3));
    }

    public static final String format(String s, Integer tag1, Integer tag2, Integer tag3, Integer tag4)
    {
        return format(s, String.valueOf(tag1), String.valueOf(tag2), String.valueOf(tag3), String.valueOf(tag4));
    }


    public static final String format(String s, String tag)
    {
        String[] tags = {tag};
        return format(s, tags);
    }

    public static final String format(String s, String tag1, String tag2)
    {
        String[] tags = {tag1, tag2};
        return format(s, tags);
    }

    public static final String format(String s, String tag1, String tag2, String tag3)
    {
        String[] tags = {tag1, tag2, tag3};
        return format(s, tags);
    }

    public static final String format(String s, String tag1, String tag2, String tag3, String tag4)
    {
        String[] tags = {tag1, tag2, tag3, tag4};
        return format(s, tags);
    }

    public static final String format(String s, String tag1, String tag2, String tag3, String tag4, String tag5)
    {
        String[] tags = {tag1, tag2, tag3, tag4, tag5};
        return format(s, tags);
    }

    public static final String format(String s, String tag1, String tag2, String tag3, String tag4, String tag5, String tag6)
    {
        String[] tags = {tag1, tag2, tag3, tag4, tag5, tag6};
        return format(s, tags);
    }

    public static final String format(String s, String[] tags)
    {
        for (int i = 0; i < tags.length; i++)
        {

            s = s.replaceAll("\\{" + i + "\\}", tags[i] == null ? "" : tags[i]);
        }
        return s;
    }
    
    public static void main(String[] args)
    {
    }

}
