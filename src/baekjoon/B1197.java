package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class B1197 {

  private static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int V = Integer.parseInt(input[0]);
    int E = Integer.parseInt(input[1]);

    parent = new int[V];

    for (int i = 0; i < V; i++) {
      parent[i] = i;
    }

    ArrayList<Node> nodes = new ArrayList<>();

    for (int i = 0; i < E; i++) {
      input = br.readLine().split(" ");
      int a = Integer.parseInt(input[0]) - 1;
      int b = Integer.parseInt(input[1]) - 1;
      int c = Integer.parseInt(input[2]);

      nodes.add(new Node(a, b, c));
    }

    nodes.sort(Comparator.comparing(node -> node.w));

    int answer = 0;
    int count = 0;
    for (Node node : nodes) {
      if (count == V - 1) {
        break;
      }
      int a = find(node.from);
      int b = find(node.to);

      if (a != b) {
        parent[b] = a;
        answer += node.w;
        count ++;
      }
    }
    System.out.println(answer);
  }
  private static class Node {
    int from;
    int to;
    int w;

    public Node(int from, int to, int w) {
      this.from = from;
      this.to = to;
      this.w = w;
    }
  }

  private static int find(int x) {
    if(parent[x] != x) {
      parent[x] = find(parent[x]);
    }

    return parent[x];
  }
}
