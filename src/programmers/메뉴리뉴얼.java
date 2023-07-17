package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class 메뉴리뉴얼 {

  public static void main(String[] args) {
    solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});
  }

  public static String[] solution(String[] orders, int[] course) {
    HashMap<String, Integer> courseMap = new HashMap<>();

    for (String order : orders) {
      HashSet<String> courseSet = new HashSet<>();
      char[] chars = order.toCharArray();
      Arrays.sort(chars);
      permutation(0, new StringBuilder(), courseSet, chars);
      for (String combine : courseSet) {
        courseMap.put(combine, courseMap.getOrDefault(combine, 0) + 1);
      }
    }
    ArrayList<String> list = new ArrayList<>();

    for (int len : course) {
      int max = 0;

      for (Entry<String, Integer> entry : courseMap.entrySet()) {
        if (entry.getKey().length() == len && entry.getValue() >= 2) {
          max = Math.max(max, entry.getValue());
        }
      }

      for (Entry<String, Integer> entry : courseMap.entrySet()) {
        if (entry.getKey().length() == len && entry.getValue() == max) {
          list.add(entry.getKey());
        }
      }
    }

    Collections.sort(list);
    String[] answer = list.toArray(new String[0]);

    return answer;
  }

  private static void permutation(int index, StringBuilder sb, Set<String> courseSet,
      char[] order) {
    if (sb.length() >= 2) {
      courseSet.add(sb.toString());
    }

    if (index == order.length) {
      return;
    }

    sb.append(order[index]);
    permutation(index + 1, sb, courseSet, order);
    sb.deleteCharAt(sb.length() - 1);
    permutation(index + 1, sb, courseSet, order);
  }

}
