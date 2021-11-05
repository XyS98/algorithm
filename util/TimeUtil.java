package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 和时间有关的工具类
 * 
 * @param <T>
 */
public class TimeUtil<T> {
    public T code;

    /**
     * 将 Long 类型的时间转为 秒 返回
     * @param longTime long 类型的时间
     * @return 秒
     */
    public static  String getFormateSecond(long longTime){
        SimpleDateFormat df = new SimpleDateFormat("ss");
        String time = df.format(new Date(longTime));
        return time;
    }
}