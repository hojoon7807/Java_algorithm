package greedy;

// 1이 될때 까지

import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;

        while (true) {
            if (n==1){
                break;
            }
            if (n % k == 0) {
                n = n/k;
                result++;
            } else {
                n--;
                result++;
            }
        }
        System.out.println(result);

        while (true) {
            int target = (n / k) * k;
            result += n - target;
            n = target;
            if(n<k) break;
            result+=1;
            n /= k;
        }

        result += (n - 1);
        System.out.println(result);
    }


}
