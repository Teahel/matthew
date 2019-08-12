package com.teahel.powsers.controller;

import com.teahel.powsers.beans.Poweruser;
import com.teahel.powsers.beans.ResObject;
import com.teahel.powsers.beans.User;
import com.teahel.powsers.service.IPoweruserService;
import org.omg.CORBA.portable.ResponseHandler;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Api(description = "用户接口")
@RestController
@RequestMapping("/demoController")
public class DemoController {
    @Resource
    private IPoweruserService poweruserService;

    @ApiOperation(value = "新增用户" ,  notes="新增注册")
    @RequestMapping(value="/createUser",method=RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResObject createUser(@RequestBody User user){
    	System.out.println("createUser:::"+user.toString());
        return new ResObject(HttpStatus.OK.value(), "新增成功.");
    }

    @ApiOperation(value = "修改用户" ,  notes="修改用户")
    @RequestMapping(value="/updateUser",method=RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResObject updateUser(@RequestBody User user){
    	System.out.println("updateUser:::"+user.toString());
    	return new ResObject(HttpStatus.OK.value(), "修改成功.");
    }

    @ApiOperation(value = "删除用户" ,  notes="删除用户")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userId", value = "用户标识", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value="/deleteUser",method=RequestMethod.DELETE)
    public ResObject deleteUser(@RequestParam("userId") String userId){
    	System.out.println("deleteUser:::"+userId);
    	return new ResObject(HttpStatus.OK.value(), "删除成功.");
    }

    @ApiOperation(value = "查询用户" ,  notes="查询用户")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userId", value = "用户标识", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value="/queryUser",method=RequestMethod.GET)
    public ResObject queryUser(@RequestParam("userId") String userId){

    	//User user = new User(userId, "张三", "******", "mao2080@sina.com");
        Poweruser user= poweruserService.findById(Long.parseLong(userId));
        System.out.println("数据："+user.getPassword());
        return new ResObject(HttpStatus.OK.value(), user);
    }

    @ApiOperation(value = "用户登录" ,  notes="用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "账户", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public ResObject login(@RequestParam("username") String username,@RequestParam("password") String password){
        Poweruser user=null;
        user=poweruserService.findByUsernameAndPassword(username,password);
        String desc=null;
        if(user!=null){
            desc="登录成功！";
        }else {
            desc="登录失败！";
        }
       return new ResObject(HttpStatus.OK.value(),desc );
    }

    /**
     * 登录超时执行此方法
     * @return
     */
    @GetMapping("/session/invalid")
    public ResObject sessionInvalid(){
        String message="session 失效";
        return  new ResObject(HttpStatus.UNAUTHORIZED.value(),message);
    }
}


