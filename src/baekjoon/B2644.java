package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class B2644 {

  static int n, m;
  static int from, to;

  static int[] distance;
  static ArrayList<ArrayList<Integer>> relation = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    distance = new int[n];

    Arrays.fill(distance, -1);

    String[] fromTo = br.readLine().split(" ");
    from = Integer.parseInt(fromTo[0]) - 1;
    to = Integer.parseInt(fromTo[1]) - 1;

    m = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      relation.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      String[] xy = br.readLine().split(" ");
      int x = Integer.parseInt(xy[0]) - 1;
      int y = Integer.parseInt(xy[1]) - 1;

      relation.get(x).add(y);
      relation.get(y).add(x);
    }
    bfs(from);

    System.out.println(distance[to]);
  }

  static void bfs(int start) {
    distance[start] = 0;
    LinkedList<Integer> q = new LinkedList<>();
    q.add(start);

    while (!q.isEmpty()) {
      Integer recent = q.poll();

      for (Integer next : relation.get(recent)) {
        if (distance[next] == -1) {
          q.add(next);
          distance[next] = distance[recent] + 1;
        }
      }
    }
  }

}
