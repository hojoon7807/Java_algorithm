package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class B16234 {

  static int N,L,R;
  static int[][] map;
  static ArrayList<int[]> combineMap;
  static int[] dr = {0, 1, 0, -1};
  static int[] dc = {1, 0, -1, 0};
  static boolean[][] isVisited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NLR = br.readLine().split(" ");
    N = Integer.parseInt(NLR[0]);
    L = Integer.parseInt(NLR[1]);
    R = Integer.parseInt(NLR[2]);

    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      String[] input = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(input[j]);
      }
    }
    System.out.println(move());
  }

  static int move(){
    int count = 0;
    while (true) {
      boolean isMoved = false;
      isVisited = new boolean[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (!isVisited[i][j]) {
            int sum = bfs(i, j);

            if (sum != map[i][j]) {
              changePopulation(sum);
              isMoved = true;
            }
          }
        }
      }
      if(!isMoved) return count;
      count ++;
    }
  }

  private static void changePopulation(int sum) {
    int avg = sum / combineMap.size();
    for (int[] ints : combineMap) {
      map[ints[0]][ints[1]] = avg;
    }
  }

  static int bfs(int r, int c){
    combineMap = new ArrayList<>();

    LinkedList<int[]> queue = new LinkedList<>();
    queue.add(new int[]{r, c});
    combineMap.add(new int[]{r, c});
    isVisited[r][c] = true;

    int sum = map[r][c];
    while (!queue.isEmpty()) {
      int[] current = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nr = current[0] + dr[i];
        int nc = current[1] + dc[i];

        if (nr >= 0 && nr < N && nc >= 0 && nc < N && !isVisited[nr][nc]) {
          int tmp = Math.abs(map[nr][nc] - map[current[0]][current[1]]);
          if (tmp >= L && tmp <= R) {
            isVisited[nr][nc] = true;
            queue.add(new int[]{nr,nc});
            combineMap.add(new int[]{nr, nc});

            sum += map[nr][nc];
          }
        }
      }
    }
    return sum;
  }
}
