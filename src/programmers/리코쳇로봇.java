package programmers;

import java.util.LinkedList;

public class 리코쳇로봇 {

  int[] dr = {1, 0, -1, 0};
  int[] dc = {0, 1, 0, -1};
  boolean[][] visit;
  int rowLen, colLen;
  int[] start;

  public static void main(String[] args) {
    리코쳇로봇 r = new 리코쳇로봇();
    System.out.println(    r.solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
  }

  public int solution(String[] board) {
    rowLen = board.length;
    colLen = board[0].length();
    visit = new boolean[rowLen][colLen];
    for (int i = 0; i < rowLen; i++) {
      for (int j = 0; j < colLen; j++) {
        if (board[i].charAt(j) == 'R') {
          start = new int[]{i, j};
          continue;
        }
      }
    }
    return bfs(board);
  }

  public int bfs(String[] board) {
    LinkedList<Robot> q = new LinkedList();
    visit[start[0]][start[1]] = true;
    q.add(new Robot(start[0], start[1], 0));

    while (!q.isEmpty()) {
      Robot recent = q.poll();

      for (int i = 0; i < 4; i++) {
        int nr = recent.r;
        int nc = recent.c;

        while (true) {
          if (nr < 0 || nr >= rowLen || nc < 0 || nc >= colLen || board[nr].charAt(nc) == 'D') {
            nr -= dr[i];
            nc -= dc[i];
            break;
          }
          nr += dr[i];
          nc += dc[i];
        }

        if (board[nr].charAt(nc) == 'G') {
          return recent.count + 1;
        }


        if(!visit[nr][nc]){
          visit[nr][nc] = true;
          q.add(new Robot(nr, nc, recent.count + 1));
        }
      }
    }
    return -1;
  }

  static class Robot {

    int r;
    int c;
    int count;

    public Robot(int r, int c, int count) {
      this.r = r;
      this.c = c;
      this.count = count;
    }
  }

}
