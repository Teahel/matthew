package com.teahel.Utils.MD5;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/3/24
 * Time: 23:02
 * Description:
 * 高级加密标准（英语：Advanced Encryption Standard，缩写：AES），
 * 在密码学中又称Rijndael加密法，是美国联邦政府采用的一种区块加密标准。
 * 由美国国家标准与技术研究院（NIST）发布于FIPS PUB 197，并在2002年5月26日成为有效的标准。是对称密钥加密中最流行的算法之一。
 */
public class AES {
    private KeyGenerator keygen;
    private SecretKey deskey;
    private Cipher cipher;
    private byte[] cipherByte;

    public AES() throws NoSuchAlgorithmException, NoSuchPaddingException {
        keygen = KeyGenerator.getInstance("AES");
        deskey = keygen.generateKey();
        cipher = Cipher.getInstance("AES");
    }

    /**
     * 加密
     * @param str
     * @return
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public byte[] Encrytor(String str) throws InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.ENCRYPT_MODE, deskey);
        byte[] src = str.getBytes();
        cipherByte = cipher.doFinal(src);
        return cipherByte;
    }

    /**
     * 解密
     * @param buff
     * @return
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public byte[] Decryptor(byte[] buff) throws InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.DECRYPT_MODE, deskey);
        cipherByte = cipher.doFinal(buff);
        return cipherByte;
    }

    /**
     * @param args
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws InvalidKeyException
     */
    public static void main(String[] args) throws Exception {
        AES aes = new AES();
        String msg ="皇子讲java密码技术";
        byte[] encontent = aes.Encrytor(msg);
        byte[] decontent = aes.Decryptor(encontent);
        System.out.println("明文:" + msg);

        //2进制转为16进制
      /* String ss =ParseSystemUtil.parseByte2HexStr(encontent);
       System.out.println("密文:" + ss);
       System.out.println("解密:" + new String(decontent));*/



    }
}
  /*  String content = "美女，约吗？";
    String password = "123";
        System.out.println("加密之前：" + content);

                // 加密
                byte[] encrypt = AesTest.encrypt(content, password);
                System.out.println("加密后的内容：" + new String(encrypt));

                // 解密
                byte[] decrypt = AesTest.decrypt(encrypt, password);
                System.out.println("解密后的内容：" + new String(decrypt));  */