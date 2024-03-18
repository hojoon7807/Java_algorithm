package programmers;

import java.util.LinkedList;

public class 큰수만들기 {

  public static void main(String[] args) {
    System.out.println(solution("4177252841", 4));
  }

  public static String solution(String number, int k) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    list.add(number.charAt(0) - '0');

    StringBuilder sb = new StringBuilder();

    for (int i = 1; i < number.length(); i++) {
      int num = number.charAt(i) - '0';
      while (!list.isEmpty() && list.peekLast() < num && k > 0) {
        list.pollLast();
        k--;
      }

      list.add(num);
    }

    if (k > 0) {
      for (int i = 0; i < k; i++) {
        list.pollLast();
      }
    }

    while (!list.isEmpty()) {
      sb.append(list.poll());
    }
    return sb.toString();
  }
}
