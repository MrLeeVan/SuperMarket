package main.Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Leevan
 * @Date： 2018/11/22 14:50
 */
public class DateUtils {
    public static String toDate(Date date){
        DateFormat df = new SimpleDateFormat( "yyyy-MM-dd  hh:mm:ss" );
        return df.format( date );

    }
}
