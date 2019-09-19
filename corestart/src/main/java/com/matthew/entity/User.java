package com.matthew.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author: L.T.J
 * @project core_start
 * @package com.matthew.entity
 * @CreateDate: 2019/9/19 11:28
 * @Version: 1.0
 */
@Data
@TableName("user")
public class User {
    /**
     *     id
     */
    @TableId(type=IdType.UUID)
    private  String useId;
    /**
     * 账户姓名
     */
    @NotNull(message = "账户不能为空")
    private  String userName;
    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    private  String passWord;
    /**
     * email
     */
    private  String email;
    /**
     * github地址
     */
    private  String githubAddress;


}
