package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2470 {

  static int n;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    arr = new int[n];

    String[] input = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }

    Arrays.sort(arr);
    int min = Integer.MAX_VALUE;

    int v1 = 0, v2 = 0;
    for (int i = 0; i < n - 1; i++) {
      int candidate = search(i, n - 1, -arr[i]);

      if (i < candidate - 1 && Math.abs(arr[i] + arr[candidate - 1]) < min) {
        min = Math.abs(arr[i] + arr[candidate - 1]);
        v1 = arr[i];
        v2 = arr[candidate - 1];
      }

      int sum = Math.abs(arr[i] + arr[candidate]);
      if (min > sum) {
        min = sum;
        v1 = arr[i];
        v2 = arr[candidate];
      }
    }

    System.out.println(v1 + " " + v2);
    //5
    //-2 4 -99 -1 98
    // -99 -2 -1 4 98

  }

  static int search(int left, int right, int value) {
    while (left + 1 < right) {
      int mid = (left + right) >> 1;

      if (!(arr[mid] >= value)) {
        left = mid;
      } else {
        right = mid;
      }
    }

    return right;
  }
}
