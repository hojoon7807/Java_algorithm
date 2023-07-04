package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class B19598 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[][] arr = new int[n][2];
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      arr[i] = info;
    }
    Arrays.sort(arr, ((o1, o2) -> {
      if (o1[0] == o2[0]) {
        return o1[1] - o2[1];
      }
      return o1[0] - o2[0];
    }));


    pq.add(arr[0][1]);

    int count = 0;

    for (int i = 1; i < n; i++) {
      while (!pq.isEmpty() && pq.peek() <= arr[i][0]) {
        pq.poll();
      }
      pq.add(arr[i][1]);
      count = Math.max(count, pq.size());
    }

    System.out.println(count);
  }


}
