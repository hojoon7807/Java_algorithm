package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class B23843 {

  static int N, M;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    N = Integer.parseInt(input[0]);
    M = Integer.parseInt(input[1]);

    arr = new int[N];

    input = br.readLine().split(" ");

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }

    Arrays.sort(arr);

    // 1 9 9, 1 9, 0 8, 8 9, 10
    // 8 4 4 1 1,

    PriorityQueue<Integer> charge = new PriorityQueue<>();

    for (int i = N - 1; i >= 0; i--) {
      if (charge.size() < M) {
        charge.add(arr[i]);
      } else {
        Integer end = charge.poll();
        charge.add(arr[i] + end);
      }
    }

    int max = 0;

    while (!charge.isEmpty()) {
      max = Math.max(max, charge.poll());
    }

    System.out.println(max);
  }

}
