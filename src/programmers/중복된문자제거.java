package programmers;

import java.util.HashSet;

public class 중복된문자제거 {

  public String solution(String my_string) {
    HashSet<Character> set = new HashSet();

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < my_string.length(); i++) {
      char c = my_string.charAt(i);
      if (set.contains(c)) {
        continue;
      }

      set.add(c);
      sb.append(c);
    }
    return sb.toString();
  }

}
