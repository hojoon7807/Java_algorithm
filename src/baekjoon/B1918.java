package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1918 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static String expression;

  public static void main(String[] args) throws IOException {
    input();
  }

  static void input() throws IOException {
    expression = br.readLine();
    solution();
  }

  static void solution() {
    StringBuilder sb = new StringBuilder();
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < expression.length(); i++) {
      char c = expression.charAt(i);
      if (c >= 'A' && c <= 'Z') {
        sb.append(c);
        continue;
      }

      if (c == '(') {
        stack.add(c);
        continue;
      }

      // ( 까지 제거
      if (c == ')') {
        while (stack.peek() != '(') {
          sb.append(stack.pop());
        }

        stack.pop();
        continue;
      }

      if (stack.empty() || stack.peek() == '(') {
        stack.add(c);
        continue;
      }

      // (1 + 2 * 3 + 1)
      // ( + *
      // 1 2 3 * +
      if (c == '+' || c == '-') {
        // 스택에 있는 연산자 보다 우선순위가 같거나 낮으면
        while (!stack.empty() && stack.peek() != '(') {
          sb.append(stack.pop());
        }
        stack.add(c);
      } else {
        if (stack.peek() == '*' || stack.peek() == '/') {
          sb.append(stack.pop());
        }
        stack.add(c);
      }
    }

    while (!stack.empty()) {
      sb.append(stack.pop());
    }

    System.out.println(sb);

    // ( + *
    // 3546-*2/+
  }

}
