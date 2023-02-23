package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B20922 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] split = br.readLine().split(" ");

    int N = Integer.parseInt(split[0]);
    int K = Integer.parseInt(split[1]);

    int[] arr = new int[N];

    String[] a = br.readLine().split(" ");

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(a[i]);
    }
    int maxResult = 0;

    int start = 0;
    int end = 0;
    int[] count = new int[100001];

    while (start <= end) {
      if(count[arr[end]] == K) {
        count[arr[start]]--;
        start ++;
      } else if (end <= N - 1 && count[arr[end]] < K) {
        count[arr[end]] ++;
        end ++;
      }

      maxResult = Math.max(maxResult, end - start);

      if (end == N) {
        break;
      }
    }

    System.out.println(maxResult);
  }
}
