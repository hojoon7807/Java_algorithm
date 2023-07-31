package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2166 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long[][] arr = new long[n][2];

    for (int i = 0; i < n; i++) {
      arr[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
    }

    long area = 0;
    int j = n - 1;

    for (int i = 0; i < n; i++) {
      area += (arr[i][0] + arr[j][0]) * (arr[i][1] - arr[j][1]);
      j = i;
    }


    double answer = Math.abs(area)/2.0;
    System.out.printf("%.1f", answer);
  }

}
