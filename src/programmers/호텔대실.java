package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 호텔대실 {

  public int solution(String[][] book_time) {
    // 24 * 60
    int[] time = new int[24 * 60];
    int max = 23 * 60 + 59;

    Arrays.sort(book_time, Comparator.comparing(o -> o[0]));

    for (String[] bt : book_time) {
      int start = toTime(bt[0]);
      int end = toTime(bt[1]) + 9;

      if (end > max) {
        end = max;
      }

      for (int i = start; i <= end; i++) {
        time[i]++;
      }
    }
    int answer = 0;

    for (int i = 0; i < time.length; i++) {
      answer = Math.max(answer, time[i]);
    }
    return answer;
  }

  int toTime(String s) {
    String[] split = s.split(":");
    return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
  }
}
