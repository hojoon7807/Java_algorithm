package programmers;

public class 문자열내림차순으로정렬하기 {
  public String solution(String s) {
    String answer = "";
    StringBuilder sb = s.chars().boxed().sorted((o1, o2) -> o2 - o1).collect(
        StringBuilder::new,
        StringBuilder::appendCodePoint,
        StringBuilder::append
    );


    return sb.toString();
  }

}
