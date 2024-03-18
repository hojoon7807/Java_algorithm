package programmers;

public class 쿼드압축후개수세기 {

  static int oneCount = 0;
  static int zeroCount = 0;

  public int[] solution(int[][] arr) {
    compression(0,0,arr, arr.length);
    return new int[]{oneCount, zeroCount};
  }

  void compression(int startR, int startC, int[][] arr, int len){
    if (check(startR, startC, arr, len)) {
      if (arr[startR][startC] == 1) {
        oneCount++;
      }else {
        zeroCount++;
      }
    } else {
      int half = len/2;
      compression(startR, startC, arr, half);
      compression(startR + half, startC, arr, half);
      compression(startR, startC + half, arr, half);
      compression(startR + half, startC + half, arr, half);
    }
  }

  boolean check(int startR, int startC, int[][] arr, int len) {
    int value = -1;
    for (int i = startR; i < startR + len; i++) {
      for (int j = startC; j < startC+ len ; j++) {
        if (i == startR && j == startC) {
          value = arr[i][j];
        } else {
          if (value != arr[i][j]) {
            return false;
          }
        }
      }
    }
    return true;
  }



}
