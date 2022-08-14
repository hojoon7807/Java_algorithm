package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Password {
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    String m = br.readLine();

    String answer = "";
    for (int i = 0; i < n; i++) {
      String tmp = m.substring(0,7).replace("#","1").replace("*","0");
      int num = Integer.parseInt(tmp, 2);
      answer += (char) num;
      m = m.substring(7);
    }
    System.out.println(answer);
  }

}
