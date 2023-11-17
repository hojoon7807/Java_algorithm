package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B7795 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      String[] nm = br.readLine().split(" ");
      int n = Integer.parseInt(nm[0]);
      int m = Integer.parseInt(nm[1]);

      int[] a = new int[n];
      int[] b = new int[m];

      String[] input = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        a[j] = Integer.parseInt(input[j]);
      }

      input = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        b[j] = Integer.parseInt(input[j]);
      }

      int answer = solution(a, b);

      sb.append(answer).append("\n");
    }

    System.out.println(sb);
  }

  static int solution(int[] a, int[] b) {
    int count = 0;
    Arrays.sort(b);
    for (int value : a) {
      count += search(b, value);
    }

    return count;
  }

  static int search(int[] b, int value) {
    int start = 0;
    int end = b.length -1 ;

    while (start <= end) {
      int mid = (start + end) >> 1;

      if (b[mid] < value) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return start;
  }

}
