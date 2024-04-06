import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static String s;

  public static void main(String[] args) throws IOException {
    s = br.readLine();

    // PPAP -> PPAPPAP
    StringBuilder sb = new StringBuilder();

    int len = s.length();
    for (int i = 0; i < len; i++) {
      sb.append(s.charAt(i));

      if (sb.length() >= 4 && sb.charAt(sb.length() - 1) == 'P') {
        String sub = sb.substring(sb.length() - 4, sb.length());
        if (sub.equals("PPAP")) {
          sb.replace(sb.length() - 4, sb.length(), "P");
          
        }
      }
    }

    // StringBuilder isEmpty() 메소드 java 15 이후 버전에서 가능
    if (sb.toString().equals("P")) {
      System.out.println("PPAP");
    } else {
      System.out.println("NP");
    }
  }

}
