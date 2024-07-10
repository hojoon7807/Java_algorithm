import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        n =  Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();
        
        ArrayList<Integer>[] dp = new ArrayList[n];
        
        for(int i=0; i<n; i++){
            dp[i] = new ArrayList<>();
        }
        
        dp[0].add(arr[0]);
        
        for(int i=1; i<n; i++){
            int maxIndex = i;
            int maxSize = 1;
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i]){
                    if(maxSize < dp[j].size() + 1){
                        maxIndex = j;
                        maxSize = dp[j].size() + 1;
                    }
                }    
            }
            
            dp[i].addAll(dp[maxIndex]);
            dp[i].add(arr[i]);
        }
        
        ArrayList<Integer> max = new ArrayList<>();
        
        for(ArrayList<Integer> d: dp){
            if(d.size() > max.size()){
                max = d;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(max.size()).append("\n");
        for(int i : max){
            sb.append(i).append(" ");
        }
        
        System.out.println(sb);
    }
    
    
}