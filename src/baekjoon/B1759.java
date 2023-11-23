package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;

public class B1759 {

  static int l,c;
  static String[] arr;
  static Set<String> set = Set.of("a", "e", "i", "o", "u");
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] lc = br.readLine().split(" ");
    l = Integer.parseInt(lc[0]);
    c= Integer.parseInt(lc[1]);

    arr = br.readLine().split(" ");

    Arrays.sort(arr);

    dfs(0, new String[l], 0);

    System.out.println(sb);
  }

  static void dfs(int depth, String[] password, int index) {
    if (depth == l) {
      if (isValid(password)) {
        String joinPassword = String.join("", password);
        sb.append(joinPassword).append("\n");
      }
      return;
    }

    for (int i = index; i < c; i++) {
      password[depth] = arr[i];
      dfs(depth + 1, password, i + 1);
    }
  }

  static boolean isValid(String[] password) {
    int vCount = 0;
    int cCount = 0;

    for (int i = 0; i < l; i++) {
      if (set.contains(password[i])) {
        vCount ++;
      } else {
        cCount ++;
      }
    }

    if (vCount >= 1 && cCount >= 2) {
      return true;
    }

    return false;
  }

}
