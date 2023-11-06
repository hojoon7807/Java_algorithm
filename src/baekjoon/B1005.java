package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class B1005 {

  static ArrayList<ArrayList<Integer>> graph;
  static int[] time;
  static int[] inDegree;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      String[] nk = br.readLine().split(" ");
      int n = Integer.parseInt(nk[0]);
      int k = Integer.parseInt(nk[1]);

      int[] info = new int[n];
      inDegree = new int[n];
      graph = new ArrayList<>();
      time = new int[n];

      String[] input = br.readLine().split(" ");

      for (int j = 0; j < n; j++) {
        info[j] = Integer.parseInt(input[j]);
      }

      for (int j = 0; j < n; j++) {
        graph.add(new ArrayList<>());
      }

      for (int j = 0; j < k; j++) {
        input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]) - 1;
        int y = Integer.parseInt(input[1]) - 1;

        graph.get(x).add(y);

        inDegree[y]++;
      }

      LinkedList<Integer> q = new LinkedList<>();
      for (int j = 0; j < n; j++) {
        if (inDegree[j] == 0) {
          time[j] = info[j];
          q.add(j);
        }
      }

      while (!q.isEmpty()) {
        int recent = q.poll();

        for (Integer next : graph.get(recent)) {
          time[next] = Math.max(time[next], time[recent] + info[next]);
          if (--inDegree[next] == 0) {
            q.add(next);
          }
        }
      }

      int w = Integer.parseInt(br.readLine()) - 1;

      sb.append(time[w]).append("\n");
    }

    System.out.println(sb);
  }

}
