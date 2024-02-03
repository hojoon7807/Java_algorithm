package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1504 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, E;
  static int V1, V2;
  static int INF = 987654321;
  static int[] distance;
  static ArrayList<ArrayList<Vertex>> graph = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      graph.get(a).add(new Vertex(b, c));
      graph.get(b).add(new Vertex(a, c));
    }

    st = new StringTokenizer(br.readLine());
    V1 = Integer.parseInt(st.nextToken());
    V2 = Integer.parseInt(st.nextToken());
  }

  static void solution() {
    // Start
    dijkstra(1);
    long startToV1 = distance[V1];
    long startToV2 = distance[V2];

    // V1
    dijkstra(V1);
    long V1ToV2 = distance[V2];
    long V1ToN = distance[N];

    // V2
    dijkstra(V2);
    long V2ToV1 = distance[V1];
    long V2ToN = distance[N];

    // S -> V1 -> V2 -> E
    long path1 = startToV1 + V1ToV2 + V2ToN;
    // S -> V2 -> V1 -> E
    long path2 = startToV2 + V2ToV1 + V1ToN;

    if (path1 >= INF || path2 >= INF) {
      System.out.println(-1);
    } else {
      System.out.println(Math.min(path2, path1));
    }
  }

  static void dijkstra(int start) {
    distance = new int[N + 1];
    Arrays.fill(distance, INF);
    PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.c));

    distance[start] = 0;
    pq.add(new Vertex(start, 0));

    while (!pq.isEmpty()) {
      Vertex cur = pq.poll();
      int v = cur.to;
      int c = cur.c;

      if (c > distance[v]) {
        continue;
      }

      for (Vertex next : graph.get(v)) {
        if (distance[next.to] > distance[v] + next.c) {
          distance[next.to] = distance[v] + next.c;
          pq.add(new Vertex(next.to, distance[next.to]));
        }
      }
    }
  }

  static class Vertex {

    int to;
    int c;

    public Vertex(int to, int c) {
      this.to = to;
      this.c = c;
    }
  }

}
