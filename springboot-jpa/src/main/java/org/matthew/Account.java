package org.matthew;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author : Matthew
 * @Date: 2019/8/10
 * @Time: 18:32
 * @Description: No Description
 */
@Entity
public class Account {

     @Id
     @GeneratedValue
     private int id;
     private String name;
     private double money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
