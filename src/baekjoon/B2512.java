package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2512 {

  static int n, m;
  static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    arr = new int[n];

    String[] input = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }

    m = Integer.parseInt(br.readLine());

    Arrays.sort(arr);

    int start = 0;
    int end = arr[n - 1];

    int answer = 0;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (check(mid)) {
        answer = mid;
        start = mid +1;
      } else {
        end = mid-1;
      }
    }

    System.out.println(answer);
  }

  static boolean check(int max) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] > max) {
        sum += max;
      } else{
        sum += arr[i];
      }
    }

    return sum <= m;
  }

}
