package toss;

import java.util.ArrayList;

public class Friend {

  public static void main(String[] args) {
    System.out.println(solution(new int[][]{{1,2},{2,3},{2,6},{3,4},{4,5}}, 2, 3));
  }
  static ArrayList<ArrayList<Integer>> friendRelationships = new ArrayList<>();
  static int answer = 0;
  static boolean[] isVisited = new boolean[101];
  public static int solution(int[][] relationships, int target, int limit) {
    for (int i = 0; i < 101; i++) {
      friendRelationships.add(new ArrayList<>());
    }

    for (int[] relationship : relationships) {
      int a = relationship[0];
      int b = relationship[1];

      friendRelationships.get(a).add(b);
      friendRelationships.get(b).add(a);
    }
    isVisited[target] = true;

    dfs(0, limit, target);
    return answer;
  }

  private static void dfs(int depth, int limit, int index) {
    if (depth == limit) {
      return;
    }

    for (Integer friend : friendRelationships.get(index)) {
      if (!isVisited[friend]) {
        isVisited[friend] = true;
        if (depth == 0) {
          answer += 5;
        } else {
          answer +=11;
        }
        dfs(depth + 1, limit, friend);
      }
    }
  }
}
