package programmers;

import java.util.Arrays;
import java.util.LinkedList;

public class 무인도여행 {

  static int[] dr = {0, 1, 0, -1};
  static int[] dc = {1, 0, -1, 0};
  static boolean[][] isVisited;
  static int[][] groups;
  static int rowLen;
  static int colLen;

  public int[] solution(String[] maps) {
    rowLen = maps.length;
    colLen = maps[0].length();

    isVisited = new boolean[rowLen][colLen];

    groups = new int[rowLen][colLen];

    int groupNum = 1;
    for (int i = 0; i < rowLen; i++) {
      for (int j = 0; j < colLen; j++) {
        if (!isVisited[i][j] && maps[i].charAt(j) != 'X') {
          makeGroup(groupNum, maps, i, j);
          groupNum++;
        }
      }
    }

    if (groupNum == 1) {
      return new int[]{-1};
    }

    int[] foods = new int[groupNum - 1];

    for (int i = 0; i < rowLen; i++) {
      for (int j = 0; j < colLen; j++) {
        int index = groups[i][j];
        if (index != 0) {
          foods[index - 1] += maps[i].charAt(j) - '0';
        }
      }
    }
    Arrays.sort(foods);
    return foods;
  }

  // 그룹핑

  private void makeGroup(int groupNum, String[] maps, int r, int c) {
    isVisited[r][c] = true;
    LinkedList<Node> q = new LinkedList<Node>();

    groups[r][c] = groupNum;
    q.add(new Node(r, c));

    while (!q.isEmpty()) {
      Node recent = q.poll();

      for (int i = 0; i < 4; i++) {
        int nr = recent.r + dr[i];
        int nc = recent.c + dc[i];

        if (nr < 0 || nr >= rowLen || nc < 0 || nc >= colLen || isVisited[nr][nc] ||
            maps[nr].charAt(nc) == 'X') {
          continue;
        }

        q.add(new Node(nr, nc));
        isVisited[nr][nc] = true;
        groups[nr][nc] = groupNum;
      }
    }
  }

  private static class Node {

    int r;
    int c;

    public Node(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }
}
