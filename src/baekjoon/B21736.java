package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B21736 {
  static int N,M;
  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};
  static char[][] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nm = br.readLine().split(" ");
    N = Integer.parseInt(nm[0]);
    M = Integer.parseInt(nm[1]);
    arr = new char[N][M];

    int[] start = new int[2];

    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      for (int j = 0; j < M; j++) {
        if(input.charAt(j) == 'I'){
          start = new int[]{i, j};
        }
        arr[i][j] = input.charAt(j);
      }
    }

    boolean[][] isVisited = new boolean[N][M];

    isVisited[start[0]][start[1]] = true;
    LinkedList<int[]> q = new LinkedList<>();
    q.add(start);

    int count = 0;

    while (!q.isEmpty()) {
      int[] recent = q.poll();

      if (arr[recent[0]][recent[1]] == 'P') {
        count++;
      }
      for (int i = 0; i < 4; i++) {
        int nr = recent[0] + dr[i];
        int nc = recent[1] + dc[i];

        if (nr >= 0 && nr < N && nc >= 0 && nc < M && arr[nr][nc] != 'X' && !isVisited[nr][nc]) {
          isVisited[nr][nc] = true;
          q.add(new int[]{nr, nc});
        }
      }
    }

    System.out.println(count == 0 ? "TT" : count);
  }
}
