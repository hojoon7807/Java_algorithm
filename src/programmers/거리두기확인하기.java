package programmers;

import java.util.ArrayList;
import java.util.LinkedList;

public class 거리두기확인하기 {

  private static int[] dr = {1, 0, -1, 0};
  private static int[] dc = {0, 1, 0, -1};

  public int[] solution(String[][] places) {
    int[] answer = new int[5];

    for (int i = 0; i < 5; i++) {
      String[] place = places[i];
      ArrayList<Location> applicants = new ArrayList<>();
      for (int r = 0; r < 5; r++) {
        for (int c = 0; c < 5; c++) {
          if (place[r].charAt(c) == 'P') {
            applicants.add(new Location(r, c));
          }
        }
      }

      boolean flag = true;

      for (Location applicant : applicants) {
        if (!isPossible(applicant, place)) {
          flag = false;
          break;
        }
      }

      answer[i] = flag ? 1 : 0;
    }
    return answer;
  }

  boolean isPossible(Location base, String[] place) {
    LinkedList<Location> q = new LinkedList<>();
    boolean[][] isVisited = new boolean[5][5];
    q.add(base);
    isVisited[base.r][base.c] = true;

    while (!q.isEmpty()) {
      Location cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int nr = cur.r + dr[i];
        int nc = cur.c + dc[i];

        if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) {
          continue;
        }

        // 방문 or 벽
        if (isVisited[nr][nc] || place[nr].charAt(nc) == 'X') {
          continue;
        }

        int distance = Math.abs(nr - base.r) + Math.abs(nc - base.c);
        if (distance > 2) {
          continue;
        }

        if (place[nr].charAt(nc) == 'P') {
          return false;
        }

        q.add(new Location(nr, nc));
        isVisited[nr][nc] = true;
      }
    }

    return true;
  }

  static class Location {

    int r;
    int c;

    Location(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }
}
