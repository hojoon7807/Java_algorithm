package programmers;

import java.util.Arrays;

public class 징검다리 {

  public int solution(int distance, int[] rocks, int n) {
    int answer = 0;
    int start = 1;
    int end = distance + 1;
    Arrays.sort(rocks);

    while (start < end) {
      int mid = (start + end) / 2;

      if (isValid(rocks, mid, n, distance)) {
        answer = mid;
        start = mid + 1;
      } else {
        end = mid;
      }
    }
    return answer;
  }

  public boolean isValid(int[] rocks, int mid, int n, int distance) {
    int count = 0;
    int last = 0;

    for (int rock : rocks) {
      if (rock - last < mid) {
        count++;
        continue;
      }

      last = rock;
    }

    if (distance - last < mid) {
      count++;
    }

    if (count <= n) {
      return true;
    }
    return false;
  }


}
