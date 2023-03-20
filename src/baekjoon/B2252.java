package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B2252 {

  static int N, M;
  static int[] inDegree;
  static boolean[] isVisited;
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    isVisited = new boolean[N];

    for (int i = 0; i < N; i++) {
      graph.add(new ArrayList<>());
    }

    inDegree = new int[N];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      graph.get(a).add(b);
      inDegree[b]++;
    }
    LinkedList<Integer> queue = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      if (inDegree[i] == 0) {
        queue.add(i);
      }
    }

    StringBuilder sb = new StringBuilder();

    while (!queue.isEmpty()) {
      Integer current = queue.poll();
      sb.append(current + 1).append(" ");

      for (Integer next : graph.get(current)) {
        if (--inDegree[next] == 0) {
          queue.add(next);
        }
      }
    }

    System.out.println(sb);
  }

}
