package programmers;

import java.util.LinkedList;

public class 행렬과연산 {

  public static void main(String[] args) {
    solution(new int[][]{{1, 2}, {3, 4}}, new String[]{"Rotate", "Rotate"});
    solution(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
        new String[]{"Rotate", "ShiftRow"});
  }

  public static int[][] solution(int[][] rc, String[] operations) {

    int[][] answer = new int[rc.length][rc[0].length];

    int rLen = rc.length;
    int cLen = rc[0].length;

    LinkedList<Integer> left = new LinkedList<>();
    for (int i = 0; i < rLen; i++) {
      left.addLast(rc[i][0]);
    }

    LinkedList<LinkedList<Integer>> mid = new LinkedList<>();
    for (int i = 0; i < rLen; i++) {
      LinkedList<Integer> row = new LinkedList<>();
      for (int j = 1; j < cLen - 1; j++) {
        row.addLast(rc[i][j]);
      }
      mid.addLast(row);
    }

    LinkedList<Integer> right = new LinkedList<>();
    for (int i = 0; i < rLen; i++) {
      right.addLast(rc[i][cLen - 1]);
    }

    /*
    123      412
    456 ->   753
    789      896
     */

    for (String operation : operations) {
      if (operation.equals("Rotate")) {
        mid.getFirst().addFirst(left.removeFirst());
        right.addFirst(mid.getFirst().removeLast());

        mid.getLast().addLast(right.removeLast());
        left.addLast(mid.getLast().removeFirst());
      } else {
        left.addFirst(left.removeLast());
        mid.addFirst(mid.removeLast());
        right.addFirst(right.removeLast());
      }
    }

    for (int i = 0; i < rLen; i++) {
      answer[i][0] = left.removeFirst();
    }

    for (int i = 0; i < rLen; i++) {
      LinkedList<Integer> row = mid.removeFirst();
      for (int j = 1; j < cLen - 1; j++) {
        answer[i][j] = row.removeFirst();
      }
    }

    for (int i = 0; i < rLen; i++) {
      answer[i][cLen - 1] = right.removeFirst();
    }

    return answer;
  }

}
