package com;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 信息摘要算法。
 * @author xxquan
 * @since 2023-11-05
 */
public class messageDigest {
    /**
     * 获取MD5摘要。
      * @param text 消息原文
     * @return MD5摘要
     */
    public static String getMD5(String text) throws NoSuchAlgorithmException {
        return getDigest(text, "MD5");
    }

    /**
     * 获取SHA1摘要。
     * @param text 消息原文
     * @return SHA1摘要
     */
    public static String getSHA1(String text) throws NoSuchAlgorithmException {
        return getDigest(text, "SHA1");
    }

    /**
     * 获取SHA256摘要。
     * @param text 消息原文
     * @return SHA256摘要
     */
    public static String getSHA256(String text) throws NoSuchAlgorithmException {
        return getDigest(text, "SHA-256");
    }

    /**
     * 获取SHA512摘要。
     * @param text 消息原文
     * @return SHA512摘要
     */
    public static String getSHA512(String text) throws NoSuchAlgorithmException {
        return getDigest(text, "SHA-512");
    }

    /**
     * 获取信息摘要值。
     * @param text 原文
     * @param algorithm 摘要算法
     * @return MD5摘要
     */
    private static String getDigest(String text, String algorithm) throws NoSuchAlgorithmException {
        // 创建消息摘要对象
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);

        // 执行消息摘要算法，返回摘要值
        byte[] digest = messageDigest.digest(text.getBytes());

        // 将以上获取的摘要值取16进制，就是普遍意义上的“MD5/SHA1/SHA256/SHA512”摘要了。
        StringBuilder ret = new StringBuilder();
        for (byte b : digest) {
            String s = Integer.toHexString(b & 0xff);
            // 若s只有一位，在前面补0
            if (s.length() == 1) s = "0" + s;
            ret.append(s);
        }

        return ret.toString();
    }

}
