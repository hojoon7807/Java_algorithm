package string;


import java.util.Scanner;

public class longestWord {
    static void longestWord(String str) {
        String[] arr = str.split(" ");
        String answer = "";
        int m = 0, pos;
        while((pos=str.indexOf(" "))!=-1){
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if(len>m){
                m = len;
                answer = tmp;
            }
            str = str.substring(pos+1);
        }
        if (str.length() > m) {
            answer = str;
        }
        System.out.println(answer);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        longestWord(str);
    }
}
