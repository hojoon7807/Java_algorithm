package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B3108 {

  private static class Rec {

    int x1;
    int y1;
    int x2;
    int y2;

    public Rec(int x1, int y1, int x2, int y2) {
      this.x1 = x1;
      this.y1 = y1;
      this.x2 = x2;
      this.y2 = y2;
    }

  }

  static Rec[] map;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    map = new Rec[N + 1];
    boolean[] isVisited = new boolean[N + 1];
    map[0] = new Rec(0, 0, 0, 0);

    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      map[i] = new Rec(x1, y1, x2, y2);
    }
    int count = 0;

    for (int i = 0; i <=N; i++) {
      if(isVisited[i]) continue;
      LinkedList<Integer> queue = new LinkedList<>();
      queue.add(i);

      while (!queue.isEmpty()) {
        int current = queue.poll();

        for (int j = 0; j <= N; j++) {
          if (current != j && !isVisited[j] && check(current, j)) {
            isVisited[j] = true;
            queue.add(j);
          }
        }
      }
      count ++;
    }


    System.out.println(count - 1);
  }

  private static boolean check(int current, int next) {
    Rec currentRec = map[current];
    Rec nextRec = map[next];

    if((currentRec.x1 < nextRec.x1 && nextRec.x2 < currentRec.x2 && currentRec.y1 < nextRec.y1 && nextRec.y2 < currentRec.y2)
        || (currentRec.x1 > nextRec.x1 && nextRec.x2 > currentRec.x2 && currentRec.y1 > nextRec.y1 && nextRec.y2 > currentRec.y2)
        || currentRec.x2 < nextRec.x1 || currentRec.x1 > nextRec.x2 || currentRec.y2 < nextRec.y1 || currentRec.y1 > nextRec.y2 )
      return false;

    return true;
  }
}

