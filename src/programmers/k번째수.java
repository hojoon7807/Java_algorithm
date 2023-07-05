package programmers;

import java.util.Arrays;

public class k번째수 {

  public static void main(String[] args) {
    solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
  }
  public static int[] solution(int[] array, int[][] commands) {
    int[] answer = new int[commands.length];
    int index = 0;
    for (int[] command : commands) {
      int[] arr = new int[command[1] - command[0] + 1];

      for (int i = 0; i <arr.length; i++) {
        arr[i] = array[command[0] - 1 + i];
      }

      Arrays.sort(arr);

      answer[index] = arr[command[2]-1];
      index++;
    }

    return answer;
  }
}
