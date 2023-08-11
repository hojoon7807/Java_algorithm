package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B3981 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(reader.readLine());

    while(T-- > 0) {
      String[] input = reader.readLine().split(" ");
      int n = Integer.parseInt(input[0]);
      int[] x = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        x[i] = Integer.parseInt(input[1]);
      }

      if(n <= 3) {
        System.out.println("YES");
        continue;
      }

      // 3차 다항식 계수 구하기
      int a = (x[4] - 3*x[3] + 3*x[2] - x[1]);
      int b = -(2*x[4] - 9*x[3] + 11*x[2] - 4*x[1]);
      int c = (x[4] - 8*x[3] + 14*x[2] - 6*x[1]);
      int d = -(x[4] - 6*x[3] + 11*x[2] - 6*x[1]);

      // 4 이상의 i에 대해 3차 다항식이 성립하는지 확인
      boolean check = true;
      for(int i = 5; i <= n; i++) {
        if(x[i] != a*(i*i*i) + b*(i*i) + c*i + d) {
          check = false;
          break;
        }
      }

      if(check) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }

}
