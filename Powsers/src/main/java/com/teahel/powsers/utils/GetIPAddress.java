package com.teahel.powsers.utils;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/4/8
 * Time: 23:41
 * Description: 获取ip
 */
@Component
public class GetIPAddress {
    /**
     * 根据获取请求中的ip地址
     * @param request
     * @return
     */
    public String GetIPAddress(HttpServletRequest request) {
        try {
            String remoteAddress="";
            if (request != null) {
                remoteAddress = request.getHeader("X-Forwarded-For");
                if (remoteAddress == null || "".equals(remoteAddress)) {
                    remoteAddress = request.getRemoteAddr();
                }
            }
            remoteAddress=remoteAddress!=null && remoteAddress.contains(",")? remoteAddress.split(",")[0]: remoteAddress;
            return remoteAddress;
        } catch (Exception e) {
            return null;
        }
    }
}
