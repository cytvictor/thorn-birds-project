package org.thorn.test;

import org.junit.Test;
import org.thorn.core.util.AESUtils;

/**
 * @Author: yfchenyun
 * @Since: 13-9-10 上午11:05
 * @Version: 1.0
 */
public class AESUtilsTest {

    String xml = "<Note>\n" +
            "    <Account>\n" +
            "        <id>2332323232323232</id>\n" +
            "        <username>chenyun123@google</username>\n" +
            "        <password>3434dfdfdfdf</password>\n" +
            "        <tag>Mail#</tag>\n" +
            "        <address>google</address>\n" +
            "        <remark>dsd酸dsd酸的</remark>\n" +
            "    </Account>\n" +
            "    <Account>\n" +
            "        <id>wewe3434343</id>\n" +
            "        <username>慰问慰问费功夫功夫</username>\n" +
            "        <password>3434dfdfdfdf</password>\n" +
            "        <tag>Mail#</tag>\n" +
            "        <address>google1212</address>\n" +
            "        <remark>dsd酸dsd酸的</remark>\n" +
            "    </Account>\n" +
            "    <Account>\n" +
            "        <id>898985rfdfdf</id>\n" +
            "        <username>慰问慰问费功夫功夫</username>\n" +
            "        <password>3434dfdfdfdf</password>\n" +
            "        <tag>Mail#</tag>\n" +
            "        <address>google</address>\n" +
            "        <remark>dsd酸dsd酸的</remark>\n" +
            "    </Account>\n" +
            "    <Account>\n" +
            "        <id>232vvbnjhhj</id>\n" +
            "        <username>慰问慰问费功夫功夫</username>\n" +
            "        <password>3434dfdfdfdf</password>\n" +
            "        <tag>Mail#</tag>\n" +
            "        <address>google.klo</address>\n" +
            "        <remark>dsd酸dsd酸的</remark>\n" +
            "    </Account>\n" +
            "    <Account>\n" +
            "        <id>klp097yhgggg</id>\n" +
            "        <username>chenyun123@google.com</username>\n" +
            "        <password>3434dfdfdfdf</password>\n" +
            "        <tag>Mail#</tag>\n" +
            "        <address>google</address>\n" +
            "        <remark>dsd酸dsd酸的</remark>\n" +
            "    </Account>\n" +
            "    <Account>\n" +
            "        <id>klp097yhgggg</id>\n" +
            "        <username>chenyun123@google.com</username>\n" +
            "        <password>3434dfdfdfdf</password>\n" +
            "        <tag>Mail#</tag>\n" +
            "        <address>google</address>\n" +
            "        <remark>dsd酸dsd酸的</remark>\n" +
            "    </Account>\n" +
            "    <Account>\n" +
            "        <id>klp097yhgggg</id>\n" +
            "        <username>chenyun123@google.com</username>\n" +
            "        <password>3434dfdfdfdf</password>\n" +
            "        <tag>Mail#</tag>\n" +
            "        <address>google</address>\n" +
            "        <remark>dsd酸dsd酸的</remark>\n" +
            "    </Account>\n" +
            "    <Account>\n" +
            "        <id>klp097yhgggg</id>\n" +
            "        <username>chenyun123@google.com</username>\n" +
            "        <password>3434dfdfdfdf</password>\n" +
            "        <tag>Mail#</tag>\n" +
            "        <address>google</address>\n" +
            "        <remark>dsd酸dsd酸的</remark>\n" +
            "    </Account>\n" +
            "    <Account>\n" +
            "        <id>klp097yhgggg</id>\n" +
            "        <username>chenyun123@google.com</username>\n" +
            "        <password>3434dfdfdfdf</password>\n" +
            "        <tag>Mail#</tag>\n" +
            "        <address>google</address>\n" +
            "        <remark>dsd酸dsd酸的</remark>\n" +
            "    </Account>\n" +
            "    <Account>\n" +
            "        <id>klp097yhgggg</id>\n" +
            "        <username>chenyun221212123@google.com</username>\n" +
            "        <password>3434dfdfdfdf</password>\n" +
            "        <tag>Mail#Shopping#</tag>\n" +
            "        <address>google</address>\n" +
            "        <remark>dsd酸dsd酸的</remark>\n" +
            "    </Account>\n" +
            "    <Account>\n" +
            "        <id>klp097yhgggg111</id>\n" +
            "        <username>古魂残风</username>\n" +
            "        <password>3434dfdfdfdf</password>\n" +
            "        <tag>Mail#</tag>\n" +
            "        <address>google</address>\n" +
            "        <remark>dsd酸dsd酸的</remark>\n" +
            "    </Account>\n" +
            "</Note>";


    @Test
    public void testEncrypt() throws Exception {
        System.out.println(AESUtils.encrypt(xml, "chenyun313"));
    }

    @Test
    public void testDecrypt() throws Exception {
        String str = "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";
        System.out.println(AESUtils.decrypt(str, "chenyun313"));
    }
}
