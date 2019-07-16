package org.matthew;

import redis.clients.jedis.Jedis;

import java.util.List;

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
        //new Redis().delete();
      // new Redis().key();
       // new Redis().list();
        new Redis().set();
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
        String text = jedis.get("one");
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

    /**
     * 获取key的值
     */
    public void key(){
     System.out.println(jedis.exists("two"));
    }

    public void list(){
        // 从头添加
       jedis.lpush("list", "tom", "jack", "jason", "peter", "lc", "easy");

       // 从尾添加
       jedis.rpush("list", "andy", "eleven");

      // 返回List长度
      jedis.llen("list");

      // 取值
        List<String> list = jedis.lrange("list", 0, -1);
         for (String string : list) {
          System.out.println(string);
         }


    }

    //操作Set
        public void set() {
            jedis.sadd("city", "北京", "上海", "南京", "武汉", "安徽", "广州", "深圳", "山东");
            System.out.println("取最上面的值：" + jedis.spop("city"));
            System.out.println("随机取值" + jedis.srandmember("city"));

            jedis.sadd("city2", "北京", "武汉", "河北", "张家界", "辽林", "云南", "陕西", "山西", "黑龙江");
            System.out.println("交集：" + jedis.sinter("city", "city1"));
            System.out.println("并集：" + jedis.sunion("city", "city1"));
            System.out.println("差集：" + jedis.sdiff("city", "city1"));
        }

}
