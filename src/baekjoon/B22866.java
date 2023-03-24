package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B22866 {

  static int N;
  static int[] heights;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    heights = new int[N];

    String[] split = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      heights[i] = Integer.parseInt(split[i]);
    }

    int[][] count = new int[N][2];

    StringBuilder sb = new StringBuilder();
    Stack<Building> stack = new Stack<>();


    for (int i = 0; i < N; i++) {
      while (!stack.isEmpty() && stack.peek().height <= heights[i]) {
        stack.pop();
      }

      if (stack.isEmpty()) {
        count[i] = new int[]{0, 0};
      } else {
        count[i] = new int[]{stack.size(), stack.peek().index};
      }

      stack.push(new Building(i + 1, heights[i]));
    }

    stack.clear();

    for (int i = N-1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek().height <= heights[i]) {
        stack.pop();
      }

      if (!stack.isEmpty()) {
        count[i][0] += stack.size();
        int now = count[i][1];

        if (now == 0 || Math.abs(now - i - 1) > Math.abs(stack.peek().index - i - 1)) {
          count[i][1] = stack.peek().index;
        }
      }

      stack.push(new Building(i + 1, heights[i]));
    }

    for (int i = 0; i < N; i++) {
      if (count[i][0] == 0) {
        sb.append(0 + "\n");
      } else {
        sb.append(count[i][0] + " " + count[i][1] + "\n");
      }
    }

    System.out.println(sb);
  }

  static private class Building {
    int index;
    int height;

    public Building(int index, int height) {
      this.index = index;
      this.height = height;
    }
  }
}
