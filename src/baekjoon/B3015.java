package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B3015 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Stack<int[]> stack = new Stack<>();
    long count = 0;
    for (int i = 0; i < N; i++) {
      int height = Integer.parseInt(br.readLine());
      int[] person = new int[]{height, 1};

      while(!stack.isEmpty() && stack.peek()[0] <= height){
        int[] pop = stack.pop();
        count += pop[1];

        if (height == pop[0]) {
          person[1] += pop[1];
        }
      }

      if (!stack.isEmpty()) {
        count ++;
      }
      stack.push(person);
    }

    System.out.println(count);
  }

}
