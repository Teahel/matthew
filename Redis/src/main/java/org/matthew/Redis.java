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
    protected static Jedis jedis = new Jedis("193.112.65.200", 6379);
    //https://blog.csdn.net/szxiaohe/article/details/52934630
    public static void main(String[] args) {
       //new Redis().save();
       // new Redis().findAll();
       // new Redis().findByKey();
       // new Redis().update();
        new Redis().delete();
        /*jedis.set("hello","javaRedis");
        String hello = jedis.get("hello");
        System.out.println(hello);
        jedis.close();*/

    }

    //保存String
    public void save(){
        jedis.set("one","1");
        jedis.set("one","1");
        jedis.set("one","1");
    }



    /**
     * 没用过
     */
    public void  findAll(){
      String ss = jedis.get("*");
      System.out.println(ss);
    }

    /**
     * 查询某一个key的值
     */
    public void findByKey(){
        String text = jedis.get("two");
        System.out.println(text);
    }

    /**
     * 更新、修改某一个key的值
     */
    public void update(){
        jedis.rename("one","two");

    }
    public void delete(){
        jedis.del("one");
    }
}
