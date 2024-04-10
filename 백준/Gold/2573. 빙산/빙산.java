import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static int n, m;
  static int[][] map;
  static boolean[][] isVisited;
  static int[][] melt;
  static int[] dr = {1, -1, 0, 0};
  static int[] dc = {0, 0, 1, -1};

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


  public static void main(String[] args) throws Exception {
    String[] nm = br.readLine().split(" ");
    n = Integer.parseInt(nm[0]);
    m = Integer.parseInt(nm[1]);

    map = new int[n][m];
    melt = new int[n][m];

    for (int i = 0; i < n; i++) {
      map[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
    }

    int year = 0;

    while (true) {
      int iceCount = getIceCount();

      if (iceCount == 0) {
        System.out.println(0);
        return;
      } else if (iceCount >= 2) {
        System.out.println(year);
        return;
      }

      melt();
      year++;
    }
  }

  static int getIceCount() {
    isVisited = new boolean[n][m];
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] != 0 && !isVisited[i][j]) {
          dfs(i, j);
          count++;
        }
      }
    }

    return count;
  }

  static void dfs(int r, int c) {
    isVisited[r][c] = true;

    for (int i = 0; i < 4; i++) {
      int nr = r + dr[i];
      int nc = c + dc[i];

      if (isRange(nr, nc)) {
        // 이동 위치가 바다면 현재 위치의 빙산의 녹는 횟수 증가
        if (map[nr][nc] == 0) {
          melt[r][c]++;
        }

        if (!isVisited[nr][nc] && map[nr][nc] != 0) {
          dfs(nr, nc);
        }
      }
    }
  }

  static void melt() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (melt[i][j] != 0) {
          int meltCount = melt[i][j];

          if (map[i][j] < meltCount) {
            map[i][j] = 0;
          } else {
            map[i][j] -= meltCount;
          }
        }
      }
    }

    melt = new int[n][m];
  }


  static boolean isRange(int r, int c) {
    if (r >= 0 && r < n && c >= 0 && c < m) {
      return true;
    }
    return false;
  }
}
