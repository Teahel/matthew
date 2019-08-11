package org.matthew.dao;

import org.apache.ibatis.annotations.*;
import org.matthew.entity.Account;

import java.util.List;

/**
 * @author : Matthew
 * @Date: 2019/8/10
 * @Time: 20:39
 * @Description:
 */
@Mapper
public interface AccountMapper {
    //插入
    @Insert("insert into account(name,money)values(#{name},#{money})")
    int add(@Param("name")String name,@Param("money")double money);

    //更新
    @Update("update account set name=#{name},money=#{money}where id=#{id}")
    int update(@Param("name")String name,@Param("money")double money,@Param("id") int id);

    //删除
    @Delete("delete from account where id=#{id}")
    int delete(int id);

    //查询
    @Select("select id,name as name,money as money from account where id=#{id}")
    Account findAccount(@Param("id") int id);

    @Select("select id,name as name,money as money from account")
    List<Account> findAccountList();

}
