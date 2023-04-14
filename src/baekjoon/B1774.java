package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class B1774 {

  private static int[] parent;
  private static int[][] coordinates;
  private static ArrayList<Node> nodes = new ArrayList<Node>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);

    parent = new int[N];

    for (int i = 0; i < N; i++) {
      parent[i] = i;
    }

    coordinates = new int[N][2];

    for (int i = 0; i < N; i++) {
      input = br.readLine().split(" ");
      coordinates[i] = new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])};
    }
    double answer = 0;

    for (int i = 0; i < M; i++) {
      input = br.readLine().split(" ");
      int a = Integer.parseInt(input[0]) - 1;
      int b = Integer.parseInt(input[1]) - 1;

      union(a, b);
    }

    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        nodes.add(new Node(i, j, calDistance(i, j)));
      }
    }

    int count = 0;
    nodes.sort(Comparator.comparingDouble(o -> o.weight));

    for (Node node : nodes) {
      if (union(node.from, node.to)) {
        answer += node.weight;

        if (++count == N - 1) {
          System.out.printf("%.2f", answer);
          return;
        }
      }
    }
    System.out.printf("%.2f", answer);
  }

  private static double calDistance(int a, int b) {
    int x1 = coordinates[a][0];
    int y1 = coordinates[a][1];
    int x2 = coordinates[b][0];
    int y2 = coordinates[b][1];
    return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
  }

  private static class Node {

    int from;
    int to;
    double weight;

    public Node(int from, int to, double weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }
  }

  private static int find(int x) {
    if (x == parent[x]) {
      return x;
    }
    return parent[x] = find(parent[x]);
  }

  private static boolean union(int x, int y) {
    x = find(x);
    y = find(y);

    if (x == y) {
      return false;
    } else {
      parent[y] = x;
      return true;
    }
  }
}
