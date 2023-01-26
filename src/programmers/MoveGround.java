package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MoveGround {
  int[] dr = {0, 1, 0, -1};
  int[] dc = {1, 0, -1, 0};

  public int solution(int[][] land, int height) {
    int answer = 0;
    int N = land.length;
    boolean[][] isVisited = new boolean[N][N];

    PriorityQueue<int[]> q = new PriorityQueue<>((Comparator.comparingInt(o -> o[0])));

    q.add(new int[]{0,0,0});
    int moveCount = 0;
    int maxCount = N*N;


    while (moveCount < maxCount) {
      int[] current = q.poll();

      if (isVisited[current[1]][current[2]]) {
        continue;
      }
      isVisited[current[1]][current[2]] = true;

      answer += current[0];
      moveCount ++;

      for (int i = 0; i < 4; i++) {
        int nr = current[1] + dr[i];
        int nc = current[2] + dc[i];

        if (nr >= 0 && nr < N && nc >= 0 && nc < N && !isVisited[nr][nc]) {
          int diffHeigth = Math.abs(land[nr][nc] - land[current[1]][current[2]]);
          if (diffHeigth <= height) {
            q.add(new int[]{0,nr,nc});
          } else {
            q.add(new int[]{diffHeigth,nr,nc});
          }
        }
      }
    }
    return answer;
  }

}
