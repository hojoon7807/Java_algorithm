package programmers;

import java.util.Stack;

public class 괄호회전하기 {

  public int solution(String s) {
    int answer = 0;
    int x = 0;
    Stack<Character> stack = new Stack();

    while (x < s.length()) {
      int count = 0;
      stack.clear();
      for (int i = x; i < s.length(); i = (i + 1) % s.length()) {
        if (count == s.length()) {
          break;
        }
        if (i == x) {
          if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
            stack.push(s.charAt(i));
            break;
          }
        }
        if (stack.isEmpty()) {
          stack.push(s.charAt(i));
          count++;
          continue;
        }
        Character peek = stack.peek();
        switch (s.charAt(i)) {
          case ')' -> {
            if (peek == '(') {
              stack.pop();
            }
          }
          case ']' -> {
            if (peek == '[') {
              stack.pop();
            }
          }
          case '}' -> {
            if (peek == '{') {
              stack.pop();
            }
          }
          default -> stack.push(s.charAt(i));
        }
        count++;
      }
      if (stack.isEmpty()) {
        answer++;
      }
      x++;
    }
    return answer;
  }

}
