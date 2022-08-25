package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class I0211 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[][] arr = new int[N][5];

    int answer = 0;
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < N; i++) {
      String[] strings = br.readLine().split(" ");

      for (int j = 0; j < 5; j++) {
        arr[i][j] = Integer.parseInt(strings[j]);
      }
    }

    for (int i = 0; i < N; i++) {
      int count = 0;
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < 5; k++) {
          if (arr[i][k] == arr[j][k]) {
            count++;
            break;
          }
        }
      }

      if (count > max) {
        max = count;
        answer = i;
      }
    }

    System.out.println(answer+1);
  }

}
