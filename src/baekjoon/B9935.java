package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B9935 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String string = br.readLine();
    String pattern = br.readLine();

    StringBuilder sb = new StringBuilder();

    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < string.length(); i++) {
      stack.push(string.charAt(i));

      if (stack.size() >= pattern.length()) {
        boolean flag = true;

        for (int j = 0; j < pattern.length(); j++) {
          if (stack.get(stack.size() - pattern.length() + j) != pattern.charAt(j)) {
            flag = false;
            break;
          }
        }

        if (flag) {
          for (int j = 0; j < pattern.length(); j++) {
            stack.pop();
          }
        }
      }
    }

    for (Character character : stack) {
      sb.append(character);
    }

    System.out.println(sb.length() > 0 ? sb : "FRULA");

//    while (string.matches("\\w*" + explosionString + "\\w*")) {
//      string = string.replaceAll(explosionString, "");
//    }
//
//    if (string.equals("")) {
//      System.out.println("FRULA");
//    }else {
//      System.out.println(string);
//    }
  }

}
