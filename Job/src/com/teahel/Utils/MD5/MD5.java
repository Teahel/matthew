package com.teahel.Utils.MD5;

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
public class MD5 {
    public static byte[] eccrypt(String info) throws NoSuchAlgorithmException {
        //获取MD5的MessageDigest对象
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] srcBytes = info.getBytes();
        md5.update(srcBytes);
        byte[] resultBytes = md5.digest();
        return resultBytes;
    }


    public static void main(String args[]) throws NoSuchAlgorithmException{
        String msg = "11";
        byte[] resultBytes = MD5.eccrypt(msg);
        String ss=ParseSystemUtil.parseByte2HexStr(resultBytes);
        System.out.println("密文："+new String(ss));
        System.out.println(msg);
        if(ss.equals("6512BD43D9CAA6E02C990B0A82652DCA")){
            System.out.println("输入正确");
        }

        String md5code = new BigInteger(1, resultBytes).toString(16);// 16进制数字
        System.out.println("计息："+md5code);
    }
}
