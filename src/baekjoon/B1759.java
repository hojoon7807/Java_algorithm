package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;

public class B1759 {

  static int l,c;
  static String[] arr;

  static StringBuilder sb = new StringBuilder();

  static Set<Character> aeiou = Set.of('a','e','i','o','u');

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] lc = br.readLine().split(" ");
    l = Integer.parseInt(lc[0]);
    c = Integer.parseInt(lc[1]);

    arr = br.readLine().split(" ");
    Arrays.sort(arr);

    bf(0, "", 0);

    System.out.println(sb);

  }

  public static void bf(int depth, String code, int index) {
    if (depth == l) {
      if (isValid(code)) {
        sb.append(code).append("\n");
      }
      return;
    }

    for (int i = index; i < c; i++) {
      bf(depth + 1, code + arr[i], i + 1);
    }
  }

  public static boolean isValid(String code) {
    int count = 0;
    for (int i = 0; i < l; i++) {
      if (aeiou.contains(code.charAt(i))) {
        count ++;
      }
    }

    if (count >= 1 && count <= l - 2) {
      return true;
    }
    return false;
  }

}
