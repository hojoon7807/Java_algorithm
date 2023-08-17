package programmers;

import java.util.Arrays;

public class 최고의집합 {

  public static void main(String[] args) {
    최고의집합 m = new 최고의집합();
    System.out.println(Arrays.toString(m.solution(5, 321412)));
    System.out.println(Arrays.toString(m.solution(1, 2)));

  }
  public int[] solution(int n, int s) {
    int[] answer = new int[n];

    if (s < n) {
      return new int[]{-1};
    }

    for (int i = n; i >= 1; i--) {
      answer[n-i] = s/i;
      s -= s/i;
    }

    // n - i
    // s = 8 n = 3
//    for (int i = 1; i <= 10000; i++) {
//      int start = i;
//      int sum = 0;
//      for (int j = 1; j <= n; j++) {
//        if ((s - sum) / j <= start) {
//          answer[j-1] = start;
//          sum += start;
//          start ++;
//        }
//      }
//    }
    return answer;
  }
}
