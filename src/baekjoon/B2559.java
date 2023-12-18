package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2559 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nk = br.readLine().split(" ");

    int n = Integer.parseInt(nk[0]);
    int k = Integer.parseInt(nk[1]);

    int[] arr = new int[n];

    String[] input = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }

    int max = 0;

    for (int i = 0; i < k; i++) {
      max += arr[i];
    }

    int sum = max;

    int start = 0;

    while (start < n - k) {
      sum -= arr[start++];
      sum += arr[start + k-1];

      max = Math.max(sum, max);
    }

    System.out.println(max);
  }

}
