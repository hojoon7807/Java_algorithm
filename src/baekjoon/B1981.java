package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B1981 {

  static int n;
  static int max = Integer.MIN_VALUE;
  static int min = Integer.MAX_VALUE;
  static int[][] arr;
  static int answer = 0;
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    arr = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(input[j]);
        max = Math.max(max, arr[i][j]);
        min = Math.min(min, arr[i][j]);
      }
    }

    bs(0, max - min);
  }

  static void bs(int start, int end) {
    loop:while (start <= end) {
      int mid = end - start;

      for (int i = min; i + mid <= max; i++) {
        if (bfs(i, i + mid)) {
          end = mid - 1;
          answer = mid;
          continue loop;
        }
      }
      start = mid + 1;
    }
    System.out.print(answer);
  }
  static boolean bfs(int min, int max) {
    if (min > arr[0][0] || arr[0][0] > max) return false;

    boolean[][] visit = new boolean[n][n];
    Queue<int[]> que = new LinkedList<>();

    que.add(new int[] {0, 0});
    visit[0][0] = true;

    while (!que.isEmpty()) {
      int[] now = que.poll();

      if (now[0] == n-1 && now[1] == n-1) return true;

      for (int i=0; i<4; i++) {

        int nr = now[0] + dy[i];
        int nc = now[1] + dx[i];

        if (0 <= nr && nr < n && 0 <= nc && nc < n && !visit[nr][nc]) {
          if (min <= arr[nr][nc] && arr[nr][nc] <= max) {
            visit[nr][nc] = true;
            que.add(new int[] {nr, nc});
          }
        }
      }
    }
    return false;
  }

}
