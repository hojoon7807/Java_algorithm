package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class B1976 {
  static int N;
  static List<List<Integer>> graph = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < N; i++) {
      String[] input = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        int link = Integer.parseInt(input[j]);
        if (link == 1) {
          graph.get(i).add(j);
        }
      }
    }

    String[] plan = br.readLine().split(" ");

    for (int i = 0; i < M - 1; i++) {
      if (!check(Integer.parseInt(plan[i])-1, Integer.parseInt(plan[i + 1])-1)) {
        System.out.println("NO");
        return;
      }
    }

    System.out.println("YES");
  }

  static boolean check(int start, int end){
    if (start == end) {
      return true;
    }

    boolean[] isVisited = new boolean[N];
    LinkedList<Integer> q = new LinkedList<>();
    q.add(start);
    isVisited[start] = true;

    while (!q.isEmpty()) {
      Integer current = q.poll();

      for (Integer next : graph.get(current)) {
        if (next == end) {
          return true;
        } else {
          if (!isVisited[next]) {
            q.add(next);
            isVisited[next] = true;
          }
        }
      }
    }
    return false;
  }
}
