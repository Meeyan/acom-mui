package com.acom.exe.factory;

import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * bean工场，可以配置非单例模式，需要调整配置文件，普通bean无须配置单例，只有dao层需要
 *
 * @author:zhaojy
 * @createTime:2017-06-07
 */
public final class ExeBeanFactory {

    private static Logger logger = Logger.getLogger(ExeBeanFactory.class);

    private static GenericXmlApplicationContext context;

    private ExeBeanFactory() {
    }

    /**
     * 同步初始化bean信息
     */
    private static void loadFactory() {
        synchronized (ExeBeanFactory.class) {

            if (context == null) {
                logger.error("--------------ready to init exe bean factory");
                context = new GenericXmlApplicationContext();
                context.setValidating(false);
                context.load("configs/exeFrame.xml");
                context.refresh();
                logger.error("--------------init exe bean factory finished");
            }
        }
    }

    /**
     * 获取服务
     *
     * @param clazz
     * @return
     */
    public static Object getService(Class clazz) {
        if (context == null) {
            ExeBeanFactory.loadFactory();
        }

        if (context != null) {
            return context.getBean(clazz);
        }
        return null;
    }

    /**
     * 获取服务
     *
     * @param beanId
     * @return
     */
    public static Object getService(String beanId) {
        if (context == null) {
            ExeBeanFactory.loadFactory();
        }

        if (context != null) {
            return context.getBean(beanId);
        }
        return null;
    }
}
