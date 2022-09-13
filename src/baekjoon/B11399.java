package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11399 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] times = new int[N];

    String[] s = br.readLine().split(" ");

    for (int i = 0; i < N; i++) {
      times[i] = Integer.parseInt(s[i]);
    }

    Arrays.sort(times);

    int sum = 0;
    int result = 0;

    for (int i = 0; i < N; i++) {
      sum += times[i];
      result += sum;
    }

    System.out.println(result);
  }
}
