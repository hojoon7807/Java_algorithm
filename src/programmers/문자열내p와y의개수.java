package programmers;

public class 문자열내p와y의개수 {

  boolean solution(String s) {
    boolean answer = true;

    String lowerString = s.toLowerCase();

    int pCount = 0;
    int yCount = 0;

    for (char c : lowerString.toCharArray()) {
      if (c == 'p') {
        pCount++;
      } else if (c == 'y') {
        yCount++;
      }
    }

    answer = (pCount == yCount) ? true : false;

    return answer;
  }
}
