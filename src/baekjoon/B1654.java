package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1654 {
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NK = br.readLine().split(" ");
    int K = Integer.parseInt(NK[0]);
    int N = Integer.parseInt(NK[1]);

    int[] lines = new int[K];
    long max = Integer.MIN_VALUE;
    for (int i = 0; i < K; i++) {
      int length = Integer.parseInt(br.readLine());
      lines[i] = length;

      max = Math.max(length, max);
    }

    long min = 1;

    while (max >= min) {
      long mid = (max+min)/2;

      int count = 0;

      for (int i = 0; i < K; i++) {
        count += lines[i] / mid;
      }

      if (count >= N) {
        min = mid + 1;
      }else{
        max = mid - 1;
      }
    }

    System.out.println(min-1);
  }

}
