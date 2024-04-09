import java.io.*;
import java.util.*;

public class Main {
    static int end = 100000;
    static boolean[] isVisited = new boolean[100001];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] d = {-1, 1, 2};
    
    public static void main(String[] args) throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        
        LinkedList<int[]> q = new LinkedList();
        
        q.add(new int[]{n,0});
        
        while(!q.isEmpty()){
            int[] recent = q.poll();
            if(recent[0] == k){
                System.out.println(recent[1]);
                return;
            }
            
            for(int i=0; i<3; i++) {
                int next = recent[0] + d[i];
                if(i == 2){
                    next = recent[0] * d[i];
                }
                
                if(next >= 0 && next<= end && !isVisited[next]){
                    q.add(new int[]{next, recent[1]+1});
                    isVisited[next] = true;
                }
            }
        }
        
    }
}