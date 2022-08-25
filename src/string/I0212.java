package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class I0212 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nm = br.readLine().split(" ");

    int N = Integer.parseInt(nm[0]);
    int M = Integer.parseInt(nm[1]);

    int[][] arr = new int[M][N];

    for (int i = 0; i < M; i++) {
      String[] strings = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(strings[j]);
      }
    }

    int answer = 0;

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        int count = 0;
        for (int k = 0; k < M; k++) {
          int pi = 0, pj = 0;
          for (int l = 0; l < N; l++) {
            if (arr[k][l] == i) {
              pi = l;
            }
            if (arr[k][l] == j) {
              pj = l;
            }
          }
          if (pi < pj) {
            count++;
          }
        }
        if (count == M) {
          answer ++;
        }
      }

    }

    System.out.println(answer);
  }

}
