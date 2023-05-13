package programmers;

public class 삼각달팽이 {

  private static int[][] snail;
  private static int value = 1;

  public static void main(String[] args) {
    solution(4);
  }

  public static int[] solution(int n) {
    int len = n * (n + 1) / 2;
    int[] answer = new int[len];
    snail = new int[n][n];

    fill(-1, 0, n, 0);
    int index = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        answer[index++] = snail[i][j];
      }
    }
    return answer;
  }

  private static void fill(int row, int col, int len, int type) {
    if (len < 1) {
      return;
    }
    switch (type) {
      case 0:
        for (int i = 0; i < len; i++) {
          snail[++row][col] = value++;
        }
        for (int i = 1; i < len; i++) {
          snail[row][++col] = value++;
        }
        break;
      case 1:
        for (int i = 0; i < len; i++) {
          snail[--row][--col] = value++;
        }
        for (int i = 1; i < len; i++) {
          snail[++row][col] = value++;
        }
        break;
      case 2:
        for (int i = 0; i < len; i++) {
          snail[row][++col] = value++;
        }

        for (int i = 1; i < len; i++) {
          snail[--row][--col] = value++;

        }
        break;
    }

    fill(row, col, len - 2, (type + 1) % 3);
  }
}
