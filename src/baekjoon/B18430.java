package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B18430 {
  static int N,M,answer;
  static boolean[][] isVisited;
  static int[][] wood;

  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NM = br.readLine().split(" ");
    N = Integer.parseInt(NM[0]);
    M = Integer.parseInt(NM[1]);

    wood = new int[N][M];
    isVisited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      String[] input = br.readLine().split(" ");
      for (int j = 0; j < M; j++) {
        wood[i][j] = Integer.parseInt(input[j]);
      }
    }
    if(N < 2 || M < 2) {
      System.out.println(0);
      return;
    }

    dfs(0, 0, 0);
    System.out.println(answer);
  }

  static void dfs(int r, int c, int sum) {
    if (c == M) {
      c = 0;
      r ++;
    }

    if (r == N) {
      answer = Math.max(answer, sum);
      return;
    }

    if (!isVisited[r][c]) {
      if (r + 1 < N && c + 1 < M && !isVisited[r + 1][c] && !isVisited[r][c + 1]) {
        isVisited[r][c] = true;
        isVisited[r+1][c] = true;
        isVisited[r][c+1] = true;
        sum += calShape1(r, c);
        dfs(r, c + 1, sum);
        sum -= calShape1(r, c);
        isVisited[r][c] = false;
        isVisited[r+1][c] = false;
        isVisited[r][c+1] = false;
      }

      if (r + 1 < N && c - 1 >= 0 && !isVisited[r + 1][c] && !isVisited[r][c - 1]) {
        isVisited[r][c] = true;
        isVisited[r+1][c] = true;
        isVisited[r][c-1] = true;
        sum += calShape2(r, c);
        dfs(r, c + 1, sum);
        sum -= calShape2(r, c);
        isVisited[r][c] = false;
        isVisited[r+1][c] = false;
        isVisited[r][c-1] = false;
      }

      if (r - 1 >= 0 && c + 1 < M && !isVisited[r - 1][c] && !isVisited[r][c + 1]) {
        isVisited[r][c] = true;
        isVisited[r-1][c] = true;
        isVisited[r][c+1] = true;
        sum += calShape3(r, c);
        dfs(r, c + 1, sum);
        sum -= calShape3(r, c);
        isVisited[r][c] = false;
        isVisited[r-1][c] = false;
        isVisited[r][c+1] = false;
      }

      if (r - 1 >= 0 && c - 1 >= 0 && !isVisited[r - 1][c] && !isVisited[r][c - 1]) {
        isVisited[r][c] = true;
        isVisited[r-1][c] = true;
        isVisited[r][c-1] = true;
        sum += calShape4(r, c);
        dfs(r, c + 1, sum);
        sum -= calShape4(r, c);
        isVisited[r][c] = false;
        isVisited[r-1][c] = false;
        isVisited[r][c-1] = false;
      }
    }
    dfs(r, c + 1, sum);
    return;
  }

  static int calShape1(int r, int c) {
    return wood[r][c] * 2 + wood[r + 1][c] + wood[r][c + 1];
  }

  static int calShape2(int r, int c) {
    return wood[r][c] * 2 + wood[r + 1][c] + wood[r][c - 1];
  }

  static int calShape3(int r, int c) {
    return wood[r][c] * 2 + wood[r - 1][c] + wood[r][c + 1];
  }

  static int calShape4(int r, int c) {
    return wood[r][c] * 2 + wood[r - 1][c] + wood[r][c - 1];
  }
}
