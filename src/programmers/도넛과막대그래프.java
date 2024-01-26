package programmers;

import java.util.HashMap;

public class 도넛과막대그래프 {

  static HashMap<Integer, int[]> graph = new HashMap<>();

  public int[] solution(int[][] edges) {
    int[] answer = new int[4];
    for (int[] edge : edges) {
      int a = edge[0];
      int b = edge[1];

      if (!graph.containsKey(a)) {
        graph.put(a, new int[2]);
      }

      if (!graph.containsKey(b)) {
        graph.put(b, new int[2]);
      }

      //준
      graph.get(a)[1]++;
      // 받은
      graph.get(b)[0]++;

    }
    System.out.println(graph.size());

    for (int i = 1; i <= graph.size(); i++) {
      int[] nodeInfo = graph.get(i);
      int getCount = nodeInfo[0];
      int giveCount = nodeInfo[1];

      if (getCount == 0 && giveCount >= 2) {
        // root
        answer[0] = i;
        continue;
      }

      if (giveCount == 0) {
        // stick
        answer[2]++;
        continue;
      }

      if (giveCount == 2 && getCount >= 2) {
        // 8
        answer[3]++;
        continue;
      }
    }

    answer[1] = graph.get(answer[0])[1] - answer[2] - answer[3];

    return answer;
  }
}
