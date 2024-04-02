import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

  static int[][] arr = new int[20][20];
  static boolean[][][] isVisited = new boolean[20][20][4];
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int answerR = -1, answerC = -1;
  static int[] dr = {1, 0, 1, 1};
  static int[] dc = {0, 1, 1, -1};

  public static void main(String[] args) throws IOException {
    for (int i = 1; i <= 19; i++) {
      String[] input = br.readLine().split(" ");
      for (int j = 1; j <= 19; j++) {
        int color = Integer.parseInt(input[j - 1]);
        arr[i][j] = color;
      }
    }

    check();

    System.out.println(0);
  }

  static void check() {
    for (int i = 1; i <= 19; i++) {
      for (int j = 1; j <= 19; j++) {
        int color = arr[i][j];
        if (color != 0) {
          for (int k = 0; k < 4; k++) {
            if (bfs(i, j, color, k)) {
              System.out.println(color);
              System.out.println(answerR + " " + answerC);
              System.exit(0);
            }
          }
        }
      }
    }
  }

  static boolean bfs(int r, int c, int color, int direct) {
    LinkedList<int[]> q = new LinkedList<>();
    isVisited[r][c][direct] = true;
    q.add(new int[]{r, c});

    int count = 1;

    for (int i = 0; i < 6; i++) {
      int[] cur = q.poll();

      int nr = cur[0] + dr[direct];
      int nc = cur[1] + dc[direct];

      if (nr > 19 || nc > 19 || nc < 1) {
        break;
      }

      if (isVisited[nr][nc][direct]) {
        break;
      }

      if (arr[nr][nc] != color) {
        break;
      }

      count ++;
      isVisited[nr][nc][direct] = true;
      q.add(new int[]{nr, nc});
    }

    if (count == 5) {
      if (direct == 3) {
        answerR = r + 4;
        answerC = c - 4;
      } else {
        answerR = r;
        answerC = c;
      }

      return true;
    }

    return false;
  }
}
