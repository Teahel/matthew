package org.matthew;

import redis.clients.jedis.Jedis;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/7/16
 * Time: 0:57
 * Description: No Description
 */
public class Redis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("193.112.65.200", 6379);
        jedis.set("hello","javaRedis");
        String hello = jedis.get("hello");
        System.out.println(hello);
        jedis.close();
    }


}
