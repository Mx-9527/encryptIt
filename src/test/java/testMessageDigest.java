import java.security.NoSuchAlgorithmException;

import static com.messageDigest.*;

/**
 * 这是一段测试代码，测试MessageDigest加解密功能。
 *
 * @author xxquan
 * @since 2023-11-04
 */
public class testMessageDigest {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // 原文
        String message = "这是一段需要摘要的信息原文。";

        // 测试MD5/SHA1/SHA256/SHA512值获取
        System.out.println("  MD5 摘要：" + getMD5(message));
        System.out.println(" SHA1 摘要：" + getSHA1(message));
        System.out.println("SHA256摘要：" + getSHA256(message));
        System.out.println("SHA512摘要：" + getSHA512(message));
    }
}
