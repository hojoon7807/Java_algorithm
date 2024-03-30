import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static String name;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[] alpha = new int[26];
  static String fail = "I'm Sorry Hansoo";

  public static void main(String[] args) throws IOException {
    name = br.readLine();
    String mid = null;

    int len = name.length();

    StringBuilder front = new StringBuilder();

    for (int i = 0; i < len; i++) {
      char c = name.charAt(i);
      alpha[c - 'A']++;
    }

    for (int i = 0; i < 26; i++) {
      int count = alpha[i];

      if ((len & 1) == 1) {
        if ((count & 1) == 1) {
          if (mid != null) {
            System.out.println(fail);
            return;
          } else {
            mid = Character.toString(i + 'A');
            count--;
          }
        }
      }

      if ((count & 1) == 1) {
        System.out.println(fail);
        return;
      }

      int repeat = count >> 1;
      front.append(Character.toString(i + 'A').repeat(repeat));
    }

    StringBuilder answer = new StringBuilder();

    answer.append(front);

    if ((len & 1) == 1) {
      front.append(mid);
    }

    answer.append(front.reverse());

    System.out.println(answer);
  }

}
