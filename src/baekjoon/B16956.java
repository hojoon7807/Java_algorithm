package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16956 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    int R = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    StringBuilder sb = new StringBuilder("");

    String[][] farm = new String[R][C];
    for (int i = 0; i < R; i++) {
      String[] strings = br.readLine().split("");
      for (int j = 0; j < C; j++) {
          farm[i][j] = strings[j];
      }
    }

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (farm[i][j].equals("W")) {
          for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
              if (farm[nr][nc].equals(".")) {
                farm[nr][nc] = "D";
              } else if (farm[nr][nc].equals("S")) {
                System.out.println(0);
                return;
              }
            }
          }
        }
      }
    }

    sb.append(1).append("\n");
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        sb.append(farm[i][j]);
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

}
