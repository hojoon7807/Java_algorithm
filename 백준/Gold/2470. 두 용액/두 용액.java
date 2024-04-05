import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static int n;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    arr = new int[n];

    String[] input = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }

    Arrays.sort(arr);
    int min = Integer.MAX_VALUE;

    int left = 0;
    int right = n - 1;

    int v1 = -1;
    int v2 = -1;

    while (left < right) {
      int sum = arr[left] + arr[right];

      if (sum == 0) {
        System.out.println(arr[left] + " " + arr[right]);
        return;
      }

      if (min > Math.abs(sum)) {
        min = Math.abs(sum);
        v1 = arr[left];
        v2 = arr[right];
      }

      if (sum < 0) {
        left++;
      } else {
        right--;
      }
    }

    System.out.println(v1 + " " + v2);
  }
}
