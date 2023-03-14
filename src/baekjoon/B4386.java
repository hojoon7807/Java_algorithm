package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B4386 {

  static int[] parent;
  static PriorityQueue<Node> queue;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    parent = new int[N];
    queue = new PriorityQueue();

    for (int i = 0; i < N; i++) {
      parent[i] = i;
    }
    double[][] stars = new double[N][2];

    for (int i = 0; i < N; i++) {
      String[] input = br.readLine().split(" ");
      double x = Double.parseDouble(input[0]);
      double y = Double.parseDouble(input[1]);

      stars[i] = new double[]{x, y};
    }

    for (int i = 0; i < N; i++) {
      for (int j = i; j < N; j++) {
        if (i == j) {
          continue;
        }
        double[] node = stars[i];
        double[] edge = stars[j];
        double v = Math.sqrt(Math.pow(edge[0] - node[0], 2) + Math.pow(edge[1] - node[1], 2));
        queue.add(new Node(i, j, v));
      }
    }

    int useEdge = 0;
    double result = 0;

    while(useEdge < N-1){
      Node now = queue.poll();
      if (find(now.s) != find(now.e)) {
        union(now.s, now.e);
        result += now.v;
        useEdge ++;
      }
    }
    System.out.printf("%.2f", result);
  }

  static void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b) {
      parent[b] = a;
    }
  }

  static int find(int a) {
    if (a == parent[a]) {
      return a;
    } else {
      return parent[a] = find(parent[a]);
    }
  }

  private static class Node implements Comparable<Node> {
    int s;
    int e;
    double v;

    public Node(int s, int e, double v) {
      this.s = s;
      this.e = e;
      this.v = v;
    }

    @Override
    public int compareTo(Node o) {
      return (int)(this.v - o.v);
    }
  }
}
