package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3584 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int t, n;
  static int[] parents;
  static boolean[] isVisited;
  static int answer = 0;

  public static void main(String[] args) throws IOException {
    solution();
  }

  private static void solution() throws IOException {
    StringBuilder sb = new StringBuilder();
    t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      n = Integer.parseInt(br.readLine());
      isVisited = new boolean[n + 1];
      parents = new int[n + 1];

      for (int i = 0; i < n - 1; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        parents[b] = a;
      }

      StringTokenizer st = new StringTokenizer(br.readLine());
      int node = Integer.parseInt(st.nextToken());
      int node2 = Integer.parseInt(st.nextToken());

      while (node > 0) {
        isVisited[node] = true;
        node = parents[node];
      }

      while (node2 > 0 && !isVisited[node2]) {
        node2 = parents[node2];
      }

      sb.append(node2).append("\n");
    }

    System.out.println(sb);
  }
}
