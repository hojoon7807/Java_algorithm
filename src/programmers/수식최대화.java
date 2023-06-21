package programmers;

import java.util.ArrayList;

public class 수식최대화 {

  static boolean[] operationVisited = new boolean[3];
  static String[] operation = {"+", "-", "*"};
  static long max = -1;

  public static void main(String[] args) {
    수식최대화 s = new 수식최대화();
    s.solution("50*6-3*2");
  }

  public long solution(String expression) {
    ArrayList<String> splitExpression = splitExpression(expression);
    backtracking(0, splitExpression);
    return max;
  }

  void backtracking(int count, ArrayList<String> expression) {
    if (count == 3) {
      max = Math.max(max, Math.abs(Long.parseLong(expression.get(0))));
    }
    ;
    for (int i = 0; i < 3; i++) {
      if (!operationVisited[i]) {
        operationVisited[i] = true;
        backtracking(count + 1, cal(i, expression));
        operationVisited[i] = false;
      }
    }
  }

  ArrayList<String> cal(int operationIndex, ArrayList<String> expression) {
    ArrayList<String> newExpression = new ArrayList<>(expression);
    for (int i = 0; i < newExpression.size(); i++) {
      String tmp = newExpression.get(i);
      if (tmp.equals(operation[operationIndex])) {
        long result = switch (tmp) {
          case "+" -> {
            long left = Long.parseLong(newExpression.get(i - 1));
            long right = Long.parseLong(newExpression.get(i + 1));
            yield left + right;
          }
          case "-" -> {
            long left = Long.parseLong(newExpression.get(i - 1));
            long right = Long.parseLong(newExpression.get(i + 1));
            yield left - right;

          }
          case "*" -> {
            long left = Long.parseLong(newExpression.get(i - 1));
            long right = Long.parseLong(newExpression.get(i + 1));
            yield left * right;
          }
          default -> 0;
        };
        newExpression.remove(i - 1);
        newExpression.remove(i - 1);
        newExpression.remove(i - 1);
        newExpression.add(i - 1, String.valueOf(result));
        i--;
      }
    }
    return newExpression;
  }

  ArrayList<String> splitExpression(String expression) {
    int startIndex = 0;
    ArrayList<String> split = new ArrayList<>();
    for (int i = 0; i < expression.length(); i++) {
      char tmp = expression.charAt(i);
      if (i == expression.length() - 1) {
        split.add(expression.substring(startIndex, expression.length()));
      }
      if (!Character.isDigit(tmp)) {
        split.add(expression.substring(startIndex, i));
        split.add(String.valueOf(tmp));
        startIndex = i + 1;
      }
    }

    return split;
  }

}
