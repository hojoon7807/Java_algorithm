package string;

import java.util.Scanner;

public class OnlyNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }

    private static int solution(String str) {
//        int answer = 0;
//        for (char c : str.toCharArray()) {
//            if(c>=48 && c<=57) answer = answer * 10 + (c - 48);
//        }
//        return answer;
        String answer = "";
        for (char c : str.toCharArray()) {
            if(Character.isDigit(c)) answer += c;
        }
        return Integer.parseInt(answer);
    }
}
