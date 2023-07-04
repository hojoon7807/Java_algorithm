package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B1689 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[][] arr = new int[n][2];

    for (int i = 0; i < n; i++) {
      arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

    int count = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.add(arr[0][1]);
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
