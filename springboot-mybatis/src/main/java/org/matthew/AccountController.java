package org.matthew;

import org.matthew.entity.Account;
import org.matthew.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Matthew
 * @Date: 2019/8/11
 * @Time: 9:53
 * @Description: No Description
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    //查询所有
    @RequestMapping(value ="/list",method = RequestMethod.GET)
    public List<Account> findAccountList(){
        return accountService.findAccountList();
    }
    //查询
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Account findAccountById(@PathVariable("id") int id){
        return accountService.findAccount(id);
    }
    //更新
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id")int id,@RequestParam(value = "name",required = true)String name,@RequestParam(value = "money",required = true)double money){
        int i= accountService.update(name,money,id);
        if(i==0){
            return "success";
        }
        return "fail";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id")int id) {
        int t= accountService.delete(id);
        if(t==1) {
            return "success";
        }else {
            return "fail";
        }

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name") String name,@RequestParam(value = "money") double money) {
        int t= accountService.add(name,money);
        if(t==1) {
            return "success";
        }else {
            return "fail";
        }

    }
}
