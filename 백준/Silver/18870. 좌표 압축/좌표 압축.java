
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  /*
  - -1,000,000,000<=xi<=1,000,000,000 => int ok
  - n이 최대 1,000,000 이므로 o(n^2) 풀이는 불가능
  - 중복된 개수는 제외해야된다.
  - 이분탐색 이용
  - x[i] > sortedX[mid] = true
  - |TTTTT/FFFFFF| left


   */
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static int[] x;
  static int[] sortedX;

  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());
    x = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    sortedX = Arrays.stream(x).sorted().distinct().toArray();

    StringBuilder sb = new StringBuilder();

    for (int v : x) {
      int count = binarySearch(v) + 1;
      sb.append(count).append(" ");
    }

    System.out.println(sb);
  }

  static int binarySearch(int v) {
    int left = -1;
    int right = sortedX.length;

    while (left + 1 < right) {
      int mid = (left + right) >> 1;

      if (v > sortedX[mid]) {
        left = mid;
      } else {
        right = mid;
      }
    }

    return left;
  }

}
