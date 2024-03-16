package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class 가장먼노드 {
    public int solution(int n, int[][] edge) {
      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

      for(int i=0; i<=n; i++){
        graph.add(new ArrayList<>());
      }

      for(int[] e:edge){
        graph.get(e[0]).add(e[1]);
        graph.get(e[1]).add(e[0]);
      }
      int[] distance = dijkstra(n, graph);

      HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

      for(int i=2; i<=n; i++){
        int d = distance[i];

        if(!map.containsKey(d)){
          map.put(d, new ArrayList<>());
        }

        map.get(d).add(i);
      }

      int max = -1;

      for(int key: map.keySet()){
        max = Math.max(max,key);
      }

      return map.get(max).size();
    }

    int[] dijkstra(int n, ArrayList<ArrayList<Integer>> graph){
      int INF = 123456789;
      int[] distance = new int[n+1];

      Arrays.fill(distance, INF);
      distance[1] = 0;
      PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
      pq.add(new Node(1,0));

      while(!pq.isEmpty()){
        Node cur = pq.poll();

        if(distance[cur.v] < cur.w) {
          continue;
        }

        for(int next: graph.get(cur.v)){
          int d = distance[cur.v] + 1;

          if(d < distance[next]){
            distance[next] = d;
            pq.add(new Node(next, d));
          }
        }
      }

      return distance;
    }

    static class Node {

      int v;
      int w;

      Node(int v, int w) {
        this.v = v;
        this.w = w;
      }
    }
}
