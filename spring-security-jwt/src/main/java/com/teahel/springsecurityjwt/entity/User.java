package com.teahel.springsecurityjwt.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class User {
    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 账户名称
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户角色 FetchType.EAGER:敏捷  CascadeType.ALL：所有操作
     */
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Role> roles;
}
