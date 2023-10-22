package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1461 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nm = br.readLine().split(" ");

    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);

    String[] input = br.readLine().split(" ");
    int positiveCount = 0;
    int negativeCount = 0;

    int max = 0;
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(input[i]);
      if (num > 0) {
        positiveCount++;
      } else {
        negativeCount++;
      }

      if (Math.abs(num) > Math.abs(max)) {
        max = num;
      }

      arr[i] = num;
    }
    Arrays.sort(arr);
    int answer = 0;

    if (max < 0) {
      for (int i = negativeCount; i < n; i += m) {
        int remain = (n - i) % m;
        if (i + m >= n) {
          answer += arr[n - 1] * 2;
          break;
        }
        if (remain != 0) {
          answer += arr[i + remain - 1] * 2;
          i -= m - remain;
          continue;
        } else {
          answer += arr[i + m - 1] * 2;
        }
      }

      for (int i = negativeCount - 1; i >= 0; i -= m) {
        int remain = (i + 1) % m;
        if (i - m + 1 <= 0) {
          answer += Math.abs(arr[0]);
          break;
        }
        if (remain != 0) {
          answer += Math.abs(arr[i - remain + 1]) * 2;
          i += m - remain;
          continue;
        } else {
          answer += Math.abs(arr[i - m + 1]) * 2;
        }
      }

    } else {
      for (int i = negativeCount - 1; i >= 0; i -= m) {
        int remain = (i + 1) % m;
        if (i - m + 1 <= 0) {
          answer += Math.abs(arr[0]) * 2;
          break;
        }
        if (remain != 0) {
          answer += Math.abs(arr[i - remain + 1]) * 2;
          i += m-remain;
          continue;
        } else {
          answer += Math.abs(arr[i - m + 1]) * 2;
        }
      }

      for (int i = negativeCount; i < n; i += m) {
        int remain = (n - i) % m;
        if (i + m >= n) {
          answer += arr[n - 1];
          break;
        }
        if (remain != 0) {
          answer += arr[i + remain - 1] * 2;
          i -= m - remain;
          continue;
        } else {
          answer += arr[i + m - 1] * 2;
        }
      }
    }

    System.out.println(answer);
  }
}
