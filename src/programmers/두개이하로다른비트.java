package programmers;

import java.util.Arrays;

public class 두개이하로다른비트 {

  public static void main(String[] args) {
    두개이하로다른비트 m = new 두개이하로다른비트();
    System.out.println(Arrays.toString(m.solution(
        new long[]{Long.parseLong("1011", 2), Long.parseLong("1001", 2), Long.parseLong("110", 2),
            Long.parseLong("101", 2)})));
  }
  public long[] solution(long[] numbers) {
    int numbersLen = numbers.length;
    long[] answer = new long[numbersLen];
    for (int i = 0; i < numbersLen; i++) {
      String binaryString = Long.toBinaryString(numbers[i]);

      if (binaryString.charAt(binaryString.length() - 1) == '0') {
        answer[i] = numbers[i] + 1;
        continue;
      }

      int zeroIndex = findZeroIndex(binaryString);

      if (binaryString.length() - zeroIndex == 2) {
        answer[i] = numbers[i] + 1;
        continue;
      }

      long min = numbers[i] + 1 + (long)Math.pow(2, binaryString.length() - zeroIndex -2) -1;
      answer[i] = min;
    }

    return answer;
  }

  int findZeroIndex(String binary) {
    for (int i = binary.length()-1; i >= 0; i--) {
      if (binary.charAt(i) == '0') {
        return i;
      }
    }
    return -1;
  }


}
