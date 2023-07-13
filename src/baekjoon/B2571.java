package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2571 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[][] paper = new int[101][101];
    for (int i = 0; i < 101; i++) {
      Arrays.fill(paper[i], -10001);
    }

    for (int i = 0; i < n; i++) {
      int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

      for (int j = input[0]; j < input[0]+ 10; j++) {
        for (int k = input[1]; k < input[1] + 10; k++) {
          paper[k][j] = 1;
        }
      }
    }

    int[][] sum = new int[101][101];

    for (int i = 1; i < 101; i++) {
      for (int j = 1; j < 101; j++) {
        sum[i][j] = paper[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
      }
    }

    int answer = 0;
    for (int i = 1; i < 101 ; i++) {
      for (int j = 1; j < 101; j++) {
        for (int ib = i+1; ib < 101; ib++) {
          for (int jb = j+1; jb < 101; jb++) {
            int area = sum[ib][jb] - sum[i - 1][jb] - sum[ib][j - 1] + sum[i - 1][j - 1];
            if(area<0) break;
            answer = Math.max(answer, area);
          }
        }
      }

    }

    System.out.println(answer);
  }

}
