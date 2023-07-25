package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class B2493 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] heights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    Stack<Top> stack = new Stack<>();

    stack.add(new Top(heights[0], 1));

    StringBuilder sb = new StringBuilder();

    sb.append("0 ");
    for (int i = 1; i < n; i++) {
      while(!stack.isEmpty()){
        if(stack.peek().height > heights[i]) {
          sb.append(stack.peek().index + " ");
          break;
        }

        stack.pop();
      }

      if (stack.isEmpty()) {
        sb.append(0 + " ");
      }

      stack.add(new Top(heights[i], i+1));
    }

    System.out.println(sb);
  }

  private static class Top {
    int height;
    int index;

    public Top(int height, int index) {
      this.height = height;
      this.index = index;
    }
  }

}
