package programmers;

import java.util.HashMap;

public class 숫자문자열과영단어 {

  public static void main(String[] args) {
    solution("one4seveneight");
    solution("23four5six7");
    solution("2three45sixseven");
    solution("123");
  }

  public static int solution(String s) {
    StringBuilder sb = new StringBuilder();
    StringBuilder tmp = new StringBuilder();

    HashMap<String, Integer> map = new HashMap<>();
    map.put("zero", 0);
    map.put("one", 1);
    map.put("two", 2);
    map.put("three", 3);
    map.put("four", 4);
    map.put("five", 5);
    map.put("six", 6);
    map.put("seven", 7);
    map.put("eight", 8);
    map.put("nine", 9);
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        sb.append(c);
      } else {
        tmp.append(c);
        if (map.containsKey(tmp.toString())) {
          sb.append(map.get(tmp.toString()));
          tmp = new StringBuilder();
        }
      }
    }

    System.out.println(Integer.parseInt(sb.toString()));
    return Integer.parseInt(sb.toString());
  }

}
