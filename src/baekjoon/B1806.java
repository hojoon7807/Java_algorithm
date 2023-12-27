package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1806 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] ns = br.readLine().split(" ");
    int n = Integer.parseInt(ns[0]);
    int s = Integer.parseInt(ns[1]);

    int[] arr = new int[n];

    String[] input = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }

    int right = 0;

    int sum = 0;
    int min = Integer.MAX_VALUE;

    for (int left = 0; left < n; left++) {
      while (right < n && sum < s) {
        sum += arr[right];
        right++;
      }

      if (sum >= s) {
        min = Math.min(min, right - left);
      }

      if (min == 1) {
        System.out.println(min);
        return;
      }

      sum -= arr[left];
    }

    System.out.println(min == Integer.MAX_VALUE ? 0 : min);
  }

}
