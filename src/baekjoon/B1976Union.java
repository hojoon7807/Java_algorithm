package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1976Union {

  private static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    parent = new int[N];

    for (int i = 0; i < N; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        if (Integer.parseInt(st.nextToken()) == 1) {
          union(i, j);
        }
      }
    }

    st = new StringTokenizer(br.readLine());
    int start = find(Integer.parseInt(st.nextToken()) - 1);
    for (int i = 1; i < M; i++) {
      int next = find(Integer.parseInt(st.nextToken()) - 1);
      if (next != start) {
        System.out.println("NO");
        return;
      }
    }

    System.out.println("YES");
  }

  private static int find(int x) {
    if (x == parent[x]) {
      return x;
    }

    return parent[x] = find(parent[x]);
  }

  private static void union(int x, int y) {
    x = find(x);
    y = find(y);

    if (x != y) {
      parent[x] = y;
    }
  }

}
