package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1561 {

  static long N;
  static int M;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NM = br.readLine().split(" ");
    N = Integer.parseInt(NM[0]);
    M = Integer.parseInt(NM[1]);

    String[] times = br.readLine().split(" ");
    arr = new int[M];

    int maxTime = 0;
    for (int i = 0; i < M; i++) {
      arr[i] = Integer.parseInt(times[i]);
      maxTime = Math.max(maxTime, arr[i]);
    }

    if (N <= M) {
      System.out.println(N);
      return;
    }

    long end = N * 30;
    long start = 0;

    while (start <= end) {
      long mid = (start + end) / 2;
      long recent = getNum(mid);

      if (recent < N) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    long recent = getNum(start - 1);

    for (int i = 0; i < M; i++) {
      if (start % arr[i] == 0) {
        recent++;
      }
      if (recent == N) {
        System.out.println(i + 1);
        return;
      }
    }
  }

  private static long getNum(long time) {
    long sum = M;
    for (int i = 0; i < M; i++) {
      sum += time / arr[i];
    }

    return sum;
  }
}
