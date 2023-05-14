package programmers;

import java.util.ArrayList;
import java.util.LinkedList;

public class 거리두기확인하기 {

  private static int[] dr = {1, 0, -1, 0};
  private static int[] dc = {0, 1, 0, -1};

  public int[] solution(String[][] places) {
    int[] answer = new int[5];

    for (int i = 0; i < 5; i++) {
      ArrayList<Point> points = new ArrayList();
      LinkedList<Point> queue = new LinkedList();
      String[] place = places[i];
      for (int j = 0; j < 5; j++) {
        for (int k = 0; k < 5; k++) {
          if (place[j].charAt(k) == 'P') {
            points.add(new Point(j, k));
          }
        }
      }

      boolean flag = false;

      loop:
      for (Point recent : points) {
        boolean[][] isVisited = new boolean[5][5];
        queue.add(recent);
        isVisited[recent.row][recent.col] = true;

        while (!queue.isEmpty()) {
          Point current = queue.poll();

          for (int d = 0; d < 4; d++) {
            int nr = current.row + dr[d];
            int nc = current.col + dc[d];

            if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || isVisited[nr][nc] ||
                place[nr].charAt(nc) == 'X' ||
                (Math.abs(recent.row - nr) + Math.abs(recent.col - nc)) > 2) {
              continue;
            }

            if (place[nr].charAt(nc) == 'P') {
              answer[i] = 0;
              flag = true;
              break loop;
            }

            queue.add(new Point(nr, nc));
            isVisited[nr][nc] = true;
          }
        }
      }

      if (!flag) {
        answer[i] = 1;
      }
    }
    return answer;
  }

  private static class Point {

    int row;
    int col;

    public Point(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }
}
