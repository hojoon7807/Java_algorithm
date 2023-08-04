package programmers;

import java.util.Arrays;

public class 행렬테두리회전하기 {

    static int[][] matrix;

    public static void main(String[] args) {
      solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}});
      solution(3, 3, new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}});
      solution(100, 97, new int[][]{{1, 1, 100, 97}});
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
      matrix = new int[rows][columns];

      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
          matrix[i][j] = i * columns + j + 1;
        }
      }

      int[] answer = new int[queries.length];
      for (int i = 0; i < queries.length; i++) {
        answer[i] = rotate(queries[i]);
      }
      System.out.println(Arrays.toString(answer));

      return answer;
    }

    public static int rotate(int[] query) {
      // 위
      int x1 = query[0] - 1;
      int y1 = query[1] - 1;
      int x2 = query[2] - 1;
      int y2 = query[3] - 1;

      //위
      int tmp = matrix[x1][y2];
      int min = tmp;

      for (int i = y2; i > y1; i--) {
        int value = matrix[x1][i - 1];

        min = Math.min(min, value);
        matrix[x1][i] = value;
      }
      // 오른쪽

      int tmp2 = matrix[x2][y2];
      min = Math.min(tmp2, min);
      for (int i = x2; i > x1; i--) {
        int value = matrix[i - 1][y2];
        min = Math.min(min, value);
        matrix[i][y2] = value;
      }
      matrix[x1 + 1][y2] = tmp;

      // 아래
      int tmp3 = matrix[x2][y1];
      min = Math.min(tmp3, min);
      for (int i = y1; i < y2; i++) {
        int value = matrix[x2][i + 1];
        min = Math.min(min, value);
        matrix[x2][i] = value;
      }
      matrix[x2][y2 - 1] = tmp2;
      // 왼쪽

      for (int i = x1; i < x2; i++) {
        int value = matrix[i + 1][y1];
        min = Math.min(min, value);
        matrix[i][y1] = value;
      }
      matrix[x2 - 1][y1] = tmp3;
      return min;
    }
}
