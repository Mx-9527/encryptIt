import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static com.encryptUtils.*;

/**
 * 这是一段测试代码，测试EncryptUtils加解密功能。
 * @author xxquan
 * @since 2023-11-04
 */
public class testEncryptUtils {

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        // 原文
        String message = "这是一段需要加密的明文原文。";
        // 设置秘钥
        setKEY("3edc$RFV");
        // DES加密
        String encryptedMessage = encrypt_DES(message);
        // 密文
        System.out.println("密文是：" + encryptedMessage);
        // DES解密
        String decryptedMessage = decrypt_DES(encryptedMessage);
        // 解密的明文
        System.out.println("明文是：" + decryptedMessage);
    }
}
