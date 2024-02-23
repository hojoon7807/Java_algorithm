package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B1647 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static int[] parent;
  static ArrayList<int[]> list = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      list.add(new int[]{a, b, c});
    }
  }

  static void solution() {
    parent = new int[n + 1];

    for (int i = 0; i <= n; i++) {
      parent[i] = i;
    }

    list.sort(Comparator.comparingInt(o -> o[2]));

    int answer = 0;
    int connect = 0;

    for (int i = 0; i < list.size(); i++) {
      if (connect == n - 2) {
        break;
      }

      int[] info = list.get(i);
      int a = info[0];
      int b = info[1];
      int c = info[2];

      if (union(a, b)) {
        connect++;
        answer += c;
      }
    }

    System.out.println(answer);
  }

  static boolean union(int a, int b) {
    a = find(a);
    b = find(b);

    if (a != b) {
      parent[b] = a;
      return true;
    }

    return false;
  }

  static int find(int x) {
    if (x == parent[x]) {
      return x;
    }

    return parent[x] = find(parent[x]);
  }


}
