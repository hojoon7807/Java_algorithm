package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B25635 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    String[] input = br.readLine().split(" ");

    long sum = 0;
    int max = 0;

    for (int i = 0; i < n; i++) {
      int value = Integer.parseInt(input[i]);
      max = Math.max(max, value);
      sum += value;
    }

    sum -= max;

    if (sum + 1 < max) {
      sum += sum + 1;
    } else {
      sum += max;
    }
    System.out.println(sum);
  }
}
