package programmers;

import java.io.IOException;
import java.util.HashMap;

public class 할인행사 {

  public static void main(String[] args) throws IOException {
    solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1},
        new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana",
            "pork", "rice", "pot", "banana", "apple", "banana"});
  }

  public static int solution(String[] want, int[] number, String[] discount) {
    int answer = 0;
    for (int i = 0; i < discount.length - 9; i++) {
      HashMap<String, Integer> map = new HashMap<>();
      for (int j = i; j < i + 10; j++) {
        map.put(discount[j], map.getOrDefault(discount[j], 0) + 1);
      }

      boolean flag = true;
      for (int j = 0; j < want.length; j++) {
        if (!map.containsKey(want[j]) || map.get(want[j]) < number[j]) {
          flag = false;
          break;
        }
      }
      if (flag) {
        answer ++;
      }
    }

    return answer;
  }

}
