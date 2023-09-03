package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B13023 {

  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static int answer = 0;
  static boolean[] isVisited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);

    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    isVisited = new boolean[n];
    for (int i = 0; i < m; i++) {
      input = br.readLine().split(" ");

      int a = Integer.parseInt(input[0]);
      int b = Integer.parseInt(input[1]);
      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    for (int i = 0; i < n; i++) {
      isVisited[i] = true;
      dfs(1, i);
      isVisited[i] = false;

      if (answer == 1) {
        System.out.println(answer);
        return;
      }
    }

    System.out.println(answer);
  }

  static void dfs(int depth, int start) {
    if (depth == 5) {
      answer = 1;
      return;
    }

    for(int next : graph.get(start)) {
      if(!isVisited[next]){
        isVisited[next] = true;
        dfs(depth + 1, next);
        isVisited[next] = false;
      }
    };
  }

}
