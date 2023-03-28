package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B3665 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder answer = new StringBuilder();

    while (T > 0) {
      int N = Integer.parseInt(br.readLine());
      String[] split = br.readLine().split(" ");
      boolean[][] team = new boolean[N][N];

      int[] inDegree = new int[N];
      for (int i = 0; i < N; i++) {
        int periodA = Integer.parseInt(split[i]) - 1;
        inDegree[periodA] = i;
        for (int j = i + 1; j < N; j++) {
          int periodB = Integer.parseInt(split[j]) - 1;
          team[periodA][periodB] = true;
        }
      }
      int M = Integer.parseInt(br.readLine());

      for (int i = 0; i < M; i++) {
        String[] ab = br.readLine().split(" ");
        int a = Integer.parseInt(ab[0]) - 1;
        int b = Integer.parseInt(ab[1]) - 1;

        if (team[a][b]) {
          team[a][b] = false;
          team[b][a] = true;
          inDegree[a]++;
          inDegree[b]--;
        } else {
          team[b][a] = false;
          team[a][b] = true;
          inDegree[a]--;
          inDegree[b]++;
        }
      }

      String result = sort(N, team, inDegree);
      answer.append(result + "\n");
      T--;
    }
    System.out.println(answer);
  }

  static private String sort(int N, boolean[][] team, int[] inDegree) {
    LinkedList<Integer> queue = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < N; i++) {
      if (inDegree[i] == 0) {
        queue.add(i);
      }
    }
    for (int loop = 0; loop < N; loop++) {
      if (queue.size() > 1) {
        return "?";
      }

      if (queue.isEmpty()) {
        return "IMPOSSIBLE";
      }

      Integer recent = queue.poll();
      sb.append(recent + 1).append(" ");
      for (int i = 0; i < N; i++) {
        if (team[recent][i]) {
          if (--inDegree[i] == 0) {
            queue.add(i);
          }
        }
      }
    }
    return sb.toString();
  }
}
