import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
    
    static int n;
    static PriorityQueue<Integer> pq;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        pq = new PriorityQueue(Comparator.reverseOrder());
        for(int i=0; i<n; i++){
            List<Integer> list = Arrays.stream(br.readLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
            list.forEach(pq::add);
        }
        
        int answer = -1;
        
        for(int i=0; i<n; i++){
            answer = pq.poll();
        }
        
        System.out.println(answer);
    }
}