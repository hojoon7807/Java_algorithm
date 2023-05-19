package programmers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class 튜플 {

  public static int[] solution(String s) {
    int[] answer;

    HashMap<Integer, Integer> map = new HashMap<>();
    StringBuilder value = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (Character.isDigit(s.charAt(i))) {
        int key = s.charAt(i) - '0';
        value.append(key);

      } else if (s.charAt(i) == ',') {
        if (Character.isDigit(s.charAt(i - 1))) {
          map.put(Integer.valueOf(value.toString()),
              map.getOrDefault(Integer.parseInt(value.toString()), 0) + 1);
          value = new StringBuilder();
        }
      } else if (s.charAt(i) == '}') {
        if (Character.isDigit(s.charAt(i - 1))) {
          map.put(Integer.valueOf(value.toString()),
              map.getOrDefault(Integer.parseInt(value.toString()), 0) + 1);
          value = new StringBuilder();

        }
      }
    }
    List<Entry<Integer, Integer>> entries = map.entrySet().stream()
        .sorted(Entry.comparingByValue(Comparator.reverseOrder())).collect(
            Collectors.toList());
    answer = new int[entries.size()];

    for (int i = 0; i < answer.length; i++) {
      answer[i] = entries.get(i).getKey();
    }
    return answer;
  }
}