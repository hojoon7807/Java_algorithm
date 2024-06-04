import java.util.*;

class Solution {
    static int[] dist;
    static int INF = 123456789;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    
    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        dist = new int[n+1];
        
        Arrays.fill(dist, INF);
        
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] road:roads){
            int a = road[0];
            int b = road[1];
            
            graph.get(a).add(new Node(b,1));
            graph.get(b).add(new Node(a,1));
        }
        
        dijkstra(destination);
        
        //System.out.println(Arrays.toString(dist));
        
        for(int i=0; i<sources.length; i++){
            if(dist[sources[i]] == INF){
                answer[i] = -1;
            } else {
                answer[i] = dist[sources[i]];                   
            }
        }
        
        return answer;
    }
    
    static void dijkstra(int start){
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Node(start, 0));
    
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(cur.cost > dist[cur.to]){
                continue;
            }
            
            for(Node next : graph.get(cur.to)){
                int nd = dist[cur.to] + next.cost;
                
                if(dist[next.to] > nd){
                    dist[next.to] = nd;
                    pq.add(new Node(next.to, nd));
                }
            }
        }
                                                     
    }
    
    static class Node {
        int to;
        int cost;
        
        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
}