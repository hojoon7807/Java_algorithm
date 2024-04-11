import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static int n;
  static int[][] map;

  static int[] dr = {0, 1, 0, -1};
  static int[] dc = {-1, 0, 1, 0};

  // 왼 아 오 위
  static int[][] spreadDr = {{-1, 1, -2, 2, -1, 1, -1, 1, 0}, {-1, -1, 0, 0, 0, 0, 1, 1, 2},
      {-1, 1, -2, 2, -1, 1, -1, 1, 0}, {1, 1, 0, 0, 0, 0, -1, -1, -2}};
  static int[][] spreadDc = {{1, 1, 0, 0, 0, 0, -1, -1, -2}, {-1, 1, -2, 2, -1, 1, -1, 1, 0},
      {-1, -1, 0, 0, 0, 0, 1, 1, 2}, {-1, 1, -2, 2, -1, 1, -1, 1, 0}};
  static int[] ratio = {1, 1, 2, 2, 7, 7, 10, 10, 5};
  static int maxLen;
  static int outCount = 0;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());
    map = new int[n][n];

    for (int i = 0; i < n; i++) {
      map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    maxLen = 1 + (n >> 1) * 4;
    move(n >> 1, n >> 1, 1, 0);
    System.out.println(outCount);
  }

  static void move(int r, int c, int len, int direct) {
    if (len > maxLen) {
      return;
    }

    int count = (len + 1) >> 1;

    if (len == maxLen) {
      count--;
    }

    for (int i = 0; i < count; i++) {
      int nr = r + dr[direct];
      int nc = c + dc[direct];

      int remain = spread(nr, nc, direct);

      int lastR = nr + dr[direct];
      int lastC = nc + dc[direct];

      if (isRange(lastR, lastC)) {
        map[lastR][lastC] += remain;
      } else {
        outCount += remain;
      }

      r = nr;
      c = nc;
    }

    move(r, c, len + 1, (direct + 1) % 4);
  }

  static int spread(int r, int c, int direct) {
    if (map[r][c] == 0) {
      return 0;
    }

    int move = 0;
    for (int i = 0; i < 9; i++) {
      int nr = r + spreadDr[direct][i];
      int nc = c + spreadDc[direct][i];

      int spreadDust = map[r][c] * ratio[i] / 100;

      if (isRange(nr, nc)) {
        map[nr][nc] += spreadDust;
      } else {
        outCount += spreadDust;
      }

      move += spreadDust;
    }

    int remain = map[r][c] - move;
    map[r][c] = 0;

    return remain;
  }

  static boolean isRange(int r, int c) {
    if (r >= 0 && r < n && c >= 0 && c < n) {
      return true;
    }

    return false;
  }

}
