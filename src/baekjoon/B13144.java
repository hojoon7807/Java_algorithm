package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B13144 {

  static int n;
  static int[] arr;
  static int[] count = new int[100000 + 1];
  static long answer = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    arr = new int[n];

    String[] input = br.readLine().split(" ");

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }
    // 1 2 3 4 5
    // 1 1 2 1 2 3 -> 1 11 112 1121 11212 112123 / 12 121 1212 12123 / 2 21 212 2123 / 123 / 23 / 3 = 17
    // 1 -> 12 -> 21 -> 123 -> 23 -> 3
    // 6 + 5 + 4 + 3

    // 1 2 3 1 2 -> 123, 231, 312, 12, 1

    solution();
    System.out.println(answer);
  }

  static void solution() {
    int right = 0;
    for (int i = 0; i < n; i++) {
      while (right < n && count[arr[right]] == 0) {
        count[arr[right]]++;
        right++;
      }

      answer += right - i;
      count[arr[i]]--;
    }
  }

}
