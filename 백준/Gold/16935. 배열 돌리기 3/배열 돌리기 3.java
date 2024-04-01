
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int n, m, r;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[][] arr;

  public static void main(String[] args) throws IOException {
    String[] nmr = br.readLine().split(" ");
    n = Integer.parseInt(nmr[0]);
    m = Integer.parseInt(nmr[1]);
    r = Integer.parseInt(nmr[2]);

    arr = new int[n][m];
    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(input[j]);
      }
    }

    String[] input = br.readLine().split(" ");

    for (int i = 0; i < r; i++) {
      int operator = Integer.parseInt(input[i]);

      switch (operator) {
        case 1:
          one();
          break;
        case 2:
          two();
          break;
        case 3:
          three();
          break;
        case 4:
          four();
          break;
        case 5:
          five();
          break;
        case 6:
          six();
          break;
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        sb.append(arr[i][j]).append(" ");
      }
      sb.append("\n");
    }


    System.out.println(sb);
  }


  static void one() {
    for (int i = 0; i < n >> 1; i++) {
      int[] tmp = arr[i];
      arr[i] = arr[n - i - 1];
      arr[n - i - 1] = tmp;
    }
  }

  static void two() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m >> 1; j++) {
        int tmp = arr[i][j];
        arr[i][j] = arr[i][m - j - 1];
        arr[i][m - j - 1] = tmp;
      }
    }
  }

  static void three() {
    int[][] tmp = new int[m][n];
    // 0,0 -> 0,5  0,7 -> 7,5  5,7 -> 7,0
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        tmp[j][n - i - 1] = arr[i][j];
      }
    }

    arr = tmp;
    n = arr.length;
    m = arr[0].length;
  }

  static void four() {
    int[][] tmp = new int[m][n];
    // 5, 7
    // 0,0 -> 7,0  0,7 -> 0,0  5,7 -> 0,7
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        tmp[m - j - 1][i] = arr[i][j];
      }
    }

    arr = tmp;
    n = arr.length;
    m = arr[0].length;
  }

  static void five() {
    int[][] tmp = new int[n][m];
    // 1->2->3->4
    int halfR = n >> 1;
    int halfC = m >> 1;
    for (int i = 0; i < halfR; i++) {
      for (int j = 0; j < halfC; j++) {
        tmp[i][j + halfC] = arr[i][j];
      }
    }

    for (int i = 0; i < halfR; i++) {
      for (int j = halfC; j < m; j++) {
        tmp[i + halfR][j] = arr[i][j];
      }
    }

    for (int i = halfR; i < n; i++) {
      for (int j = halfC; j < m; j++) {
        tmp[i][j - halfC] = arr[i][j];
      }
    }

    for (int i = halfR; i < n; i++) {
      for (int j = 0; j < halfC; j++) {
        tmp[i - halfR][j] = arr[i][j];
      }
    }

    arr = tmp;
  }

  static void six() {
    int[][] tmp = new int[n][m];

    int halfR = n >> 1;
    int halfC = m >> 1;
    for (int i = 0; i < halfR; i++) {
      for (int j = 0; j < halfC; j++) {
        tmp[i + halfR][j] = arr[i][j];
      }
    }

    for (int i = 0; i < halfR; i++) {
      for (int j = halfC; j < m; j++) {
        tmp[i][j - halfC] = arr[i][j];
      }
    }

    for (int i = halfR; i < n; i++) {
      for (int j = halfC; j < m; j++) {
        tmp[i - halfR][j] = arr[i][j];
      }
    }

    for (int i = halfR; i < n; i++) {
      for (int j = 0; j < halfC; j++) {
        tmp[i][j + halfC] = arr[i][j];
      }
    }

    arr = tmp;
  }

}
