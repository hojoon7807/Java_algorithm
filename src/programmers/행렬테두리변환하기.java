package programmers;

import java.util.Arrays;

public class 행렬테두리변환하기 {

  public static void main(String[] args) {

    int rows = 3;
    int columns = 3;

    int[][] queries = {{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}};

    int[] result = solution(rows, columns, queries);
    System.out.println(Arrays.toString(result));
  }

  // PriorityQueue
//  public static int[] solution(int rows, int columns, int[][] queries) {
//    int[] answer = new int[queries.length];
//    int[][] map = new int[rows][columns];
//
//    int value = 0;
//    for (int i = 0; i < rows; i++) {
//      for (int j = 0; j < columns; j++) {
//        map[i][j] = ++value;
//      }
//    }
//
//    int index = 0;
//    for (int[] query : queries) {
//      PriorityQueue<Integer> queue = new PriorityQueue<>();
//      int x1 = query[0] - 1;
//      int y1 = query[1] - 1;
//      int x2 = query[2] - 1;
//      int y2 = query[3] - 1;
//
//      int tmp = map[x1][y2];
//      queue.add(tmp);
//      // 시계방향 회전 위
//      for (int i = y2; i > y1; i--) {
//        queue.add(map[x1][i]);
//        map[x1][i] = map[x1][i - 1];
//      }
//      // 왼쪽
//      for (int i = x1; i < x2; i++) {
//        queue.add(map[i][y1]);
//        map[i][y1] = map[i + 1][y1];
//      }
//      // 아래
//      for (int i = y1; i < y2; i++) {
//        queue.add(map[x2][i]);
//        map[x2][i] = map[x2][i + 1];
//      }
//      // 오른쪽
//      for (int i = x2; i > x1; i--) {
//        queue.add(map[i][y2]);
//        map[i][y2] = map[i - 1][y2];
//      }
//
//      map[x1+1][y2] = tmp;
//
//      answer[index] = queue.peek();
//      index++;
//    }
//
//    return answer;
//  }

  public static int[] solution(int rows, int columns, int[][] queries) {
    int[] answer = new int[queries.length];
    int[][] map = new int[rows][columns];

    int value = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        map[i][j] = ++value;
      }
    }

    int index = 0;
    for (int[] query : queries) {
      int x1 = query[0] - 1;
      int y1 = query[1] - 1;
      int x2 = query[2] - 1;
      int y2 = query[3] - 1;

      int tmp = map[x1][y2];
      int min = tmp;
      // 시계방향 회전 위
      for (int i = y2; i > y1; i--) {
        map[x1][i] = map[x1][i - 1];
        if(map[x1][i] < min) min = map[x1][i];
      }
      // 왼쪽
      for (int i = x1; i < x2; i++) {
        map[i][y1] = map[i + 1][y1];
        if(map[i][y1] < min) min = map[i][y1];
      }
      // 아래
      for (int i = y1; i < y2; i++) {
        map[x2][i] = map[x2][i + 1];
        if(map[x2][i] < min) min = map[x2][i];
      }
      // 오른쪽
      for (int i = x2; i > x1; i--) {
        map[i][y2] = map[i - 1][y2];
        if(map[i][y2] < min) min = map[i][y2];
      }

      map[x1+1][y2] = tmp;

      answer[index] = min;
      index++;
    }

    return answer;
  }
}
