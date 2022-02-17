package b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Check {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        System.out.println(checkStringBitVector(st));

    }
    public static boolean checkString(String string){
        if (string.length()>128) return false;
        boolean[] check = new boolean[128];
        for (int i = 0; i < string.length(); i++) {
            int val = string.charAt(i);
            if (check[val]) {
                return false;
            }
            check[val] = true;
        }
        return true;
    }

    public static boolean checkStringBitVector(String string) {
        int checker = 0;
        for (int i = 0; i < string.length(); i++) {
            int val = string.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= 1 << val;
        }
        return true;
    }
}
