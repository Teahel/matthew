package com.matthew.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: L.T.J
 * @project mybatis_plus
 * @package com.matthew.entity
 * @CreateDate: 2019/9/2 11:49
 * @Version: 1.0
 */
@Data
@TableName("user")
public class User {
    @TableId(type = IdType.UUID)
    private String  id;
    private String name;
    private Integer age;
    private String email;
}
