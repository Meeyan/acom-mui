package com.acom.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author zhaojy
 * @createTime 2017-06-30
 */
public class TimeUtil {

    public final static SimpleDateFormat yyyy_MM_dd_HH_mm_ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取时间-标准timestamp格式
     *
     * @return Timestamp
     * @author zhaojy
     * @createTime 2017-06-30
     */
    public static Timestamp getStandardTimestamp() {
        String date = yyyy_MM_dd_HH_mm_ss.format(new Date());
        return Timestamp.valueOf(date);
    }

    /**
     * 获取时间-string格式（标准Timestamp）
     *
     * @return String
     * @author zhaojy
     * @createTime 2017-06-30
     */
    public static String getStandardTimestampStr() {
        return yyyy_MM_dd_HH_mm_ss.format(new Date());
    }
}
