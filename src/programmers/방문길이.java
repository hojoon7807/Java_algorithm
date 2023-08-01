package programmers;

public class 방문길이 {

  public static int solution(String dirs) {
    boolean[][][] isVisited = new boolean[11][11][4];
    int answer = 0;
    int r = 5;
    int c = 5;
    int[] dr = {-1, 0, 0, 1};
    int[] dc = {0, 1, -1, 0};

    int len = dirs.length();

    for (int i = 0; i < len; i++) {
      char command = dirs.charAt(i);
      int dir = switch (command) {
        case 'U' -> 0;
        case 'D' -> 3;
        case 'R' -> 1;
        case 'L' -> 2;
        default -> -1;
      };

      int nr = r + dr[dir];
      int nc = c + dc[dir];
      if (isRange(nr, nc)) {
        if (!isVisited[r][c][dir] && !isVisited[nr][nc][3 - dir]) {
          isVisited[r][c][dir] = true;
          isVisited[nr][nc][3 - dir] = true;
          answer++;

        }
        r = nr;
        c = nc;
      }
    }
    return answer;
  }

  public static boolean isRange(int r, int c) {
    if (r >= 0 && r < 11 && c >= 0 && c < 11) {
      return true;
    } else {
      return false;
    }
  }
}
