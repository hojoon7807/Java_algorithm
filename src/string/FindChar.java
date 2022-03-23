package string;

import java.util.Scanner;

public class FindChar {
    static void countChar(String str, char c){
        int count = 0;
        String upperString = str.toUpperCase();
        char upperChar = Character.toUpperCase(c);

        for (char c1 : upperString.toCharArray()) {
            if(c1 == upperChar) count ++;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        countChar(str, c);
    }
}
