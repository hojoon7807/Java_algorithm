package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class I0210 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[][] arr = new int[N + 2][N + 2];
    int count = 0;

    for (int i = 1; i < N + 1; i++) {
      String[] strings = br.readLine().split(" ");

      for (int j = 1; j < N + 1; j++) {
        arr[i][j] = Integer.parseInt(strings[j - 1]);
      }
    }

    for (int i = 1; i < N + 1; i++) {
      for (int j = 1; j < N + 1; j++) {
        int height = arr[i][j];
        if (height > arr[i + 1][j] && height > arr[i - 1][j] && height > arr[i][j - 1]
            && height > arr[i][j + 1]) {
          count++;
        }
      }
    }

    System.out.println(count);
  }
}
