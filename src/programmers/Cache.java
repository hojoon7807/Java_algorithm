package programmers;

import java.util.HashMap;
import java.util.LinkedList;

public class Cache {

  static HashMap<String, Integer> cache = new HashMap();
  static LinkedList<String> lruList = new LinkedList();

  public int solution(int cacheSize, String[] cities) {
    int answer = 0;

    for (String city : cities) {
      city = city.toUpperCase();
      if (cacheSize == 0) {
        answer += 5;
        continue;
      }
      if (!cache.containsKey(city)) {
        answer += 5;
        if (cache.size() == cacheSize) {
          String last = lruList.pollLast();
          cache.remove(last);
        }

        lruList.addFirst(city);
        cache.put(city, 0);
      } else {
        // lru 업데이트/
        lruList.remove(city);
        lruList.addFirst(city);
        answer += 1;
      }
    }
    return answer;
  }

}
