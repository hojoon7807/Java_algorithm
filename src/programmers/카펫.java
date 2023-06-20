package programmers;

public class 카펫 {

  public static void main(String[] args) {
    solution(5000, 2000000);
    solution(5000, 2000000);
    solution(5000, 2000000);
  }

  public static int[] solution(int brown, int yellow) {

    return getSize(brown, yellow);
  }

  static int[] getSize(int brown, int yellow) {
    int length = 1;
    while (true) {
      int width = yellow / length;

      if (length * width != yellow || length > width) {
        length++;
        continue;
      }

      int calBrown = width * 2 + length * 2 + 4;
      if (calBrown == brown) {
        return new int[]{width + 2, length + 2};
      }

      length++;
    }
  }


}
