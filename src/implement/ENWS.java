package implement;

import java.util.Arrays;
import java.util.Scanner;

public class ENWS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String[] plans = sc.nextLine().split(" ");
        int x=1 , y = 1;

        int[] dx = {-1, 1, 0,0};
        int[] dy = {0, 0, -1, 1};
        char [] types = {'L', 'R', 'U', 'D'};

        for (String p : plans) {
            char plan = p.charAt(0);
            int nx = 0,ny =0 ;
            for (int j = 0; j < 4; j++) {
                if (plan == types[j]) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }
            if (nx < 1 || ny < 1 || nx > n || nx > n) continue;
            x = nx;
            y = ny;
        }
        System.out.println(x+" " +y);
    }
}
