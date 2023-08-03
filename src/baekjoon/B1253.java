package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1253 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    Arrays.sort(arr);

    int count = 0;
    for (int i = 0; i < n; i++) {
      int pin = arr[i];
      int start = 0;
      int end = n - 1;
      while (start < end) {
        if (start == i) {
          start++;
          continue;
        } else if (end == i) {
          end--;
          continue;
        }

        int sum = arr[start] + arr[end];

        if (pin == sum) {
          count++;
          break;
        }

        if (sum > pin) {
          end--;
        } else {
          start++;
        }
      }
    }

    System.out.println(count);
  }

}
