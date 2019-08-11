package org.matthew.service;

import org.matthew.dao.AccountMapper;
import org.matthew.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : Matthew
 * @Date: 2019/8/11
 * @Time: 9:44
 * @Description: No Description
 */
@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    //增加
    @Transactional
    public int add(String name,double money){
        return accountMapper.add(name,money);
    }

    //更新
    @Transactional
    public int update(String name,double money,int id){
        return accountMapper.update(name,money,id);
    }

    //删除
    public int delete(int id){
        return accountMapper.delete(id);
    }
    //查询
    public Account findAccount(int id){
        return  accountMapper.findAccount(id);
    }
    //查询所有
    public List<Account> findAccountList(){
        return accountMapper.findAccountList();
    }



}
