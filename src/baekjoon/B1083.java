package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1083 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int s = Integer.parseInt(br.readLine());

    for (int i = 0; i < n - 1; i++) {
      if (s <= 0) {
        break;
      }
      int maxValue = arr[i];
      int maxIndex = i;

      for (int j = i + 1; j <= i + s; j++) {
        if (j >= n) {
          break;
        }
        if (maxValue < arr[j]) {
          maxIndex = j;
          maxValue = arr[j];
        }
      }

      if (i == maxIndex) {
        continue;
      }

      for (int j = maxIndex - 1; j >= i; j--) {
        arr[j + 1] = arr[j];
      }

      arr[i] = maxValue;
      s -= maxIndex - i;
    }

    StringBuilder sb = new StringBuilder();
    for (int i : arr) {
      sb.append(i).append(" ");
    }

    System.out.println(sb);
  }
}
