import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static boolean[] arr;
    static boolean[] arr2;
    static boolean[] to;
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        
        arr = new boolean[n];
        to = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(input[i] - '0' == 1){
                arr[i] = true;
            }
        }
        
        arr2 = arr.clone();
        input = br.readLine().toCharArray();
                
        for(int i=0; i<n; i++){
            if(input[i] - '0' == 1){
                to[i] = true;
            }
        }
        
        int answer = 0;
        int answer2 = 1;
        
        arr2[0] = !arr2[0];
        arr2[1] = !arr2[1];
        
        for(int i=1; i<n; i++){
            if(arr[i-1] != to[i-1]){
                if(i != n-1){
                    arr[i-1] = !arr[i-1];
                    arr[i] = !arr[i];
                    arr[i+1] = !arr[i+1];
                } else {
                    arr[i-1] = !arr[i-1];
                    arr[i] = !arr[i]; 
                }
                answer++;
            }
            
            if(arr2[i-1] != to[i-1]){
                if(i != n-1){
                    arr2[i-1] = !arr2[i-1];
                    arr2[i] = !arr2[i];
                    arr2[i+1] = !arr2[i+1];
                } else {
                    arr2[i-1] = !arr2[i-1];
                    arr2[i] = !arr2[i]; 
                }
                
                answer2++;
            }
        }
        
        if(arr[n-1] != to[n-1] && arr2[n-1] != to[n-1]){
            System.out.println(-1);
            return;
        }

        if(arr[n-1] == to[n-1]){
            System.out.println(answer);
        } else {
            System.out.println(answer2);
        }
    }
}