package string;

import java.util.Scanner;

public class ReverseAlphabet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        reverse(str);
    }

    private static void reverse(String str) {
        char[] array = str.toCharArray();
        int lt = 0, rt = str.length() - 1;
        while(lt<rt){
            if (!Character.isAlphabetic(array[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(array[rt])) {
                rt--;
            }else {
                char tmp = array[lt];
                array[lt] = array[rt];
                array[rt] = tmp;
                lt++;
                rt--;
            }
        }
        System.out.println(String.valueOf(array));
    }
}
