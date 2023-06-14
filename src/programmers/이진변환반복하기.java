package programmers;

public class 이진변환반복하기 {

  public int[] solution(String s) {
    int[] answer = new int[2];

    while (!s.equals("1")) {
      int zeroCount = 0;
      answer[0]++;
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '0') {
          zeroCount++;
        }
      }

      int len = s.length() - zeroCount;
      s = Integer.toString(len, 2);
      answer[1] += zeroCount;
    }

    return answer;
  }
}
