package org.matthew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

/**
 * @author : Matthew
 * @Date: 2019/8/11
 * @Time: 11:12
 * @Description: No Description
 */
@Repository
public class RedisDao {
    @Autowired
    private StringRedisTemplate  template;

    public void setKey(String key,String value){
        ValueOperations<String,String> ops=template.opsForValue();
        ops.set(key, value);
    }

    public String getValue(String key){
        ValueOperations<String,String> ops= this.template.opsForValue();
        return ops.get(key);
    }

}
