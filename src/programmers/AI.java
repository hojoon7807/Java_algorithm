package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AI {

  static int t, n;
  static ArrayList<int[]> list = new ArrayList<>();

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int answer = Integer.MAX_VALUE;
  static StringBuilder sb = new StringBuilder();
  static int[][][] dp;

  public static void main(String[] args) throws IOException {

    t = Integer.parseInt(br.readLine());
    solution();
  }

  static void solution() throws IOException {
    for (int i = 0; i < t; i++) {
      n = Integer.parseInt(br.readLine());

      for (int j = 0; j < n; j++) {
        String[] input = br.readLine().split(" ");
        int first = Integer.parseInt(input[0]);
        int second = Integer.parseInt(input[1]);
        int third = Integer.parseInt(input[2]);
        int sum = first + second + third;
        int[] arr = new int[]{first, second, third, sum};
        list.add(arr);
      }

      dfs(0, new int[3], 0);

      if (answer == Integer.MAX_VALUE) {
        sb.append(-1).append("\n");
      } else {
        sb.append(answer).append("\n");
      }

      answer = Integer.MAX_VALUE;
      list.clear();
    }

    System.out.println(sb);
  }

  static void dfs(int depth, int[] count, int sum) {
    if (depth == n) {
      if (canRun(count)) {
        answer = Math.min(answer, sum);
      }
      return;
    }

    for (int i = depth; i < n; i++) {
      for (int j = 0; j < 3; j++) {
        count[j]++;
        int remain = list.get(i)[3] - list.get(i)[j];
        dfs(depth + 1, count, sum + remain);
        count[j]--;
      }
    }
  }

  static boolean canRun(int[] count) {
    for (int i = 0; i < 3; i++) {
      if (count[i] == 0) {
        return false;
      }
    }
    return true;
  }

}
