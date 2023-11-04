package com;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * 加解密工具。
 * @author xxquan
 * @since 2023-11-04
 */
public class encryptUtils {

    // FIXME:秘钥硬编码。
    // DES加密方式要求KEY必须为8字节。若使用AES加密方法，以下代码都相同，修改DES为AES可矣，而AES要求秘钥必须为16字节。
    private static String KEY = "1qaz@WSX";

    /**
     * 设置秘钥。
     * @param key 秘钥
     */
    public static void setKEY(String key){
        KEY = key;
    }

    /**
     * 对称加密_DES
     * 其秘钥必须是8个字节
     * @param originalText 原文
     * @return 密文
     */
    public static String encrypt_DES(String originalText) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        // DES加密的秘钥只能是8位
        String key = KEY;

        // 1.创建加密对象
        // "DES"则默认为"DES/ECB/PKCS5Padding", 表示"加密算法/加密模式/填充模式"
        Cipher cipher = Cipher.getInstance("DES");

        // ②加密规则创建
        // @params: 会在这里传入秘钥KEY
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "DES");

        // 2.加密初始化
        // @params: ①加密or解密模式; ②加密的规则;
        // 当加密模式为CBC而非ECB时，有第三参数 ③iv;
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        // 3.加密
        // @return: byte[]类型_密文
        byte[] bEncryptedText = cipher.doFinal(originalText.getBytes());

        // 将byte[]类型以base64的形式转化为String
        return Base64.encode(bEncryptedText);
    }

    /**
     * 解密_EDS
     * @param encryptedText 密文
     * @return 明文
     */
    public static String decrypt_DES(String encryptedText) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        // DES加密的秘钥只能是8位
        String key = KEY;

        // 1.创建cipher对象
        Cipher cipher = Cipher.getInstance("DES");

        // ②加密规则创建
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "DES");

        // 2.初始化
        // params: ①加密or解密模式; ②加/解密的规则
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

        // 3.解密
        // @return: 同样，返回的是byte[]类型_明文
        byte[] decryptedText = cipher.doFinal(Base64.decode(encryptedText));

        // 将byte[]类型的明文转化为String
        return new String(decryptedText);
    }

}
