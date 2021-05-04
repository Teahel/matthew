package com.teahel.springsecurityjwt.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author li.teahel@gmail.com
 * @date 2021/4/28
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    /**
     * 判断账户和密码
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("foo","foo",new ArrayList<>());
    }
}
