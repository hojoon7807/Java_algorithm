package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14890 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, l;
  static int[][] arr;

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void solution() {
    int answer = 0;
    // 3 3 3 2 2 2 3 3 3
    for (int i = 0; i < n; i++) {
      boolean flag = true;
      int lastLocation = -1;
      for (int j = 1; j < n; j++) {
        int diff = Math.abs(arr[i][j - 1] - arr[i][j]);

        if (!flag) {
          break;
        }

        if (diff > 1) {
          flag = false;
          break;
        } else if (diff == 1) {
          if (arr[i][j - 1] > arr[i][j]) {
            //  \
            for (int k = j; k < j + l; k++) {
              // 길이가 안되면 || 높이가 다르면
              if (k >= n || arr[i][k] != arr[i][j]) {
                flag = false;
                break;
              }

              lastLocation = k;
            }
          } else {
            if (j - l > lastLocation) {
              for (int k = j - 1; k > j - 1 - l; k--) {
                // 길이가 안되면 || 높이가 다르면
                if (k < 0 || arr[i][k] != arr[i][j - 1]) {
                  flag = false;
                  break;
                }
              }
            } else {
              flag = false;
            }
          }
        }
      }

      if (flag) {
        answer++;
      }
    }

    for (int i = 0; i < n; i++) {
      boolean flag = true;
      int lastLocation = -1;

      for (int j = 1; j < n; j++) {
        int diff = Math.abs(arr[j - 1][i] - arr[j][i]);

        if (!flag) {
          break;
        }

        if (diff > 1) {
          flag = false;
          break;
        } else if (diff == 1) {
          if (arr[j - 1][i] > arr[j][i]) {
            //  \
            for (int k = j; k < j + l; k++) {
              // 길이가 안되면 || 높이가 다르면
              if (k >= n || arr[k][i] != arr[j][i]) {
                flag = false;
                break;
              }

              lastLocation = k;
            }
          } else {
            // /
            if (j - l > lastLocation) {
              for (int k = j - 1; k > j - 1 - l; k--) {
                // 길이가 안되면 || 높이가 다르면
                if (k < 0 || arr[k][i] != arr[j - 1][i]) {
                  flag = false;
                  break;
                }
              }
            } else {
              flag = false;
            }
          }
        }
      }

      if (flag) {
        answer++;
      }
    }

    System.out.println(answer);
  }

  static void input() throws IOException {
    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    l = Integer.parseInt(input[1]);

    arr = new int[n][n];

    for (int i = 0; i < n; i++) {
      input = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(input[j]);
      }
    }
  }

}
