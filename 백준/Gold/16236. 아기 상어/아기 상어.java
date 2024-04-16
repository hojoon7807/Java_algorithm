import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

  static  int[][] map;
  static int[] dr = {-1, 0, 1, 0};
  static int[] dc = {0, -1, 0, 1};
  static boolean[][] isVisited;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  /*
  아기 상어의 크기는 2, 상하좌우 이동, 자기보다 큰 물고기 칸은 이동 불가

  1. 더 이상 먹을 수 있는 물고기가 공간에 없다면 엄마에게 도움 요청
  2. 먹을 수 있는 물고기가 1마리라면 먹으러간다
  3. 1마리보다 많다면 거리가 가장 가까운 물고기를 먹으러 간다.
    1) 지나가야하는 칸의 개수의 최솟값
    2) 가장 위에 있는 물고기 -> 가장 왼쪽

  4. 물고기를 먹으면 해당칸은 0, 자신의 크기와 같은 수의 물고기를 먹을 때 마다 1 증가
   */

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());
    map = new int[n][n];
    isVisited = new boolean[n][n];
    PriorityQueue<Shark> pq = new PriorityQueue<>();

    Shark baby = null;
    int size = 2;
    int answer = 0;
    int eatCount = 0;

    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        int v = Integer.parseInt(input[j]);

        if (v == 9) {
          map[i][j] = 0;
          isVisited[i][j] = true;
          baby = new Shark(i, j, 0);
          pq.add(baby);
        } else {
          map[i][j] = v;
        }
      }
    }

    while (!pq.isEmpty()) {
      Shark cur = pq.poll();

      if (map[cur.r][cur.c] > 0 && map[cur.r][cur.c] < size) {
        eatCount ++;

        if (eatCount == size) {
          size ++;
          eatCount = 0;
        }

        answer = cur.moveCount;
        pq.clear();
        map[cur.r][cur.c] = 0;
        isVisited = new boolean[n][n];
      }

      for (int i = 0; i < 4; i++) {
        int nr = cur.r + dr[i];
        int nc = cur.c + dc[i];

        if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
          continue;
        }

        if (isVisited[nr][nc]) {
          continue;
        }

        if (map[nr][nc] <= size) {
          isVisited[nr][nc] = true;
          pq.add(new Shark(nr, nc, cur.moveCount + 1));
        }
      }

    }

    System.out.println(answer);
  }

  static class Shark implements Comparable<Shark>{

    int r;
    int c;
    int moveCount;

    public Shark(int r, int c, int moveCount) {
      this.r = r;
      this.c = c;
      this.moveCount = moveCount;
    }

    @Override
    public int compareTo(Shark o) {
      if (this.moveCount == o.moveCount) {
        if (this.r == o.r) {
          return this.c - o.c;
        }

        return this.r - o.r;
      }

      return this.moveCount - o.moveCount;
    }
  }
}
