package me.photran.youtube;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by photran on 4/11/16.
 */
public class Utils {
    public static void doLog(String text) {
        Log.v("Application", text);
    }

    public static String getYoutubeIdFormUrl(String url) {
        String pattern = "(?<=watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*";

        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(url);

        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }
}
