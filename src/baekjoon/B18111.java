package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B18111 {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] NMB = br.readLine().split(" ");

      int n = Integer.parseInt(NMB[0]);
      int m = Integer.parseInt(NMB[1]);
      int b = Integer.parseInt(NMB[2]);

      int[][] map = new int[n][m];
      int total = b;
      for (int i = 0; i < n; i++) {
        String[] input = br.readLine().split(" ");
        for (int j = 0; j < m; j++) {
          map[i][j] = Integer.parseInt(input[j]);
          total += map[i][j];
        }
      }

      int height = (total) / (n * m);
      if (height > 256) height = 256;
      System.out.println(height);
      int minTime = Integer.MAX_VALUE;
      int answer = height;

      while (height >= 0) {
        int currentTime = 0;
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
            if (map[i][j] <= height)
              currentTime += (height - map[i][j]);
            else
              currentTime += (2 * (map[i][j] - height));
          }
        }
        if (currentTime < minTime) {
          minTime = currentTime;
          answer = height;
        }
        height--;

      }
      System.out.println(minTime + " " + answer);
    }
}
