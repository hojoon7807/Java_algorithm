package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2805 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] NM = br.readLine().split(" ");
    int N = Integer.parseInt(NM[0]);
    int M = Integer.parseInt(NM[1]);

    long max = Integer.MIN_VALUE;
    long min = 0;
    String[] input = br.readLine().split(" ");
    int[] trees = new int[N];

    for (int i = 0; i < N; i++) {
      trees[i] = Integer.parseInt(input[i]);

      max = Math.max(max, Integer.parseInt(input[i]));
    }

    while (max >= min) {
      long mid = (max + min) / 2;

      long sum = 0;

      for (int i = 0; i < N; i++) {
        if (trees[i] - mid < 0) {
          continue;
        }
        sum += trees[i] - mid;
      }

      if (sum >= M) {
        min = mid + 1;
      } else {
        max = mid - 1;
      }
    }

    System.out.println(min-1);
  }

}
