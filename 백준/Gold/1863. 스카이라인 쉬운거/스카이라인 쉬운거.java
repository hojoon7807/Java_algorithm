import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;

  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());

    Stack<Integer> stack = new Stack<>();

    int count = 0;

    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      int x = Integer.parseInt(input[0]);
      int y = Integer.parseInt(input[1]);

      while (!stack.isEmpty() && stack.peek() >= y) {
        if (stack.peek() > y) {
          count ++;
          stack.pop();
        } else {
          stack.pop();
        }
      }

      if (y != 0) {
        stack.push(y);
      }
    }

    while (!stack.isEmpty()) {
      count ++;
      stack.pop();
    }

    System.out.println(count);
  }
}




