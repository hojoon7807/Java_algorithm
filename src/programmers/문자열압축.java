package programmers;

public class 문자열압축 {

  public static void main(String[] args) {
    solution("aabbaccc");
    solution("aabbaccc");
    solution("aabbaccc");
    solution("aabbaccc");
  }

  public static int solution(String s) {
    int answer = s.length();
    String previousString = "";
    int count = 1;

    StringBuilder sb;
    for (int len = 1; len <= s.length() / 2; len++) {
      sb = new StringBuilder();
      previousString = s.substring(0, len);
      for (int i = len; i <= s.length(); i += len) {
        int end = i + len;
        if (end > s.length()) {
          end = s.length();
        }
        String compare = s.substring(i, end);
        if (previousString.equals(compare)) {
          count++;
        } else {
          if (count != 1) {
            sb.append(count);
          }
          sb.append(previousString);
          previousString = compare;
          count = 1;
        }
      }

      sb.append(previousString);
      answer = Math.min(answer, sb.length());

    }
    System.out.println(answer);
    return answer;
  }
}
