package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B16928 {

  static int[] map = new int[101];
  static boolean[] isVisited = new boolean[101];
  static int[] count = new int[101];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] strings = br.readLine().split(" ");

    int N = Integer.parseInt(strings[0]);
    int M = Integer.parseInt(strings[1]);

    for (int i = 0; i < N; i++) {
      String[] xy = br.readLine().split(" ");

      map[Integer.parseInt(xy[0])] = Integer.parseInt(xy[1]);
    }

    for (int i = 0; i < M; i++) {
      String[] uv = br.readLine().split(" ");

      map[Integer.parseInt(uv[0])] = Integer.parseInt(uv[1]);
    }

    bfs();
  }

  static void bfs() {
    LinkedList<Integer> queue = new LinkedList<>();
    queue.add(1);

    while (!queue.isEmpty()) {
      int recent = queue.remove();

      for (int j = 1; j < 7; j++) {
        int next = recent + j;

        if (next == 100) {
          System.out.println(count[recent] + 1);
          return;
        }

        if (next < 101 && count[next] == 0) {
          if (map[next] != 0 && count[map[next]] == 0) {
            queue.add(map[next]);
            count[map[next]] = count[recent] + 1;
          } else if(map[next] == 0){
            count[next] = count[recent] + 1;
            queue.add(next);
          }
        }
      }
    }
  }

}
