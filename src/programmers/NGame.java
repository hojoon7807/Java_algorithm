package programmers;

public class NGame {

  public static void main(String[] args) {
    System.out.println(solution(2, 4, 2, 1));
  }

  public static String solution(int n, int t, int m, int p) {
    StringBuilder answer = new StringBuilder();
    int current = 0;
    for (int i = 0; i <= t * m; i++) {
      String radixString = Integer.toString(i, n).toUpperCase();

      for (char c : radixString.toCharArray()) {
        if (answer.length() == t) {
          return answer.toString();
        }
        current++;
        if (current  == p) {
          p += m;
          answer.append(c);
        }
      }
    }
    return answer.toString();
    // 2진법 -> 0 1 10 11 100 101 110 111 1000 1001 1010 1011 1100
    // 100명 2진법 p = 100 t=1000 -> 100,000
    // 2^17 > 100000

  }

}
