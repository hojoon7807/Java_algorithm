package programmers;

import java.util.ArrayList;

public class 등대 {

  private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

  public static void main(String[] args) {
    solution(8, new int[][]{{1, 2}, {1, 3}, {1, 4}, {1, 5}, {5, 6}, {5, 7}, {5, 8}});
  }


  public static int solution(int n, int[][] lighthouse) {
    int answer = 0;

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int[] light : lighthouse) {
      graph.get(light[0]).add(new Node(0,light[1]));
      graph.get(light[1]).add(new Node(light[0], 0));
    }
    return answer;
  }

  private static class Node {
    int parent;
    int child;

    public Node(int parent, int child) {
      this.parent = parent;
      this.child = child;
    }
  }
}
