package com.acom.util;

import org.apache.log4j.Logger;

/**
 * 日志工厂
 *
 * @author zhaojy
 * @createTime 2017-06-30
 */
public class LogFactory {

    public static Logger getLogger(Class clazz) {
        return Logger.getLogger(clazz);
    }
}
