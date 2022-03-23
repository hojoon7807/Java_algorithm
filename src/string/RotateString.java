package string;

import java.util.Scanner;

public class RotateString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        checkString(string);
    }

//    private static void checkString(String string) {
//        string = string.toUpperCase();
//        int lt = 0, rt = string.length() - 1;
//        String result = "NO";
//        while (lt < rt) {
//            char frontChar = string.charAt(lt);
//            char backChar = string.charAt(rt);
//            if (frontChar != backChar) {
//                result = "NO";
//                break;
//            }
//            else{
//                lt++;
//                rt--;
//                result = "YES";
//            }
//        }
//        System.out.println(result);
//    }

    private static void checkString(String string) {
        String newString = new StringBuilder(string).reverse().toString();
        if (string.equalsIgnoreCase(newString)) System.out.println("YES");
        else System.out.println("NO");
    }
}
