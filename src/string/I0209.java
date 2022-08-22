package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class I0209 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[][] arr = new int[N][N];
    int[] sums = new int[4];

    for (int i = 0; i < N; i++) {
      String[] strings = br.readLine().split(" ");

      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(strings[j]);
      }
    }

    for (int i = 0; i < N; i++) {
      int sum = 0;
      for (int j = 0; j < N; j++) {
        sum += arr[j][i];
      }
      if(sums[0]<sum) sums[0] = sum;
    }

    for (int i = 0; i < N; i++) {
      int sum = 0;
      for (int j = 0; j < N; j++) {
        sum += arr[i][j];
      }
      if(sums[1]<sum) sums[1] = sum;
    }

    for (int i = 0; i < N; i++) {
      sums[2] += arr[i][i];
    }

    for (int i = 0; i < N; i++) {
      sums[3] += arr[i][N-i-1];
    }

    Arrays.sort(sums);

    System.out.println(sums[3]);
  }

}
