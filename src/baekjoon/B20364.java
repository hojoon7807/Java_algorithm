package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B20364 {
  static int n,q;
  static StringBuilder sb = new StringBuilder();
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static boolean[] isVisited;

  public static void main(String[] args) throws IOException {
    String[] nq = br.readLine().split(" ");
    n = Integer.parseInt(nq[0]);
    q = Integer.parseInt(nq[1]);

    isVisited = new boolean[n+1];
    solution();
  }

  static void solution() throws IOException {

    for (int i = 0; i < q; i++) {
      int x = Integer.parseInt(br.readLine());
      canMove(x);
    }

    System.out.println(sb);
  }

  static void canMove(int x){
    int to = x;
    int lastIndex = -1;
    while (to > 0) {
      if (isVisited[to]) {
        lastIndex = to;
      }

      to /= 2;
    }

    if (lastIndex != -1) {
      sb.append(lastIndex).append("\n");
    } else {
      isVisited[x] = true;
      sb.append("0").append("\n");
    }
  }

}
