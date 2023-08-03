package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B2212 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());

    int[] sensors = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    Arrays.sort(sensors);

    if (k >= n) {
      System.out.println(0);
      return;
    }

    int answer = sensors[n-1] - sensors[0];

    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    for (int i = 0; i < n - 1; i++) {
      pq.add(sensors[i + 1] - sensors[i]);
    }

    for (int i = 0; i < k - 1; i++) {
      answer -= pq.poll();
    }

    System.out.println(answer);
  }

}
