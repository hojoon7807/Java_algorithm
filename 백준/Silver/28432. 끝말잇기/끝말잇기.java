
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

  static int n, m;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static Set<String> set = new HashSet<>();
  static String[] arr;

  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());

    arr = new String[n];

    int qIdx = -1;

    for (int i = 0; i < n; i++) {
      String input = br.readLine();
      arr[i] = input;
      set.add(input);

      if (input.equals("?")) {
        qIdx = i;
      }
    }

    m = Integer.parseInt(br.readLine());

    for (int i = 0; i < m; i++) {
      String input = br.readLine();
      
      if (n == 1) {
        System.out.println(input);
        return;
      }
      
      if (qIdx == 0) {
        if (getFirstChar(arr[1]) == getLastChar(input) && !set.contains(input)) {
          System.out.println(input);
          return;
        }
        continue;
      }

      if (qIdx == n - 1) {
        if (getFirstChar(input) == getLastChar(arr[qIdx - 1]) && !set.contains(input)) {
          System.out.println(input);
          return;
        }
        continue;
      }

      if (getLastChar(arr[qIdx - 1]) == getFirstChar(input) &&
          getLastChar(input) == getFirstChar(arr[qIdx + 1]) &&
          !set.contains(input)) {
        System.out.println(input);
        return;
      }
    }
  }

  static char getLastChar(String s) {
    return s.charAt(s.length() - 1);
  }

  static char getFirstChar(String s) {
    return s.charAt(0);
  }
}
