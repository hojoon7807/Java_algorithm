package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B2606 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] links = new int[n+1][n+1];

    boolean[] isVisited = new boolean[n+1];
    int link = Integer.parseInt(br.readLine());
    for (int i = 0; i < link; i++) {
      String[] s = br.readLine().split(" ");
      int first = Integer.parseInt(s[0]);
      int second = Integer.parseInt(s[1]);

      links[first][second] = second;
      links[second][first] = first;
    }

    LinkedList<Integer> queue = new LinkedList<>();
    queue.add(1);
    isVisited[1] = true;

    int count = 0;

    while (!queue.isEmpty()) {
      Integer recent = queue.poll();

      int[] arr = links[recent];

      for (int i : arr) {
        if (i == 0) {
          continue;
        }
        if (!isVisited[i]) {
          queue.add(i);
          isVisited[i] = true;
          count ++;
        }
      }
    }

    System.out.println(count);
  }

}
