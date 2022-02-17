package greedy;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Sss {
    public static void main(String[] args) throws UnsupportedEncodingException {
        char ch = '가';
        String st = "가가가";
        byte[] bytes = st.getBytes(StandardCharsets.UTF_16);
        for (byte b : bytes) {
            System.out.println(Integer.toHexString((int)b));
        }
        System.out.println(Integer.toHexString((int)ch));
    }
}
