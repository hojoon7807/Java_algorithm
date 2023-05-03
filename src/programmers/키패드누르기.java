package programmers;

public class 키패드누르기 {

  public static void main(String[] args) {

  }

  public static String solution(int[] numbers, String hand) {
    StringBuilder sb = new StringBuilder();
    int[][] keypad = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1},
        {2, 2}};
    int[] left = {3, 0};
    int[] right = {3, 2};

    for (int number : numbers) {
      if (isLeft(number)) {
        sb.append("L");
        left = keypad[number];
      } else if (isRight(number)) {
        sb.append("R");
        right = keypad[number];
      } else {
        int[] numberPoint = keypad[number];
        int leftDistance = getDistance(left, numberPoint);
        int rightDistance = getDistance(right, numberPoint);
        if (leftDistance == rightDistance) {
          if (hand.equals("left")) {
            sb.append("L");
            left = keypad[number];
          } else {
            sb.append("R");
            right = keypad[number];
          }
        } else if (leftDistance > rightDistance) {
          sb.append("R");
          right = keypad[number];
        } else {
          sb.append("L");
          left = keypad[number];
        }
      }
    }
    return sb.toString();
  }

  public static int getDistance(int[] recent, int[] next) {
    return Math.abs(recent[0] - next[0]) + Math.abs(recent[1] - next[1]);
  }

  public static boolean isLeft(int number) {
    if (number == 1 || number == 4 || number == 7) {
      return true;
    }
    return false;
  }

  public static boolean isRight(int number) {
    if (number == 3 || number == 6 || number == 9) {
      return true;
    }
    return false;
  }

}
