package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShortestString {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] strings = br.readLine().split(" ");

    String s = strings[0];
    char t = strings[1].charAt(0);

    solution(s,t);
  }

  static void solution(String s,char t){
    int[] answer = new int[s.length()];
    int p = 1000;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == t) {
        p = 0;
        answer[i] = p;
      }else{
        p++;
        answer[i] = p;
      }
    }

    p = 1000;

    for (int i = s.length() - 1; i >= 0; i--) {
      if(s.charAt(i) == t) p = 0;
      else{
        p++;
        answer[i] = Math.min(answer[i], p);
      }
    }

    for (int i : answer) {
      System.out.print(i + " ");
    }
  }
}
