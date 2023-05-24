package programmers;

import java.util.ArrayList;

public class 전력망을둘로나누기 {

  private static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

  private static boolean[] isVisited;
  private static int min = Integer.MAX_VALUE;

  public static void main(String[] args) {
    System.out.println(solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
// System.out.println(solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}));
    // System.out.println(solution(7, new int[][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}}));

  }

  public static int solution(int n, int[][] wires) {
    for (int i = 0; i <= n; i++) {
      tree.add(new ArrayList<>());
    }

    for (int i = 0; i < wires.length; i++) {
      tree.get(wires[i][0]).add(wires[i][1]);
      tree.get(wires[i][1]).add(wires[i][0]);
    }
    isVisited = new boolean[n + 1];

    calCount(1);
    return min;
  }

  public static int calCount(int index) {
    isVisited[index] = true;
    int count = 1;
    for (Integer child : tree.get(index)) {
      if (isVisited[child]) {
        continue;
      }
      count += calCount(child);
    }

    min = Math.min(min, Math.abs(tree.size() - 1 - 2 * count));

    return count;
  }

}
