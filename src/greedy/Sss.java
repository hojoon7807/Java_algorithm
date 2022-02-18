package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Sss {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st=br.readLine();
        System.out.println(isDuplicated(st));
    }

    public static boolean isDuplicated(String string) {
        char[] chars = new char[string.length()];
        string.getChars(0, string.length(), chars, 0);

        for (int i = 0; i < chars.length; i++) {
            char value = chars[i];
            for (int j = 0; j < chars.length; j++) {
                if (i == j) {
                    continue;
                }else if(value==chars[j]){
                    return false;
                }
            }
        }
        return true;
    }
}
