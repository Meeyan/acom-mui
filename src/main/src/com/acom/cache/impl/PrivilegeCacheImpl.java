package com.acom.cache.impl;

import com.acom.cache.RedisCacheFactory;
import com.acom.cache.RedisServer;
import com.acom.entities.mapper.PrivilegeMapper;
import com.acom.entities.model.Privilege;
import com.acom.services.sv.IAdminUserService;
import com.acom.services.sv.IBsCacheTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 初始化权限缓存，该缓存决定后台各种访问权限
 *
 * @author zhaojy
 * @createTime 2017-06-09
 */
@Service(value = "PrivilegeCacheImpl")
public class PrivilegeCacheImpl extends RedisCacheFactory {

    @Resource(name = "adminUserService")
    IAdminUserService adminUserService;

    @Resource(name = "bsCacheTable")
    IBsCacheTableService tableService; //

    @Autowired
    private PrivilegeMapper privilegeMapper;

    private static String CACHE_KEY = "ADMIN_PRIVILEGE";

    // 标识url是否可以访问，1：可以访问有权限，否则无权限访问

    public static String IS_ACCESS = "IS_ACCESS";

    /**
     * 初始化cache方法
     */
    @Override
    public void initCache(String implKey) {
        List<Privilege> allPrivileges = adminUserService.getAllPrivileges();

        if (null != allPrivileges && allPrivileges.size() > 0) {
            ShardedJedis jedis = RedisServer.getJedis();
            Map<String, String> map = new HashMap<>();
            for (Privilege privilege : allPrivileges) {
                String url = privilege.getUrl();
                map.put(url, "1");
            }
            jedis.hmset(PrivilegeCacheImpl.CACHE_KEY, map);
        }
    }

    /**
     * 获取Cache
     *
     * @param key 关键key
     */
    public Map getCache(String key) {
        ShardedJedis jedis = RedisServer.getJedis();
        List<String> cacheList = jedis.hmget(CACHE_KEY, key);
        Map<String, Integer> map = new HashMap<>();
        if (cacheList != null && cacheList.size() > 0) {
            String ac = cacheList.get(0);
            if (null != ac) {
                map.put(IS_ACCESS, Integer.valueOf(ac));
            }
            return map;
        }
        return map;
    }
}
