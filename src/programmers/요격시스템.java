package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 요격시스템 {

  public int solution(int[][] targets) {
    int answer = 0;

    Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));

    int recent = 0;
    for (int i = 0; i < targets.length; i++) {
      int s = targets[i][0];
      int e = targets[i][1];

      if (s < recent) {
        continue;
      } else {
        answer++;
        recent = e;
      }
    }
    return answer;

  }

}
