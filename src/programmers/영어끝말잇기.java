package programmers;

import java.util.HashSet;

public class 영어끝말잇기 {

  public int[] solution(int n, String[] words) {
    int len = words.length;
    int count = 0;
    HashSet<String> set = new HashSet();

    set.add(words[0]);
    for (int i = 1; i < len; i++) {
      if (set.contains(words[i]) || !isPossible(words[i - 1], words[i])) {
        System.out.println(i);
        return new int[]{i % n + 1, i / n + 1};
      }

      set.add(words[i]);
    }

    return new int[]{0, 0};
  }

  public boolean isPossible(String prev, String next) {
    if (prev.charAt(prev.length() - 1) == next.charAt(0)) {
      return true;
    } else {
      return false;
    }
  }
}
