package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717 {

  static int N, M;
  static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    parent = new int[N + 1];

    for (int i = 0; i <= N; i++) {
      parent[i] = i;
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if (t == 0) {
        union(a, b);
      } else {
        sb.append(checkSame(a, b) + "\n");
      }
    }

    System.out.println(sb);
  }

  private static int find(int x) {
    if (x == parent[x]) {
      return x;
    }
    return parent[x] = find(parent[x]);
  }

  private static void union(int a, int b) {
    a = find(a);
    b = find(b);

    if (a != b) {
      parent[b] = a;
    }
  }

  private static String checkSame(int a, int b) {
    a = find(a);
    b = find(b);

    if (a == b) {
      return "YES";
    } else {
      return "NO";
    }
  }
}
