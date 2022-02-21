package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        List<Character> result = new ArrayList<>();
        int value = 0;

        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (temp >= 65 && temp <= 90) {
                result.add(temp);
            }else {
                value += temp - '0';
            }
        }
        // Character 클래스 사용
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (Character.isLetter(temp)) {
                result.add(temp);
            }else {
                value += temp - '0';
            }
        }
        Collections.sort(result);
        for (Character c : result) {
            System.out.print(c);
        }
        if (value!=0) System.out.println(value);
    }
}
