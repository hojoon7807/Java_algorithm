package programmers;

import java.util.Arrays;

public class Hindex {

  public int solution(int[] citations) {
    Arrays.sort(citations);
    int answer = 0;

    for (int h = citations.length; h >= 1; h--) {
      int index = citations.length - h;

      if (citations[index] >= h) {
        answer = h;
        break;
      }
    }

    return answer;
  }
}
