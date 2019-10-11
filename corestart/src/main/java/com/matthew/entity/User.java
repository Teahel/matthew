package com.matthew.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**用户信息
 * @Author: L.T.J
 * @project core_start
 * @package com.matthew.entity
 * @CreateDate: 2019/9/19 11:28
 * @Version: 1.0
 */
@Data
@TableName("user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * userid 主键
     */
    @TableId(type=IdType.UUID)
    private  String userid;
    /**
     * 账户姓名
     */
    @NotNull(message = "账户不能为空")
    private  String username;
    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    private  String password;
    /**
     * email
     */
    private  String email;
    /**
     * github地址
     */
    private  String githubaddress;

    /**
     * 头像地址
     */
    private  String imageaddress;
}
