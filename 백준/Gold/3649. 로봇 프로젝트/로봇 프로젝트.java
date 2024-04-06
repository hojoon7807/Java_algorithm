import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  /*
  투포인터 풀이
  앞서 풀었던 두 용액처럼 양 끝부터 합을 비교하며 구한다
   */

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int target;
  static int x, n;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();

    String input = "";
    while((input = br.readLine()) != null && !input.isEmpty()){
      x = Integer.parseInt(input);
      n = Integer.parseInt(br.readLine());

      target = x * 10000000;
      arr = new int[n];

      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(br.readLine());
      }

      Arrays.sort(arr);

      int left = 0;
      int right = n - 1;

      boolean flag = false;
      while (left < right) {
        int sum = arr[left] + arr[right];

        if (sum == target) {
          sb.append("yes").append(" ").append(arr[left]).append(" ").append(arr[right]).append("\n");
          flag = true;
          break;
        }

        if (sum < target) {
          left++;
        } else {
          right--;
        }
      }

      if(!flag) {
        sb.append("danger").append("\n");
      }
    }

    System.out.println(sb);
  }


}
