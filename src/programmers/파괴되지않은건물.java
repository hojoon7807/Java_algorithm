package programmers;

// 누적합
public class 파괴되지않은건물 {

  public int solution(int[][] board, int[][] skill) {
    int answer = 0;
    int rowLen = board.length;
    int colLen = board[0].length;
    int[][] acc = new int[rowLen + 1][colLen + 1];

    for (int[] game : skill) {
      int type = game[0];
      int r1 = game[1];
      int c1 = game[2];
      int r2 = game[3];
      int c2 = game[4];
      int degree = game[5];
      if (type == 1) {
        acc[r1][c1] += -degree;
        acc[r2 + 1][c2 + 1] += -degree;
        acc[r1][c2 + 1] += degree;
        acc[r2 + 1][c1] += degree;
      } else {
        acc[r1][c1] += degree;
        acc[r2 + 1][c2 + 1] += degree;
        acc[r1][c2 + 1] += -degree;
        acc[r2 + 1][c1] += -degree;
      }
    }

    for (int i = 0; i < rowLen; i++) {
      for (int j = 1; j < colLen; j++) {
        acc[i][j] += acc[i][j - 1];
      }
    }

    for (int i = 0; i < colLen; i++) {
      for (int j = 1; j < rowLen; j++) {
        acc[j][i] += acc[j - 1][i];
      }
    }

    for (int i = 0; i < rowLen; i++) {
      for (int j = 0; j < colLen; j++) {
        board[i][j] += acc[i][j];
      }
    }

    for (int i = 0; i < rowLen; i++) {
      for (int j = 0; j < colLen; j++) {
        if (board[i][j] >= 1) {
          answer++;
        }
      }
    }
    return answer;
  }
}
