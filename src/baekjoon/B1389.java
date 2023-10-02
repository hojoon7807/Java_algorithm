package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class B1389 {

  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static int n, m;
  static int min = Integer.MAX_VALUE;
  static int[][] distance;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] nm = br.readLine().split(" ");
    n = Integer.parseInt(nm[0]);
    m = Integer.parseInt(nm[1]);

    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      String[] input = br.readLine().split(" ");
      int a = Integer.parseInt(input[0]) - 1;
      int b = Integer.parseInt(input[1]) - 1;

      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    int answer = -1;
    for (int i = 0; i < n; i++) {
      boolean[] isVisited = new boolean[n];
      isVisited[i] = true;
      int result = kevin(i);

      if (min > result) {
        min = result;
        answer = i;
      }
    }

    System.out.println(answer + 1);
  }

  static int kevin(int start) {
    LinkedList<Integer> q = new LinkedList<>();
    boolean[] isVisited = new boolean[n];
    q.add(start);
    isVisited[start] = true;
    distance = new int[n][n];
    while (!q.isEmpty()) {
      int recent = q.poll();
      for (Integer next : graph.get(recent)) {
        if (!isVisited[next]) {
          isVisited[next] = true;
          distance[start][next] = distance[start][recent] + 1;
          q.add(next);
        }
      }
    }

    int count = 0;
    for (int i = 0; i < n; i++) {
      count += distance[start][i];
    }

    return count;
  }

}
