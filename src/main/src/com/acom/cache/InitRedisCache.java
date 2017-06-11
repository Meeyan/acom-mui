package com.acom.cache;

import com.acom.entities.model.BsCacheTable;
import com.acom.exe.factory.ExeBeanFactory;
import com.acom.services.sv.IBsCacheTableService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.Resource;
import java.util.List;

/**
 * spring启动时，采用bean的方式初始化redis缓存，依赖配置表
 *
 * @autho zhaojy
 * @createTime 2017-06-08
 */
public class InitRedisCache implements InitializingBean {

    private Logger logger = Logger.getLogger(InitRedisCache.class);

    @Resource(name = "bsCacheTable")
    IBsCacheTableService cacheTableService;

    public void afterPropertiesSet() {
        // 查询配置的表
        List<BsCacheTable> tableList = cacheTableService.getCacheTables(1);
        if (null != tableList && tableList.size() > 0) {
            for (BsCacheTable cacheTable : tableList) {
                String classPath = cacheTable.getClassPath();   // 针对每一个配置类，给予初始化

                long startTime = System.currentTimeMillis();
                logger.error("----prepare to init cache:" + classPath + "-----start");
                Class aClass = null;
                try {
                    // 使用反射的方式，对应的sv拿不到注入的bean，所以采用exeFactory获取Bean，这样，整个Cache队列，只会初始化一次ExeBeanFactory
                    aClass = Class.forName(classPath);
                    RedisCacheFactory cacheFactory = (RedisCacheFactory) ExeBeanFactory.getService(aClass);
                    cacheFactory.initCache("");
                } catch (Exception e) {
                    logger.error("----init cache:" + classPath + ",error happens:" + e.getMessage());
                    return;
                }
                long endTime = System.currentTimeMillis();

                logger.error("----init cache :" + classPath + "-----end, cache took " + (endTime - startTime) + " milliseconds.");
            }
        }
    }
}