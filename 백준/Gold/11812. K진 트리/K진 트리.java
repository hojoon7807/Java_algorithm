import java.io.*;
import java.util.*;

class Solution{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    long N;
    int K, Q;

    public Solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            if(K == 1){
                bw.write(Math.abs(x-y)+"\n");
                continue;
            }
            long cnt = 0;

            while(x != y){
                long max = Math.max(x, y);
                y = Math.min(x, y);
                x = (max-2)/K + 1;
                cnt++;
            }
            bw.write(cnt+"\n");
        }
        bw.close();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution();
    }
}