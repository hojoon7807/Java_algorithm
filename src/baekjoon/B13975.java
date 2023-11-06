package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B13975 {

  static int t, k;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < t; i++) {
      k = Integer.parseInt(br.readLine());

      PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.naturalOrder());

      long sum = 0;
      String[] input = br.readLine().split(" ");
      for (int j = 0; j < k; j++) {
        pq.add(Long.parseLong(input[j]));
      }

      // 1 3 3 4 4 5 5 5 14 17 21 21 32 35 98
      // 3 4 4 4 5 5 5 14 17 21 21 32 35 98 /4
      // 4 4 5 5 5 7 14 17 21 21 32 35 98 / 11
      // 5 5 5 7 8 14 17 21 21 32 35 98 / 19
      // 5 7 8 10 14 17 21 21 32 35 98 / 29
      // 8 10 12 14 17 21 21 32 35 98 / 41
      // 12 14 17 18 21 21 32 35 98 / 59
      // 17 18 21 21 26 32 35 98 / 85
      // 21 21 26 32 35 35 98 / 120
      // 26 32 35 35 42 98 / 162
      // 35 35 42 58 98 / 220
      // 42 58 70 98 / 290
      // 70 98 100 / 390
      // 100 168 / 558
      // 268 / 826
      // 1 2 3 -> 3 3 -> 6

      for (int j = 0; j < k - 1; j++) {
        Long a = pq.poll();
        Long b = pq.poll();

        Long tmp = Long.sum(a,b);
        sum = Long.sum(sum, tmp);
        pq.add(tmp);
      }

      sb.append(sum).append("\n");
    }

    System.out.println(sb);
  }

}
