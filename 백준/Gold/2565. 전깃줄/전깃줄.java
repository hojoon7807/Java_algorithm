
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  /*
  전깃줄이 서로 교차하지않게 만드는 최소 제거 개수

   i번 전기줄에 갔을때 교차하지 않게 만들기 위한 개수

   A 전깃줄 순서대로 정렬
   8 9 2 1 4 10 7 6 ->  8 2 9 1 4 6 7 10

   최장 증가 수열을 구하면된다
   */

  static int n;
  static int[] arr = new int[501];
  static int[] dp;

  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());

    arr = new int[501];
    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      int a = Integer.parseInt(input[0]);
      int b = Integer.parseInt(input[1]);

      arr[a] = b;
    }

    ArrayList<Integer> list = new ArrayList<>();

    for (int i : arr) {
      if (i != 0) {
        list.add(i);
      }
    }

    dp = new int[n];
    dp[0] = 1;

    int lis = 1;

    for (int i = 1; i < n; i++) {
      int max = 0;
      for (int j = 0; j < i; j++) {
        if (list.get(j) < list.get(i)) {
          max = Math.max(max, dp[j]);
        }
      }

      dp[i] = max + 1;
      lis = Math.max(lis, dp[i]);
    }
    
    System.out.println(n - lis);

  }
}
