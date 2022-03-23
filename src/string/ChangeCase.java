package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ChangeCase {
    public static void changeCase(String str){
        StringBuilder newStr = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c>=97&&c<=122) newStr.append((char)(c-32));
            else newStr.append((char)(c+32));
        }
        System.out.println(newStr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        changeCase(str);
    }
}
