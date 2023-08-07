package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class 순위검색 {

  public static void main(String[] args) {
    solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210",
            "python frontend senior chicken 150", "cpp backend senior pizza 260",
            "java backend junior chicken 80", "python backend senior chicken 50"},
        new String[]{"java and backend and junior and pizza 100",
            "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
            "- and backend and senior and - 150", "- and - and - and chicken 100",
            "- and - and - and - 150"});
  }

  public static int[] solution(String[] info, String[] query) {
    int queryLen = query.length;

    int[] answer = new int[queryLen];

    Map<String, List<Integer>> map = buildMap(info);

    for (int i = 0; i < queryLen; i++) {
      String[] splitQuery = query[i].split(" (and )?");
      String key = splitQuery[0] + splitQuery[1] + splitQuery[2] + splitQuery[3];
      int score = Integer.parseInt(splitQuery[4]);

      answer[i] = getCount(map, key, score);

    }
    return answer;
  }

  private static int getCount(Map<String, List<Integer>> map, String key, int score) {
    if (!map.containsKey(key)) {
      return 0;
    }
    List<Integer> scores = map.get(key);

    int start = 0;
    int end = scores.size() - 1;

    while (start < end) {
      int mid = (start + end) / 2;

      if (scores.get(mid) < score) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }

    return (scores.get(start) < score) ? 0 : scores.size() - start;
  }

  private static Map<String, List<Integer>> buildMap(String[] info) {
    HashMap<String, List<Integer>> map = new HashMap<>();

    for (String s : info) {
      String[] splitInfo = s.split(" ");
      int score = Integer.parseInt(splitInfo[4]);

      combineKey(0, "", splitInfo, key -> {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(score);
      });
    }

    for (List<Integer> value : map.values()) {
      value.sort(Comparator.naturalOrder());
    }
    return map;
  }

  private static void combineKey(int index, String prefix, String[] split,
      Consumer<String> action) {
    if (index == split.length - 1) {
      action.accept(prefix);
      return;
    }

    combineKey(index + 1, prefix + split[index], split, action);
    combineKey(index + 1, prefix + "-", split, action);
  }
}
