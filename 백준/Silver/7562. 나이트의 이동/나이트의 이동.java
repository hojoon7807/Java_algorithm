
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

  static int[] dr = {-2, -1, 1, 2, -2, -1, 1, 2};
  static int[] dc = {-1, -2, -2, -1, 1, 2, 2, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    LinkedList<int[]> q = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < t; i++) {
      int l = Integer.parseInt(br.readLine());
      boolean[][] isVisited = new boolean[l][l];

      String[] start = br.readLine().split(" ");
      String[] end = br.readLine().split(" ");
      int startR = Integer.parseInt(start[0]);
      int startC = Integer.parseInt(start[1]);

      int endR = Integer.parseInt(end[0]);
      int endC = Integer.parseInt(end[1]);

      isVisited[startR][startC] = true;
      q.add(new int[]{startR, startC, 0});

      while (!q.isEmpty()) {
        int[] recent = q.poll();

        int r = recent[0];
        int c = recent[1];
        int count = recent[2];
        if (r == endR && c == endC) {
          sb.append(count).append("\n");
          break;
        }

        for (int j = 0; j < 8; j++) {
          int nr = r + dr[j];
          int nc = c + dc[j];

          if (nr < 0 || nr >= l || nc < 0 || nc >= l) {
            continue;
          }

          if (isVisited[nr][nc]) {
            continue;
          }

          isVisited[nr][nc] = true;
          q.add(new int[]{nr, nc, count + 1});
        }
      }
      q.clear();
    }

    System.out.println(sb);
  }

}
