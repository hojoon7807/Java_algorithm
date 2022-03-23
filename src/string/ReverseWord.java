package string;

import java.util.Scanner;

public class ReverseWord {
    static void reverse(String[] strings){
        for (String string : strings) {
            char[] chars = string.toCharArray();
            int lt=0, rt=string.length()-1;
            while(lt<rt){
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;
                lt ++;
                rt--;
            }
            System.out.println(String.valueOf(chars));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        String[] strings = new String[i];
        for (int j = 0; j < i; j++) {
            strings[j] = sc.next();
        }
        reverse(strings);
    }
/*
    static void reverse(List<StringBuilder> strs){
        for (StringBuilder str : strs) {
            StringBuilder reverse = str.reverse();
            System.out.println(reverse);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        List<StringBuilder> strs = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            StringBuilder str = new StringBuilder(sc.next());
            strs.add(str);
        }
        reverse(strs);
    }

 */
}
