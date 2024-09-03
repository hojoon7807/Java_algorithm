import java.io.*;
import java.util.*;
import java.util.Comparator;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int w,h;
    static int[][][] dist;
    static int INF = 123456789;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static char[][] map;
    static PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.count));
    
    public static void main(String[] args) throws IOException {
        String[] wh = br.readLine().split(" ");
        w = Integer.parseInt(wh[0]);
        h = Integer.parseInt(wh[1]);
        
        map = new char[h][w];
        dist = new int[h][w][4];
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                for(int k=0; k<4; k++){
                    dist[i][j][k] = INF;                
                }
            }
        }
        
        Node start = null;
        Node end = null;
        for(int i=0; i<h; i++){
            char[] chars = br.readLine().toCharArray();
            for(int j=0; j<w; j++){
                char c = chars[j];
                
                if(c == 'C'){
                    if(start == null){
                        start = new Node(i,j,-1,0);
                    } else {
                        end = new Node(i,j,-1,0);
                    }
                }
                
                map[i][j] = c;
            }
        }
        
        dijkstra(start, end);
    }
    
    static void dijkstra(Node start, Node end){
        for(int i=0; i<4; i++){
            int nr = start.r + dr[i];
            int nc = start.c + dc[i];
            
            if(canMove(nr,nc)){
                dist[start.r][start.c][i] = 0;
                pq.add(new Node(start.r, start.c, i, 0));
            }
        }
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(cur.r == end.r && cur.c == end.c){
                System.out.println(cur.count);
                return;
            }
            
            if(cur.count > dist[cur.r][cur.c][cur.dir]){
                continue;
            }
            
            int nr = cur.r + dr[cur.dir];
            int nc = cur.c + dc[cur.dir];
            
            if(canMove(nr,nc)){
                if(isMin(dist[nr][nc][cur.dir], cur.count)){
                    dist[nr][nc][cur.dir] = cur.count;
                    pq.add(new Node(nr, nc, cur.dir, cur.count));
                }
                
                int nDist = cur.count + 1;
                
                if(cur.dir == 0 || cur.dir == 1){
                    for(int d = 2; d<4; d++){
                        if(isMin(dist[nr][nc][d], nDist)){
                            dist[nr][nc][d] = nDist;
                            pq.add(new Node(nr, nc, d, nDist));
                        }
                    }
                }
                
                if(cur.dir == 2 || cur.dir == 3){
                    for(int d = 0; d<2; d++){
                        if(isMin(dist[nr][nc][d], nDist)){
                            dist[nr][nc][d] = nDist;
                            pq.add(new Node(nr, nc, d, nDist));
                        }
                    }
                }
            }
        }
    }
    
    static boolean isMin(int cur, int next){
        return next < cur;
    }
    
    static boolean canMove(int r, int c){
        if(r < 0 || r >= h || c < 0 || c >= w){
            return false;
        }
        
        if(map[r][c] == '*'){
            return false;
        }
        
        return true;
    }
    
    static class Node {
        int r;
        int c;
        int dir;
        int count;
        
        public Node(int r, int c, int dir, int count){
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.count = count;
        }
    }
}