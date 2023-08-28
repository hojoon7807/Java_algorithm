package programmers;

import java.util.PriorityQueue;

public class 혼자놀기의달임 {

  public int solution(int[] cards) {
    int answer = 1;
    boolean[] isVisited = new boolean[cards.length + 1];

    PriorityQueue<Integer> q = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
    for (int i = 0; i < cards.length; i++) {
      if (!isVisited[i]) {
        isVisited[i] = true;
        int count = 1;
        int index = cards[i] - 1;
        while (true) {
          if (!isVisited[index]) {
            isVisited[index] = true;
            count++;
            index = cards[index] - 1;
          } else {
            break;
          }
        }

        if (count == cards.length) {
          return 0;
        }

        q.add(count);
      }
    }

    for (int i = 0; i < 2; i++) {
      answer *= q.poll();
    }

    return answer;
  }
}
