package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B16236 {

  static private int[][] space;
  static private int[] dr = {-1, 0, 1, 0};
  static private int[] dc = {0, -1, 0, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    space = new int[n][n];

    PriorityQueue<Shark> pq;

    int eat = 0;
    int answer = 0;
    int size = 2;

    Shark recent = null;
    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        int value = Integer.parseInt(input[j]);
        if (value == 9) {
          recent = new Shark(i, j, 0);
          continue;
        }
        space[i][j] = value;
      }
    }

    // 먹을때마다 이동 경로가 달라진다.
    while (true) {
      pq = new PriorityQueue<>(((o1, o2) -> {
        if (o1.moveCount == o2.moveCount) {
          if (o1.r == o2.r) {
            return o1.c - o2.c;
          } else {
            return o1.r - o2.r;
          }
        } else {
          return o1.moveCount - o2.moveCount;
        }
      }));
      boolean[][] isVisited = new boolean[n][n];
      pq.add(new Shark(recent.r, recent.c, 0));
      isVisited[recent.r][recent.c] = true;
      boolean isEat = false;

      while (!pq.isEmpty()) {
        recent = pq.poll();

        if (space[recent.r][recent.c] > 0 && space[recent.r][recent.c] < size) {
          eat++;
          space[recent.r][recent.c] = 0;
          answer += recent.moveCount;
          isEat = true;
          break;
        }

        for (int i = 0; i < 4; i++) {
          int nr = recent.r + dr[i];
          int nc = recent.c + dc[i];

          if (nr >= 0 && nr < n && nc >= 0 && nc < n && !isVisited[nr][nc]
              && space[nr][nc] <= size) {
            pq.add(new Shark(nr, nc, recent.moveCount + 1));
            isVisited[nr][nc] = true;
          }
        }
      }

      if (!isEat) {
        break;
      }

      if (eat == size) {
        size++;
        eat = 0;
      }
    }
    System.out.println(answer);
  }

  private static class Shark {

    int r;
    int c;
    int moveCount;

    public Shark(int r, int c, int moveCount) {
      this.r = r;
      this.c = c;
      this.moveCount = moveCount;
    }
  }
}
