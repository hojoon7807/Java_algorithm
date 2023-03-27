package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1940 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    int[] nums = new int[N];

    String[] split = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(split[i]);
    }

    Arrays.sort(nums);
    int startIndex = 0;
    int endIndex = N - 1;
    int count = 0;
    while (startIndex < endIndex) {
      int sum = nums[startIndex] + nums[endIndex];
      if (sum == M) {
        count ++;
        startIndex ++;
      } else if (sum > M) {
        endIndex --;
      } else if (sum < M) {
        startIndex ++;
      }
    }

    System.out.println(count);
  }

}
