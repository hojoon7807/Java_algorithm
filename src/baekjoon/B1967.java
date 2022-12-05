package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B1967 {
  static int max = 0;
  static int maxIdx = 0;
  static boolean[] isVisited;
  private static class Node{
    int to;
    int weight;

    public Node(int to, int weight) {
      this.to = to;
      this.weight = weight;
    }
  }

  static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i <= n; i++) {
      tree.add(new ArrayList<>());
    }

    for (int i = 0; i < n-1; i++) {
      String[] input = br.readLine().split(" ");
      int parent = Integer.parseInt(input[0]);
      int child = Integer.parseInt(input[1]);
      int weight = Integer.parseInt(input[2]);

      tree.get(parent).add(new Node(child, weight));
      tree.get(child).add(new Node(parent, weight));
    }

    isVisited = new boolean[n + 1];
    isVisited[1] = true;
    solve(1,0);

    isVisited = new boolean[n + 1];
    isVisited[maxIdx] = true;
    solve(maxIdx,0);

    System.out.println(max);
  }

  static void solve(int idx, int sum) {
    if (max < sum) {
      max = sum;
      maxIdx = idx;
    }

    for (Node node : tree.get(idx)) {
      if (!isVisited[node.to]) {
        isVisited[node.to] = true;
        solve(node.to, sum + node.weight);
      }
    }
  }
}
