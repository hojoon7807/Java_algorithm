package programmers;

public class 혼자하는틱택토 {

  static int oBingo = 0;
  static int xBingo = 0;

  public int solution(String[] board) {
    int oCount = 0;
    int xCount = 0;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i].charAt(j) == 'O') {
          oCount++;
        } else if (board[i].charAt(j) == 'X') {
          xCount++;
        }
      }
    }

    if (oCount < xCount) {
      return 0;
    }
    if ((oCount - xCount) > 1) {
      return 0;
    }
    if (oCount == 0 && xCount == 0) {
      return 1;
    }

    for (int i = 0; i < 3; i++) {
      horizonalCheck(i, board);
      verticalCheck(i, board);
      if (i == 0 || i == 2) {
        diagonalCheck(i, board);
      }
    }

    if (oCount == xCount) {
      if (oBingo > xBingo || oBingo == 1) {
        return 0;
      }
    } else if ((oCount - xCount) == 1) {
      if (xBingo > oBingo || xBingo == 1) {
        return 0;
      }
    }

    return 1;
  }


  void horizonalCheck(int r, String[] board) {
    char tmp = 0;

    for (int i = 0; i < 3; i++) {
      char mark = board[r].charAt(i);
      if (mark == '.') {
        return;
      }
      if (i == 0) {
        tmp = mark;
        continue;
      }
      if (mark != tmp) {
        return;
      }
    }

    if (tmp == 'O') {
      oBingo++;
    } else if (tmp == 'X') {
      xBingo++;
    }
  }

  void verticalCheck(int c, String[] board) {
    char tmp = 0;
    for (int i = 0; i < 3; i++) {
      char mark = board[i].charAt(c);
      if (mark == '.') {
        return;
      }

      if (i == 0) {
        tmp = mark;
        continue;
      }
      if (mark != tmp) {
        return;
      }
    }

    if (tmp == 'O') {
      oBingo++;
    } else if (tmp == 'X') {
      xBingo++;
    }
  }

  void diagonalCheck(int index, String[] board) {
    char tmp = 0;
    if (index == 0) {
      for (int i = 0; i < 3; i++) {
        char mark = board[i].charAt(i);
        if (mark == '.') {
          return;
        }
        if (i == 0) {
          tmp = mark;
          continue;
        }
        if (mark != tmp) {
          return;
        }
      }
    } else {
      for (int i = 2; i >= 0; i--) {
        char mark = board[i].charAt(3 - i - 1);
        if (mark == '.') {
          return;
        }
        if (i == 2) {
          tmp = mark;
          continue;
        }
        if (mark != tmp) {
          return;
        }
      }
    }

    if (tmp == 'O') {
      oBingo++;
    } else if (tmp == 'X') {
      xBingo++;
    }
  }
}
