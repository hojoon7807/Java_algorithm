package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1253 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] nums = new int[N];

    String[] split = br.readLine().split(" ");

    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(split[i]);
    }
    Arrays.sort(nums);

    int count = 0;
    for (int i = 0; i < N; i++) {
      int tmp = nums[i];
      int start = 0;
      int end = N - 1;

      while (start < end) {
        if (start == i) {
          start++;
          continue;
        } else if (end == i) {
          end--;
          continue;
        }
        int sum = nums[start] + nums[end];

        if (sum == tmp) {
          count++;
          break;
        } else if (sum > tmp) {
          end--;
        } else if (sum < tmp) {
          start++;
        }
      }
    }

    System.out.println(count);
  }

}
