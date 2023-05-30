package programmers;

public class 삼진법뒤집기 {

  public static void main(String[] args) {
    solution(45);
    solution(125);
  }

  public static int solution(int n) {
    int answer = 0;
    StringBuilder sb = new StringBuilder();

    while (n != 0) {
      int remain = n % 3;
      sb.append(remain);
      n = n / 3;
    }

    String reverse = sb.toString();

    for (int i = 0; i < reverse.length(); i++) {
      answer += Math.pow(3, i) * (reverse.charAt(reverse.length() - i - 1) - '0');
    }
    return answer;
  }

}
