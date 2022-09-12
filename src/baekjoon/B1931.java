package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1931 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int count = 0;
    int recent = 0;
    int[][] times = new int[N][2];

    for (int i = 0; i < N; i++) {
      String[] I = br.readLine().split(" ");
      int start = Integer.parseInt(I[0]);
      int end = Integer.parseInt(I[1]);

      times[i] = new int[]{start, end};
    }

    Arrays.sort(times, (o1, o2) -> {
          if (o1[1] == o2[1]) {
            return o1[0] - o2[0];
          }
          return o1[1] - o2[1];
        }
    );

    for (int i = 0; i < N; i++) {
      if(times[i][0]>=recent) {
        count++;
        recent = times[i][1];
      }
    }

    System.out.println(count);
  }
}
