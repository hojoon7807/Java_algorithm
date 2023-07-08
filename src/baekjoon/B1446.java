package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class B1446 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int d = Integer.parseInt(input[1]);

    int[] distance = new int[d + 1];
    Arrays.fill(distance, d);
    ArrayList<ArrayList<int[]>> fastRoad = new ArrayList<>();

    for (int i = 0; i <= d; i++) {
      fastRoad.add(new ArrayList<>());
    }

    for (int i = 0; i < n; i++) {
      input = br.readLine().split(" ");
      int start = Integer.parseInt(input[0]);
      int end = Integer.parseInt(input[1]);
      int len = Integer.parseInt(input[2]);

      if (end > d) {
        continue;
      }

      if (end - start < len) {
        continue;
      }

      fastRoad.get(end).add(new int[]{start, len});
    }

    distance[0] = 0;

    for (int i = 1; i <= d; i++) {
      if (fastRoad.get(i).size() == 0) {
        distance[i] = distance[i-1] + 1;
      } else {
        for (int[] fast : fastRoad.get(i)) {
          distance[i] = Math.min(distance[i],
              Math.min(distance[i - 1] + 1, distance[fast[0]] + fast[1]));
        }
      }
    }

    System.out.println(distance[d]);
  }

}
