package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2003 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);

    int[] arr = new int[n];

    input = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }

    int end = 0;
    int count = 0;

    int sum = 0;

    for (int start = 0; start < n; start++) {
      if (start != 0) {
        sum -= arr[start - 1];
      }

      while (end < n && sum < m) {
        sum += arr[end];
        end++;
      }

      if (sum == m) {
        count++;
      }
    }

    System.out.println(count);
  }

}
