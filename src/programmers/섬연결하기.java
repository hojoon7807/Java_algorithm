package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 섬연결하기 {

  private static int[] parent;

  public static void main(String[] args) {
    System.out.println(
        solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
  }

  public static int solution(int n, int[][] costs) {
    parent = new int[n];
    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.v));
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }

    for (int[] cost : costs) {
      pq.add(new Node(cost[0], cost[1], cost[2]));
    }

    int count = 0;
    int answer = 0;

    while (count < n - 1) {
      Node recent = pq.poll();

      if (union(recent.s, recent.e)) {
        count++;
        answer += recent.v;
      }
    }

    return answer;
  }

  private static int find(int x) {
    if (x != parent[x]) {
      parent[x] = find(parent[x]);
    }

    return parent[x];
  }

  private static boolean union(int x, int y) {
    x = find(x);
    y = find(y);

    if (x != y) {
      parent[y] = x;
      return true;
    }

    return false;
  }

  private static class Node {

    int s;
    int e;
    int v;

    public Node(int s, int e, int v) {
      this.s = s;
      this.e = e;
      this.v = v;
    }
  }

}
