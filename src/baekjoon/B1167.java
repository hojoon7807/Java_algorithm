package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B1167 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int v;
  static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
  static boolean[] isVisited;
  static int max = 0;
  static int index = -1;

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void input() throws IOException {
    v = Integer.parseInt(br.readLine());

    for (int i = 0; i <= v; i++) {
      tree.add(new ArrayList<>());
    }

    for (int i = 0; i < v; i++) {
      String[] split = br.readLine().split(" ");
      int start = Integer.parseInt(split[0]);
      for (int j = 1; j < split.length-1; j+=2) {
        int to = Integer.parseInt(split[j]);
        int w = Integer.parseInt(split[j + 1]);

        tree.get(start).add(new Node(to, w));
      }
    }
  }

  static void solution(){
    isVisited = new boolean[v + 1];

    dfs(0, 1);

    isVisited = new boolean[v + 1];

    dfs(0, index);

    System.out.println(max);
  }

  static void dfs(int sum, int v) {
    if (sum > max) {
      max = sum;
      index = v;
    }

    isVisited[v] = true;

    for (Node next : tree.get(v)) {
      if (!isVisited[next.to]) {
        dfs(sum + next.w, next.to);
      }
    }
  }

  static class Node{
    int to;
    int w;

    public Node(int to, int w) {
      this.to = to;
      this.w = w;
    }
  }



}
