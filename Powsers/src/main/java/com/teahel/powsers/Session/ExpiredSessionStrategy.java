package com.teahel.powsers.Session;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/4/14
 * Time: 16:15
 * Description: 当一个账户登录之后，后面该账户再次登录会执行此事件。
 */
public class ExpiredSessionStrategy implements SessionInformationExpiredStrategy {
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {

    }
}
