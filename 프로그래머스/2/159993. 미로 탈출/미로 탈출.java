import java.util.*;

class Solution {
    
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static int rLen = -1;
    static int cLen = -1;
    public static int solution(String[] maps) {
        rLen = maps.length;
        cLen = maps[0].length();
        
        boolean[][] isVisited = new boolean[rLen][cLen];
        
        int answer = 0;
        // 레버로 이동하는 가장 빠른 시간
        
        for(int i=0; i<rLen; i++){
            for(int j=0; j<cLen; j++){
                if(maps[i].charAt(j) == 'S'){
                    Node lNode = find(i,j,'L',maps);
                    
                    if(lNode.time == -1){
                        return -1;
                    }
                    answer += lNode.time;
                    
                    Node eNode = find(lNode.r, lNode.c, 'E', maps);
                    
                    if(eNode.time == -1){
                        return -1;
                    }
                    
                    answer += eNode.time;
                }
            }
        }
        
        
        // 레버에서 출구로 이동하는 가방 빠른 시간
        return answer;
    }
    
    static Node find (int r, int c, char target, String[] maps){
        LinkedList<Node> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[rLen][cLen];
        q.add(new Node(r,c,0));
        isVisited[r][c] = true;
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            for(int i=0; i<4; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if(nr < 0 || nr >= rLen || nc < 0 || nc >= cLen){
                    continue;
                }
                
                if(isVisited[nr][nc] || maps[nr].charAt(nc) == 'X') {
                    continue;
                }
                
                if(maps[nr].charAt(nc) == target){
                    return new Node(nr,nc, cur.time + 1);
                }
                
                isVisited[nr][nc] = true;
                q.add(new Node(nr, nc, cur.time+1));
            }
        }
        
        return new Node(-1,-1,-1);
    }
    
    static class Node {
        int r;
        int c;
        int time;
        
        public Node (int r, int c, int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
}