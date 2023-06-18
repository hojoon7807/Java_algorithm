package programmers;

import java.util.ArrayList;

public class 하노이의탑 {

  static ArrayList<int[]> list = new ArrayList();

  public int[][] solution(int n) {
    hanoi(n, 1, 3, 2);
    int[][] answer = new int[list.size()][2];
    for (int i = 0; i < list.size(); i++) {
      answer[i] = list.get(i);
    }
    return answer;
  }

  void hanoi(int n, int start, int to, int via) {
    if (n == 1) {
      list.add(new int[]{start, to});
    } else {
      hanoi(n - 1, start, via, to);
      list.add(new int[]{start, to});
      hanoi(n - 1, via, to, start);
    }
  }

}
