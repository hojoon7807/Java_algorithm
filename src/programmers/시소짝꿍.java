package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 시소짝꿍 {

  public static void main(String[] args) {
    solution(new int[]{100, 180, 360, 100, 270});
  }

  static final int[][] ratio = {{1, 1}, {1, 2}, {2, 3}, {3, 4}};
  public static long solution(int[] weights) {
    long answer = 0;

    Arrays.sort(weights);
    Map<Integer, Integer> map = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();

    for (int i = 0 ;i < weights.length; i++) {
      map.put(weights[i],map.getOrDefault(weights[i], 0) + 1);
    }

    for (int i = 0; i < weights.length; i++) {
      int value = weights[i];

      for (int j = 0; j < 4; j++) {
        int a = ratio[j][0];
        int b = ratio[j][1];

        int key = (value * b) / a;

        if (j == 0) {
          if (set.contains(key)) {
            continue;
          }

          if (map.containsKey(key)) {
            if (map.get(key) > 1) {
              answer ++;
              set.add(value);
            }
          }
        } else {
          if (map.containsKey(key)) {
              answer ++;
          }
        }
      }
    }
    return answer;
  }


}
