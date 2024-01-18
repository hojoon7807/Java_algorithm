package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B12910 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static String s, t;
  static int answer = 0;

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void input() throws IOException {
    s = br.readLine();
    t = br.readLine();
  }

  static void solution() {
    dfs(t);
    System.out.println(answer);
  }

  static void dfs(String word) {
    if (word.length() == s.length()) {
      if (word.equals(s)) {
        answer = 1;
      }
      return;
    }

    StringBuilder sb = new StringBuilder(word);
    if (word.endsWith("A")) {
      dfs(sb.substring(0, sb.length() - 1));
    }

    if (word.startsWith("B")) {
      dfs(sb.reverse().substring(0, sb.length() - 1));
    }
  }
}
