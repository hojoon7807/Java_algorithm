package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B1697 {

  static int end = 100000;
  static boolean[] isVisited = new boolean[100001];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nk = br.readLine().split(" ");
    int n = Integer.parseInt(nk[0]);
    int k = Integer.parseInt(nk[1]);

    LinkedList<int[]> q = new LinkedList();

    q.add(new int[]{n, 0});

    while (!q.isEmpty()) {
      int[] recent = q.poll();
      if (recent[0] == k) {
        System.out.println(recent[1]);
        return;
      }

      for (int i = 0; i < 3; i++) {
        int next = -1;
        switch (i) {
          case 0:
            next = recent[0] - 1;
            break;
          case 1:
            next = recent[0] + 1;
            break;
          case 2:
            next = recent[0] * 2;
            break;
          default:
            break;
        }

        if (next >= 0 && next <= end && !isVisited[next]) {
          q.add(new int[]{next, recent[1] + 1});
          isVisited[next] = true;
        }
      }
    }

  }

}
