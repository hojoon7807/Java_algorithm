import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int[][] arr = new int[20][20];
  static boolean[][][] isVisited = new boolean[20][20][4];
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

    for (int i = 1; i <= 19; i++) {
      for (int j = 1; j <= 19; j++) {
        int color = arr[i][j];
        if (color != 0) {
          for (int k = 0; k < 4; k++) {
            if (check(i, j, color, k)) {
              System.out.println(color);
              if(k == 3){
                System.out.println((i + 4) + " " + (j - 4));
              } else{
                System.out.println(i + " " + j);
              }
              return;
            }
          }
        }
      }
    }

    System.out.println(0);
  }

  static boolean check(int r, int c, int color, int direct) {
    int count = 1;

    for (int i = 0; i < 6; i++) {
      int nr = r + dr[direct];
      int nc = c + dc[direct];

      if (nr > 19 || nc > 19 || nc < 1) {
        break;
      }

      if (arr[nr][nc] != color) {
        break;
      }

      if (isVisited[nr][nc][direct]) {
        break;
      }

      count++;
      isVisited[nr][nc][direct] = true;
      r = nr;
      c = nc;
    }

    if (count == 5) {
      return true;
    }

    return false;
  }
}
