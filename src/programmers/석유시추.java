package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class 석유시추 {

  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};

  public static void main(String[] args) {
    solution(
        new int[][]{{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0},
            {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}});
    solution(new int[][]{{0, 0, 0, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}});
  }

  public static int solution(int[][] land) {
    int answer = 0;
    int row = land.length;
    int col = land[0].length;

    boolean[][] isVisited = new boolean[row][col];

    LinkedList<int[]> q = new LinkedList<>();
    ArrayList<int[]> list = new ArrayList<>();
    HashMap<Integer, Integer> groupMap = new HashMap<>();
    int groupNum = 2;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (land[i][j] == 1 && !isVisited[i][j]) {
          isVisited[i][j] = true;
          q.add(new int[]{i, j});
          list.add(new int[]{i, j});
          int size = 1;
          while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int k = 0; k < 4; k++) {
              int nr = cur[0] + dr[k];
              int nc = cur[1] + dc[k];

              if (nr < 0 || nr >= row || nc < 0 || nc >= col) {
                continue;
              }

              if (land[nr][nc] != 1 || isVisited[nr][nc]) {
                continue;
              }

              size++;
              isVisited[nr][nc] = true;
              list.add(new int[]{nr, nc});
              q.add(new int[]{nr, nc});
            }
          }

          for (int[] point : list) {
            land[point[0]][point[1]] = groupNum;
          }
          groupMap.put(groupNum, size);

          groupNum++;
          list.clear();
        }
      }
    }

    for (int i = 0; i < col; i++) {
      HashSet<Integer> groupSet = new HashSet<>();
      int sum = 0;
      for (int j = 0; j < row; j++) {
        int key = land[j][i];
        if (key != 0 && !groupSet.contains(key)) {
          groupSet.add(key);
          sum += groupMap.get(key);
        }
      }

      answer = Math.max(answer, sum);
    }
    return answer;
  }

}
