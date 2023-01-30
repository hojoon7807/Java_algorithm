package programmers;

import java.util.Arrays;

public class 양궁대회 {

  public static void main(String[] args) {
    int n = 5;
    int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};

    solution(n, info);
  }

  static int max = 0;
  static int[] answer = new int[11];

  public static int[] solution(int n, int[] info) {

    dfs(0, n, 0, new int[n], info);
    System.out.println(Arrays.toString(max == 0 ? new int[]{-1} : answer));
    return max == 0 ? new int[]{-1} : answer;
  }

  public static void dfs(int start, int n, int index, int[] results, int[] info) {
    if (index == n) {
      int[] ryanInfo = new int[11];
      for (int score : results) {
        ryanInfo[10-score] ++;
      }

      int ryanSum = 0;
      int apeachSum = 0;

      for (int i = 0; i < 11; i++) {
        int score = 10 - i;

        if (ryanInfo[i] > info[i]) {
          ryanSum += score;
        } else if (ryanInfo[i] < info[i]) {
          apeachSum += score;
        } else if (info[i] != 0 && ryanInfo[i] == info[i]) {
          apeachSum += score;
        }
      }

      if (ryanSum - apeachSum > max) {
        max = ryanSum - apeachSum;
        answer = ryanInfo;
      }
      return;
    }

    for (int i = start; i < 11; i++) {
      results[index] = i;
      dfs(i, n, index+1, results, info);
    }
  }

}
