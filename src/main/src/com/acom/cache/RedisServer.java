package com.acom.cache;

import com.acom.exe.factory.ExeBeanFactory;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * redis 服务器
 * 获取redis-server的单例服务
 *
 * @author zhaojy
 * @createTime 2017-06-08
 */
public class RedisServer {

    private static ShardedJedisPool pool;

    private static RedisServer server;

    private RedisServer() {
    }

    /**
     * 初始化redis连接池
     *
     * @author zhaojy
     * @createTime 2017-06-09
     */
    private static void initJedisPool() {
        JedisPoolConfig config = (JedisPoolConfig) ExeBeanFactory.getService(JedisPoolConfig.class);

        List<JedisShardInfo> infoList = new ArrayList<JedisShardInfo>();

        JedisShardInfo shardInfo = (JedisShardInfo) ExeBeanFactory.getService(JedisShardInfo.class);
        infoList.add(shardInfo);

        // 开始初始化pool连接池
        pool = new ShardedJedisPool(config, infoList);
        // 模拟单利模式
        server = new RedisServer(); // creationStackTrace属性有错误出来
    }

    /**
     * 获取ShardedJedis
     *
     * @return ShardedJedis
     */
    public static ShardedJedis getJedis() {
        if (server == null) {
            synchronized (RedisServer.class) {
                initJedisPool();
            }
        }
        return pool.getResource();
    }

    public static void main(String[] args) {
        ShardedJedis jedis = RedisServer.getJedis();
        System.out.println(jedis.get("name"));
    }
}
