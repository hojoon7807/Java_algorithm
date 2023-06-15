package programmers;

public class 문자열다루기기본 {

  public boolean solution(String s) {
    String PATTERN = "^[0-9]{4}|[0-9]{6}$";

    boolean answer = s.matches(PATTERN);
    return answer;
  }
}
