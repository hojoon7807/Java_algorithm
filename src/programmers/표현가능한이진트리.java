package programmers;

public class 표현가능한이진트리 {

  public static void main(String[] args) {

    solution(new long[]{7, 42, 5});
  }

  public static int[] solution(long[] numbers) {
    int[] answer = new int[numbers.length];
    for (int i = 0; i < numbers.length; i++) {
      long number = numbers[i];
      String binaryString = Long.toBinaryString(number);

      int binaryLen = binaryString.length();
      int treeDepth = 0;

      while (binaryLen != 0) {
        binaryLen /= 2;
        treeDepth++;
      }

      int nodeCount = (1 << treeDepth) - 1;

      StringBuilder sb = new StringBuilder(binaryString);

      while (nodeCount != sb.length()) {
        sb.insert(0, "0");
      }

      binaryString = sb.toString();

      int rootIndex = binaryString.length() / 2;

      boolean isEnable = search(treeDepth - 2, rootIndex, binaryString);

      if (isEnable) {
        answer[i] = 1;
      } else {
        answer[i] = 0;
      }
    }
    return answer;
  }

  static boolean search(int depth, int index, String binary) {
    if (depth < 0) {
      return true;
    }

    int leftIndex = index - (1 << depth);
    int rightIndex = index + (1 << depth);

    char leftNode = binary.charAt(leftIndex);
    char rightNode = binary.charAt(rightIndex);

    if (binary.charAt(index) == '0') {
      if (leftNode == '1' || rightNode == '1') {
        return false;
      }
    }

    boolean right = search(depth - 1, rightIndex, binary);
    boolean left = search(depth - 1, leftIndex, binary);

    if (!right || !left) {
      return false;
    } else {
      return true;
    }
  }

}
