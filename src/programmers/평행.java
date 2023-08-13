package programmers;

public class 평행 {

  public int solution(int[][] dots) {
    // 1-2, 3-4 | 1-3, 2-4 | 1-4, 2-3
    int[][] caseArr = new int[][]{{0, 1, 2, 3}, {0, 2, 1, 3}, {0, 3, 1, 2}};
    for (int i = 0; i < 3; i++) {
      double firstSlope = getSlope(caseArr[i][0], caseArr[i][1], dots);
      double secondSlope = getSlope(caseArr[i][2], caseArr[i][3], dots);

      if (firstSlope == secondSlope) {
        return 1;
      }
    }
    return 0;
  }

  public double getSlope(int firstIdx, int secondIdx, int[][] dots) {
    int[] first = dots[firstIdx];
    int[] second = dots[secondIdx];
    return (double) (second[1] - first[1]) / (second[0] - first[0]);
  }
}
