import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static String s, pattern;

  /*
  n = 1,000,000
  전체 문자열 s에 대해 contains, replace 메서드 사용시 터짐
 
   */
  public static void main(String[] args) throws IOException {
    s = br.readLine();
    pattern = br.readLine();
    int patternLen = pattern.length();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      sb.append(s.charAt(i));

      if (sb.length() >= patternLen) {
        String sub = sb.substring(sb.length() - patternLen, sb.length());

        if (sub.equals(pattern)) {
          sb.delete(sb.length() - patternLen, sb.length());
        }
      }
    }

    System.out.println(sb.length() > 0 ? sb : "FRULA");
  }

}
