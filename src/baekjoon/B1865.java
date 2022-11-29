package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class B1865 {

  private static class Node {

    int to;
    int w;

    public Node(int to, int w) {
      this.to = to;
      this.w = w;
    }
  }

  static int N, M;
  static StringBuilder sb = new StringBuilder();
  static ArrayList<ArrayList<Node>> graph;

  static final int INF = 987654321;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int TC = Integer.parseInt(br.readLine());

    while (TC-- > 0) {
      String[] NMW = br.readLine().split(" ");
      N = Integer.parseInt(NMW[0]);
      M = Integer.parseInt(NMW[1]);
      int W = Integer.parseInt(NMW[2]);
      graph = new ArrayList<>();
      for (int i = 0; i < N; i++) {
        graph.add(new ArrayList<>());
      }

      for (int i = 0; i < M; i++) {
        String[] roadInput = br.readLine().split(" ");
        int S = Integer.parseInt(roadInput[0]);
        int E = Integer.parseInt(roadInput[1]);
        int T = Integer.parseInt(roadInput[2]);

        graph.get(S-1).add(new Node(E-1, T));
        graph.get(E-1).add(new Node(S-1, T));
      }

      for (int i = 0; i < W; i++) {
        String[] worm = br.readLine().split(" ");
        int S = Integer.parseInt(worm[0]);
        int E = Integer.parseInt(worm[1]);
        int T = Integer.parseInt(worm[2]);

        graph.get(S-1).add(new Node(E-1, -T));
      }

      sb.append(solve() ? "YES\n" : "NO\n");
    }
    System.out.println(sb);
  }

  public static boolean solve() {
    int[] dists = new int[N];
    Arrays.fill(dists, INF);
    dists[0] = 0;
    boolean existCycle = false;
    for (int i = 0; i < N; i++) {
      boolean isUpdated = false;
      for (int v = 0; v < N; v++) {
          for (Node node : graph.get(v)) {
            if (dists[node.to] > dists[v] + node.w) {
              dists[node.to] = dists[v] + node.w;
              isUpdated = true;
          }
        }
      }
      if (!isUpdated) {
        break;
      }

      if (i == N - 1 && isUpdated) {
        existCycle = true;
      }
    }

    if (existCycle) {
      return true;
    } else {
      return false;
    }
  }
}
