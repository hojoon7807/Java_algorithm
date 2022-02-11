package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sugar {
    // 2839 설탕배달
    public static void main(String[] args) throws IOException {
        int result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while(true){
            if (n % 5 == 0) {
                result += n / 5;
                break;
            }else{
                n -= 3;
                result ++;
            }

            if(n<0){
                result = -1;
                break;
            }
        }

        System.out.println(result);
    }
}
