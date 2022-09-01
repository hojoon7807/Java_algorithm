package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1182 {

  static int N;
  static int S;
  static int[] arr;
  static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] ns = br.readLine().split(" ");
    String[] seq = br.readLine().split(" ");

    N = Integer.parseInt(ns[0]);
    S = Integer.parseInt(ns[1]);

    arr = new int[seq.length];

    for (int i = 0; i < seq.length; i++) {
      arr[i] = Integer.parseInt(seq[i]);
    }

    dfs(0, 0);

    if (S == 0) {
      System.out.println(count - 1);
    } else {
      System.out.println(count);
    }
  }

  static void dfs(int depth, int sum) {
    if (depth == N) {
      if (sum == S) {
        count ++;
      }
      return;
    }

    dfs(depth + 1, sum + arr[depth]);
    dfs(depth + 1, sum);
  }



}
