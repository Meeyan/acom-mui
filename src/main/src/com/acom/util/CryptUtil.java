package com.acom.util;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 加密解密工具类
 *
 * @author zhaojy
 * @createTime 2017-06-14
 */
public class CryptUtil {

    /**
     * sha1-加密
     *
     * @param enCodeStr 待加密字符串
     * @return String
     */
    public static String sha1(String enCodeStr) {
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
            digest.update(enCodeStr.getBytes());
            StringBuffer hexString = genHexString(digest);
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * @param decript 待加密字符串
     * @return string
     */
    public static String sha(String decript) {
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("SHA");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = genHexString(digest);
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * md5加密方法
     *
     * @param enCodeStr 待加密字符串
     * @return string
     */
    public static String md5(String enCodeStr) {
        try {
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(enCodeStr.getBytes());
            //加密后的字符串
            return genHexString(md5).toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 加密
     *
     * @param content  需要加密的内容
     * @param password 加密密码
     * @return string
     */
    public static byte[] encryptAES(String content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(byteContent);
            return result; // 加密
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | UnsupportedEncodingException
                | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static StringBuffer genHexString(MessageDigest digest) {
        byte[] md = digest.digest();
        // 把密文转换成十六进制的字符串形式
        StringBuffer hexString = new StringBuffer();
        // 字节数组转换为 十六进制 数
        for (int i = 0; i < md.length; i++) {

            /**
             * 0x表示16进制，F=15，在16进制中为16，FF=15*16^1+15*16^0=255 <p/>
             * &:按位与运算，两边的数组都转为二进制（问题：负数的表示方法：按位取反再+1），然后按位与运算。
             */
            String shaHex = Integer.toHexString(md[i] & 0xFF);  //  作用：将负值转为其对应的正数，然后再转成16进制
            // 长度不够2位，则补0
            if (shaHex.length() < 2) {
                hexString.append("0");
            }

            // 经过上面的处理，保证出来的结果都是两位的16进制数
            hexString.append(shaHex);
        }
        return hexString;
    }

    /**
     * 解密
     *
     * @param content  待解密内容
     * @param password 解密密钥
     * @return bytes
     */
    public static byte[] decryptAES(byte[] content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(content);
            return result; // 加密
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * BASE64解密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String decryptBASE64(String key) {

        return "";
    }

    /**
     * BASE64加密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(String key) {

        return "";
    }

    public static void main(String[] args) {
        System.out.println(CryptUtil.sha1("aaa"));
    }
}
