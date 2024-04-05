import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  /*
  최대 걸리는 시간 time의 최대값 * m
  1 ~ 최대값 범위를 이분 탐색을 돌며 심사가 완료된 최솟값을 찾는다.
  sum += mid / time[i];
   */

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static long m;
  static long[] time;

  public static void main(String[] args) throws IOException {
    String[] nm = br.readLine().split(" ");
    n = Integer.parseInt(nm[0]);
    m = Long.parseLong(nm[1]);

    time = new long[n];

    for (int i = 0; i < n; i++) {
      time[i] = Long.parseLong(br.readLine());
    }

    Arrays.sort(time);

    long left = 0;
    long right = time[n-1] * m;

    while (left + 1 < right) {
      long mid = (left + right) >> 1;

      if(check(mid)) {
        right = mid;
      } else {
        left = mid;
      }
    }

    System.out.println(right);
  }

  static boolean check (long mid){
    long sum = 0;

    for (long t : time) {
      sum += mid / t;

      if (sum >= m) {
        return true;
      }
    }

    return false;
  }

}
