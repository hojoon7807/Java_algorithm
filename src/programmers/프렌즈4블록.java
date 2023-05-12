package programmers;

public class 프렌즈4블록 {

  private static char[][] blocks;
  private static int M, N;

  public static void main(String[] args) {
    solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"});
    solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"});
  }

  public static int solution(int m, int n, String[] board) {
    int answer = 0;
    M = m;
    N = n;
    blocks = new char[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        blocks[i][j] = board[i].charAt(j);
      }
    }

    while (true) {
      boolean isDelete = false;
      boolean[][] tmp = new boolean[M][N];
      for (int i = 0; i < m - 1; i++) {
        for (int j = 0; j < n - 1; j++) {
          if (blocks[i][j] == ' ') {
            continue;
          }
          if (check(i, j)) {
            tmp[i][j] = true;
            tmp[i + 1][j] = true;
            tmp[i][j + 1] = true;
            tmp[i + 1][j + 1] = true;
            isDelete = true;
          }
        }
      }

      if (!isDelete) {
        System.out.println(answer);
        return answer;
      }

      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (tmp[i][j]) {
            answer++;
            blocks[i][j] = ' ';
          }
        }
      }
      downBlocks();
    }
  }

  private static void downBlocks() {
    for (int col = 0; col < N; col++) {
      int lastEmptyIndex = -1;
      for (int row = 0; row < M; row++) {
        if (blocks[row][col] == ' ') {
          lastEmptyIndex = row;
        }
      }

      if (lastEmptyIndex == -1) {
        continue;
      }

      for (int i = lastEmptyIndex - 1; i >= 0; i--) {
        if (blocks[i][col] != ' ') {
          blocks[lastEmptyIndex][col] = blocks[i][col];
          blocks[i][col] = ' ';
          lastEmptyIndex--;
        }
      }
    }
  }

  private static boolean check(int row, int col) {
    char recent = blocks[row][col];

    if (blocks[row][col + 1] != recent || blocks[row + 1][col] != recent
        || blocks[row + 1][col + 1] != recent) {
      return false;
    }
    return true;
  }
}
