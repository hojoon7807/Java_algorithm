package programmers;

import java.util.LinkedList;

public class 괄호변환 {
  // "()))((()"
  // 1. u = "()" v = "))((()"
  // 2. answer = (), u = ))((, v = ()
  // 3. if not "" -> "(" -> "(())" ->  u = )( -> u = () -> "(())()"
  // 4. "()(())()"

  public String solution(String p) {
    if (p.equals("")) {
      return "";
    }
    // step 1
    int divideIndex = getDivideIndex(p);
    String u = p.substring(0, divideIndex + 1);
    String v = p.substring(divideIndex + 1, p.length());

    if (isCorrect(u)) {
      return u + solution(v);
    } else {

      return "(" + solution(v) + ")" + reverseString(u.substring(1, u.length() - 1));
    }
  }

  String reverseString(String s) {
    String reverse = "";

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        reverse += ")";
      } else {
        reverse += "(";
      }
    }
    return reverse;
  }

  int getDivideIndex(String p) {
    int openCount = 0;
    int closeCount = 0;
    int index = -1;
    for (int i = 0; i < p.length(); i++) {
      if (p.charAt(i) == '(') {
        openCount++;
      } else if (p.charAt(i) == ')') {
        closeCount++;
      }

      if (openCount == closeCount) {
        index = i;
        break;
      }
    }

    return index;
  }

  boolean isCorrect(String u) {
    LinkedList<Character> stack = new LinkedList<>();

    for (int i = 0; i < u.length(); i++) {
      char c = u.charAt(i);

      if (c == ')') {
        if (stack.isEmpty() || stack.peekLast() != '(') {
          return false;
        } else {
          stack.pollLast();
        }
      } else {
        stack.addLast(c);
      }
    }
    return true;
  }


}
