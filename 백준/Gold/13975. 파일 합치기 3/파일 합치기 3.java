import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int t;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        
        while(t-- > 0){
            solution();
        }
        
        System.out.println(sb);
    }
    
    static void solution() throws IOException {
        int k = Integer.parseInt(br.readLine());
        long answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        
        for(long l:arr){
            pq.add(l);
        }
        
        while(!pq.isEmpty()){
            long a = pq.poll();
            long b = pq.poll();
            
            long sum = a + b;
            answer += sum;
            
            if(!pq.isEmpty()){
                pq.add(sum);
            }
        }
        
        sb.append(answer).append("\n");
    }
}