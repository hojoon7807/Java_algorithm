package programmers;

public class n2배열자르기 {

  public static void main(String[] args) {
    solution(3, 2, 5);
  }
  public static int[] solution(int n, long left, long right) {
    int[] answer = new int[(int)(right-left+1)];

    for (long i = left; i <= right; i++) {
      long cal = i/n;
      long row = i%n;

      answer[(int) (i - left)] = (int) (Math.max(cal, row) + 1);
    }


    return answer;
  }

}
