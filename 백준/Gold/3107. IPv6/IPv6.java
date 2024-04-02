import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static String s;
  static String[] answer = new String[8];
  public static void main(String[] args) throws IOException {
    s = br.readLine();
    String[] ip6 = s.split(":");

    int realCount = 0;

    for (String part : ip6) {
      if(!part.equals("")){
        realCount ++;
      }
    }

    StringBuilder sb = new StringBuilder();

    boolean flag = false;

    for (String part : ip6) {
      if (part.equals("") && !flag) {
        for (int i = 0; i < 8-realCount; i++) {
          sb.append("0000:");
        }

        flag = true;
      }

      if (!part.equals("")) {
        int len = part.length();

        for (int i = 0; i < 4-len; i++) {
          sb.append(0);
        }

        sb.append(part).append(":");
      }
    }

    if (realCount > 0 && !flag) {
      for (int i = 0; i < 8-realCount; i++) {
        sb.append("0000:");
      }
    }

    System.out.println(sb.substring(0,39));
  }

}
