package programmers;

import java.util.PriorityQueue;

public class 디펜스게임 {

  public int solution(int n, int k, int[] enemy) {
    int answer = 0;
    int enemyLen = enemy.length;
    if (k >= enemyLen) {
      return enemyLen;
    }

    PriorityQueue<Integer> q = new PriorityQueue<Integer>((o1, o2) -> o1 - o2);

    for (int i = 0; i < enemyLen; i++) {
      q.add(enemy[i]);

      if (q.size() > k) {
        n -= q.poll();
      }

      if (n < 0) {
        return i;
      }
    }

    return enemyLen;
  }
}
