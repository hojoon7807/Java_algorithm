package string;

import java.util.Scanner;

public class RemoveDuplicatedChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        remove(str);
    }

    private static void remove(String str) {
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (str.indexOf(c) == i) answer += c;
        }
        System.out.println(answer);
    }
}
