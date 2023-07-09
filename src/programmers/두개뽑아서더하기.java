package programmers;

import java.util.HashSet;
import java.util.Set;

public class 두개뽑아서더하기 {

  public int[] solution(int[] numbers) {
    Set<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < numbers.length - 1; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        set.add(numbers[i] + numbers[j]);
      }
    }
    int[] answer = set.stream().mapToInt(value -> value.intValue()).sorted().toArray();
    return answer;
  }

}
