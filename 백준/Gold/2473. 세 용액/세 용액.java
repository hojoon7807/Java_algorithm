import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static int n;
  static long[] arr;
  static long min = Long.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    arr = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .sorted()
                .toArray();

    long v1 = 0, v2 = 0, v3 = 0;

    for (int i = 0; i < n - 2; i++) {
      long target = arr[i];
      int left = i + 1;
      int right = n - 1;
      while (left < right) {
        long sum = Math.abs(target + arr[left] + arr[right]);

        if (sum == 0) {
          System.out.println(target + " " + arr[left] + " " + arr[right]);
          return;
        }

        if (min > sum) {
          min = sum;
          v1 = target;
          v2 = arr[left];
          v3 = arr[right];
        }

        if (arr[left] + arr[right] > -target) {
          right--;
        } else {
          left++;
        }
      }
    }

    System.out.println(v1 + " " + v2 + " " + v3);
  }
}
