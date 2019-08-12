package com.teahel.powsers.utils;

import com.teahel.powsers.service.impl.PoweruserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/3/24
 * Time: 22:49
 * Description: md5加密
 */
public class MD5Utils {
    private static Logger logger = LoggerFactory.getLogger(MD5Utils.class);

    public static byte[] eccrypt(String info) throws NoSuchAlgorithmException {
        logger.debug("加密密码"+info);
        //获取MD5的MessageDigest对象
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] srcBytes = info.getBytes();
        md5.update(srcBytes);
        byte[] resultBytes = md5.digest();
        return resultBytes;
    }

    public static String getMD5(String password){
        try{
            byte[] resultBytes = eccrypt(password);
            String pd=ParseSystemUtil.parseByte2HexStr(resultBytes);
            logger.debug("加密完成");
            return pd;
        }catch (Exception e){
            logger.debug("MD5加密异常");
        }
        return "";
    }
}
