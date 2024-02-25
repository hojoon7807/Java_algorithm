package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B2623 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n,m;
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static int[] inDegree;

  public static void main(String[] args) throws IOException{
    input();
    solution();
  }

  static void solution(){
    LinkedList<Integer> q = new LinkedList<>();
    for(int i=1; i<=n; i++){
      if (inDegree[i] == 0) {
        q.add(i);
      }
    }

    StringBuilder sb = new StringBuilder();

    int count = 0;
    while (!q.isEmpty()) {
      Integer cur = q.poll();
      sb.append(cur).append("\n");
      count++;
      for (Integer next : graph.get(cur)) {
        if (--inDegree[next] == 0) {
          q.add(next);
        }
      }
    }

    if (count != n) {
      System.out.println(0);
    } else {
      System.out.println(sb);
    }
  }

  static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    inDegree = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      String[] split = br.readLine().split(" ");

      int count = Integer.parseInt(split[0]);
      for(int j=2; j<=count; j++){
        int a = Integer.parseInt(split[j - 1]);
        int b = Integer.parseInt(split[j]);

        inDegree[b]++;

        graph.get(a).add(b);
      }
    }
  }
}
