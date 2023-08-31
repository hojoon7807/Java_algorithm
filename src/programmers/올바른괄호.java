package programmers;

import java.util.LinkedList;

public class 올바른괄호 {
  boolean solution(String s) {
    LinkedList<Character> stack = new LinkedList<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(stack.isEmpty()){
        if(c == ')'){
          return false;
        } else {
          stack.push(c);
        }
      } else {
        if(c == '('){
          stack.push(c);
        } else {
          stack.pop();
        }
      }
    }
    return stack.isEmpty() ? true : false;
  }

}
