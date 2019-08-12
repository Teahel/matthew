package com.teahel.powsers.config;

import com.teahel.powsers.Session.ExpiredSessionStrategy;
import com.teahel.powsers.properties.ConstantProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/4/14
 * Time: 14:44
 * Description: 管理用户登录超时时间、限制上线人数
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * invalidSessionUrl 登录超时之后跳转的路径 也可以是 demo.html
     * maximumSessions 登录最大数
     * maxSessionsPreventsLogin true 为不允许后续登录的人挤掉先登录的人
     * expiredSessionStrategy 出现后续人登录已经登录账号时进行的事件
     * session 默认1分钟 不能设置小于一分钟
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.sessionManagement().invalidSessionUrl("/session/invalid").maximumSessions(1).maxSessionsPreventsLogin(true).expiredSessionStrategy(new ExpiredSessionStrategy());
    }
}
