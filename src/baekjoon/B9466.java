package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9466 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] arr;
  static boolean[] isVisited;
  static boolean[] isFinished;

  public static void main(String[] args) throws IOException {
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      input();
      solution();
    }

    System.out.println(sb);
  }

  static void input() throws IOException {
    n = Integer.parseInt(br.readLine());
    arr = new int[n];
    String[] input = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(input[i]) - 1;
    }
  }

  static void solution() {
    isVisited = new boolean[n];
    isFinished = new boolean[n];
    int unable = n;

    for (int i = 0; i < n; i++) {
      if (!isVisited[i]) {
        unable -= dfs(i);
      }
    }

    sb.append(unable).append("\n");
  }

  static int dfs(int cur) {
    int next = arr[cur];
    int teamCount = 0;

    if (!isVisited[next]) {
      isVisited[next] = true;
      teamCount += dfs(next);
    } else {
      // 사이클 체크
      if (!isFinished[next]) {
        while (next != cur) {
          // cur = 4 3 5
          next = arr[next];
          teamCount ++;
        }
        teamCount++;
      }
    }

    isFinished[cur] = true;
    return teamCount;
  }
}
