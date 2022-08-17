package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14888 {

  private static int N;
  private static int[] operators = new int[4];
  private static int[] nums;
  //private static List<Integer> list = new ArrayList<>();
  private static int MAX = Integer.MIN_VALUE;
  private static int MIN = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    nums = new int[N];

    String[] input = br.readLine().split(" ");
    String[] input2 = br.readLine().split(" ");

    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(input[i]);
    }
    for (int i = 0; i < 4; i++) {
      operators[i] = Integer.parseInt(input2[i]);
    }

    dfs(nums[0], 1);

    //Collections.sort(list);

    System.out.println(MAX);
    System.out.println(MIN);
  }

  private static void dfs(int num, int depth) {
    if (depth == N) {
      MAX = Math.max(MAX, num);
      MIN = Math.min(MIN, num);
      return;
    }

    for (int i = 0; i < 4; i++) {
      if (operators[i] != 0) {
        operators[i]--;

        switch (i) {
          case 0:
            dfs(num + nums[depth], depth + 1);
            break;
          case 1:
            dfs(num - nums[depth], depth + 1);
            break;
          case 2:
            dfs(num * nums[depth], depth + 1);
            break;
          case 3:
            dfs(num / nums[depth], depth + 1);
            break;
        }

        operators[i]++;
      }
    }
  }
}
