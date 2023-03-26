package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2018 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int sum = 1, startIndex = 1, endIndex = 1, count = 1;

    while (endIndex != N) {
      if (sum == N) {
        endIndex++;
        sum += endIndex;
        count++;
      } else if (sum > N) {
        sum -= startIndex;
        startIndex++;
      } else if (sum < N) {
        endIndex++;
        sum += endIndex;
      }
    }
    System.out.println(count);
  }
}
