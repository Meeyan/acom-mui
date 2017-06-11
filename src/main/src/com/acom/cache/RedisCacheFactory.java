package com.acom.cache;

import java.util.Map;

/**
 * 初始化cache-redis
 * redis缓存工厂类，所有的缓存业务都必须实现该抽象类，在实现的方法中，重写初始化方法和获取缓存方法，可以参考：PrivilegeCacheImpl
 *
 * @author zhaojy
 * @createTime 2017-06-08
 */
public abstract class RedisCacheFactory {

    /**
     * 初始化Cache方法
     *
     * @param implKey
     */
    public abstract void initCache(String implKey);

    public abstract Map getCache(String key);

    /**
     * 获取Cache
     *
     * @param clazz 字节码
     * @param key   关键节点
     * @return Map
     */
    public final static Map getCacheWithClass(Class clazz, String key) {
        RedisCacheFactory cacheFactory = null;
        try {
            cacheFactory = (RedisCacheFactory) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map cache = null;
        if (null != cacheFactory) {
            cache = cacheFactory.getCache(key);
        }
        return cache;
    }
}
