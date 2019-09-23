package com.matthew.Utils;

import org.springframework.util.DigestUtils;

/**
 * @Author: L.T.J
 * @project core_start
 * @package com.matthew.Utils
 * @CreateDate: 2019/9/23 17:53
 * @Version: 1.0
 */
public class MD5Utils {
  public static boolean md5(String newPassWord,String oldPassWord){
      //使用spring自带的md5加密方式
      if(oldPassWord.equals(DigestUtils.md5DigestAsHex(newPassWord.getBytes()))){
          return true;
      }
      return false;
  }
}
