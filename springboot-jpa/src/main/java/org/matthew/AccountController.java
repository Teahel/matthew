package org.matthew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author : Matthew
 * @Date: 2019/8/10
 * @Time: 18:37
 * @Description: No Description
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountDao accountDao;

    //查詢所有信息
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Account> getAccounts(){
        return accountDao.findAll();
    }

    //查询某一个数据的时候
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Optional<Account> getAccountById(@PathVariable("id")int id){
        return accountDao.findById(id);
    }

    //更新
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String updateAccount(@RequestParam("id") int id, @RequestParam(value = "name",required = true)String name,@RequestParam(value = "money",required = true) double money){
        Account account=new Account();
        account.setMoney(money);
        account.setName(name);
        account.setId(id);
        Account account1=accountDao.saveAndFlush(account);
        return account1.toString();
    }

    //保存
    @RequestMapping(value = "/insert",method = RequestMethod.GET)
    public String postAccount(@RequestParam(value = "name")String name,@RequestParam(value = "money") double money){
        Account account=new Account();
        account.setMoney(money);
        account.setName(name);
        Account account1=accountDao.save(account);
        return account1.toString();
    }

}
