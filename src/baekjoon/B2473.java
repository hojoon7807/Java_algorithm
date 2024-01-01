package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2473 {

  static int n;
  static int[] arr;
  static Long min = Long.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //5
    //-2 6 -97 -6 98 -> -97 -6 -2 6 98
    n = Integer.parseInt(br.readLine());
    arr = new int[n];

    String[] input = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }

    solution();
  }

  static void solution() {
    Arrays.sort(arr);
    long v1 = 0, v2 = 0, v3 = 0;
    for (int i = 0; i < n - 2; i++) {
      long target = arr[i];
      int left = i + 1;
      int right = n - 1;
      while (left < right) {
        long sum = Math.abs(target + arr[left] + arr[right]);
        if (min > sum) {
          min = sum;
          v1 = target;
          v2 = arr[left];
          v3 = arr[right];
        }

        if (arr[left] + arr[right] > -target) {
          right--;
        } else {
          left++;
        }
      }
    }

    System.out.println(v1 + " " + v2 + " " + v3);
  }

}
