package toss;

public class Pan {

  public static void main(String[] args) {
    solution("14511232125", 2);
  }
  public static int solution(String s, int N) {
    return getMaxPandigital(s, N);
  }

  public static int getMaxPandigital(String s, int N) {
    int max = -1;
    for (int i = 0; i <= s.length() - N; i++) {
      String sub = s.substring(i, i + N);
      if (isPandigital(sub, N)) {
        max = Math.max(max, Integer.parseInt(sub));
      }
    }
    return max;
  }

  private static boolean isPandigital(String sub, int N) {
    boolean[] digits = new boolean[N + 1];
    for (char c : sub.toCharArray()) {
      int num = c - '0';
      if (num < 1 || num > N || digits[num]) {
        return false;
      }
      digits[num] = true;
    }
    return true;
  }

}
