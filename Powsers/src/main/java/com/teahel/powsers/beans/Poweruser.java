package com.teahel.powsers.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/4/2
 * Time: 23:18
 * Description:账户表
 */
@Entity
public class Poweruser {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String powerclass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPowerclass() {
        return powerclass;
    }

    public void setPowerclass(String powerclass) {
        this.powerclass = powerclass;
    }
}
