package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B3273 {

  static int n, x;
  static int[] arr;
  static int answer = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    arr = new int[n];

    String[] input = br.readLine().split(" ");

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }

    x = Integer.parseInt(br.readLine());

    solution();
    System.out.println(answer);
  }

  static void solution() {
    Arrays.sort(arr);

    int left = 0, right = n-1;
    // 1 2 3 5 7 9 10 11 12
    while (left < right) {
      int lV = arr[left];
      int rV = arr[right];

      int sum = lV + rV;

      if (sum == x) {
        answer++;
        right--;
      } else if (sum > x) {
        right--;
      } else {
        left++;
      }
    }
  }

}
