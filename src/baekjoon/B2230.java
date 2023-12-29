package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2230 {

  static int n, m;
  static int[] arr;
  static int answer = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nm = br.readLine().split(" ");
    n = Integer.parseInt(nm[0]);
    m = Integer.parseInt(nm[1]);

    arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    solution();
    System.out.println(answer);
  }

  private static void solution() {
    Arrays.sort(arr);

    // 1 1 1 2 4 5 7 8
    // 1
    int left = 0;
    int right = 0;

    while (left < n && right < n) {
      int lValue = arr[left];
      int rValue = arr[right];

      int diff = Math.abs(rValue - lValue);

      if (diff < m) {
        right++;
      } else {
        answer = Math.min(answer, diff);
        left++;
      }
    }
  }

}
