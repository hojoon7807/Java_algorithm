package programmers;

public class 쿼드압축후개수세기 {

  static int oneCount = 0;
  static int zeroCount = 0;

  public int[] solution(int[][] arr) {
    compression(0, 0, arr, arr.length);
    int[] answer = new int[]{zeroCount, oneCount};
    return answer;
  }

  private void compression(int startR, int startC, int[][] arr, int size) {
    if (check(startR, startC, size, arr)) {
      if (arr[startR][startC] == 1) {
        oneCount++;
      } else {
        zeroCount++;
      }
    } else {
      int halfSize = size / 2;
      compression(startR, startC, arr, halfSize);
      compression(startR + halfSize, startC, arr, halfSize);
      compression(startR, startC + halfSize, arr, halfSize);
      compression(startR + halfSize, startC + halfSize, arr, halfSize);
    }
  }

  private boolean check(int startR, int startC, int size, int[][] arr) {
    int tmp = arr[startR][startC];
    for (int i = startR; i < startR + size; i++) {
      for (int j = startC; j < startC + size; j++) {
        if (arr[i][j] != tmp) {
          return false;
        }
      }
    }

    return true;
  }

}
