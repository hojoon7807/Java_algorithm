package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B2251 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] water = br.readLine().split(" ");
    int[] amount =  new int[3];

    for (int i = 0; i < 3; i++) {
      amount[i] = Integer.parseInt(water[i]);
    }
    int c = Integer.parseInt(water[2]);
    boolean[][] isVisited = new boolean[c + 1][c + 1];
    boolean[] answer = new boolean[c + 1];
    LinkedList<int[]> queue = new LinkedList<>();

    queue.add(new int[]{0,0,c});
    isVisited[0][0] = true;

    while (!queue.isEmpty()) {
      int[] recent = queue.poll();
      if (recent[0] == 0) {
        answer[recent[2]] = true;
      }

      for (int from = 0; from < 3; from++) {
        for (int to = 0; to < 3; to++) {
          if (from != to) {
            int[] next = new int[]{recent[0], recent[1], recent[2]};
            next[to] += next[from];
            next[from] = 0;
            if (next[to] > amount[to]) {
              next[from] = next[to] - amount[to];
              next[to] = amount[to];
            }

            if (!isVisited[next[0]][next[1]]) {
              queue.add(new int[]{next[0], next[1], c - next[0] - next[1]});
              isVisited[next[0]][next[1]] = true;
            }
          }
        }
      }
    }

    for (int i = 0; i < c+1; i++) {
      if (answer[i]) {
        System.out.print(i+" ");
      }
    }
  }

}
