package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Compression {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String string = br.readLine();
    solution(string);
  }

  public static void solution(String s) {
    s += " ";
    String answer = "";
    int count = 1;

    for (int i = 0; i < s.length() - 1; i++) {
      if(s.charAt(i) == s.charAt(i+1)) count ++;
      else{
        answer += s.charAt(i);
        if(count > 1) answer += count;
        count = 1;
      }
    }

    System.out.println(answer);
  }

}
