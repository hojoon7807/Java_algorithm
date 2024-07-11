import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dr = {1,0,-1,0,-1,-1,1,1,0};
    static int[] dc = {0,1,0,-1,-1,1,-1,1,0};
    static char[][] map = new char[8][8];
    static boolean[][][] hasWall = new boolean[8][8][8];
    
    public static void main(String[] args) throws IOException {
        for(int i=0; i<8; i++){
            char[] cArr = br.readLine().toCharArray();
            map[i] = cArr;
            
            for(int j=0; j<8; j++){
                char c = cArr[j];
                
                if(c == '#'){
                  for(int k=0; k+i<8; k++){
                    hasWall[i+k][j][k] = true;
                  }
                }
            }
        }
        
        LinkedList<int[]> q = new LinkedList<>();
        // ##*
        // **#
        // **#
        // 0*#
        q.add(new int[]{7,0,0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            if(cur[0] == 0 && cur[1] == 7){
                System.out.println(1);
                return;
            }
            
            if(cur[2] == 7){
                System.out.println(1);
                return;
            }
            
            for(int i=0; i<9; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                
                if(nr < 0 || nr >= 8 || nc < 0 || nc >= 8){
                    continue;
                }
                
                if(hasWall[nr][nc][cur[2]]){
                    continue;
                }
                
                if(hasWall[nr][nc][cur[2] + 1]){
                    continue;
                }
                
                q.add(new int[]{nr,nc,cur[2]+1});
            }
        }
        
        System.out.println(0);
        
    }
}