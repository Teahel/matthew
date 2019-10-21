package com.matthew.controller;

import com.matthew.Utils.ReturnResultUtils;
import com.matthew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: L.T.J
 * @project core_start
 * @package com.matthew.controller
 * @CreateDate: 2019/9/19 17:44
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping( value = "/login",method = RequestMethod.GET)
    public ReturnResultUtils login(HttpServletRequest request){

        ReturnResultUtils resultUtils=new ReturnResultUtils();
        String username =request.getParameter("username");
        String password =request.getParameter("password");

        if (StringUtils.isEmpty(userService.login(username,password))){
            ReturnResultUtils returnResultUtils=new ReturnResultUtils();
            resultUtils=returnResultUtils.error(500,"账户或者密码错误！");
        } else {
            request.getSession();
            resultUtils.put("code","000");
            resultUtils.put("msg","登录成功！");
        }
        return resultUtils;
    }


    /**
     * 判断用户的session是否有效（在同一个浏览器中，同一个域中，每次Request请求，都会带上Session）
     * @param request  //其他的请求在请求前，先请求是否session有效
     * @return
     */
    @RequestMapping(value = "isValid",method = RequestMethod.GET)
    public String isSessionValid(HttpServletRequest request) {
        //简化if-else表达式（其实很多地方可以简化的，这里为了方便新手朋友可以看得顺畅点，我尽量不简化）
        return request.isRequestedSessionIdValid() ? "ok" : "no";
    }


    /**
     * 注销登录
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();//使Session变成无效，及用户退出
        return "logout";
    }

}
