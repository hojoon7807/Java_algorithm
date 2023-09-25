package programmers;

import java.util.LinkedList;

public class 큰수만들기 {

  public static void main(String[] args) {
    System.out.println(solution("4177252841", 4));
  }

  public static String solution(String number, int k) {
    LinkedList<Integer> linkedList = new LinkedList<>();
    int index = 1;
    int count = 0;

    linkedList.add(number.charAt(0) - '0');
    while (count < k && index < number.length()) {
      int num = number.charAt(index) - '0';
      if (linkedList.peekLast() < num) {
        while (!linkedList.isEmpty() && linkedList.peekLast() < num  && count < k) {
          linkedList.pollLast();
          count++;
        }
      }
      linkedList.add(num);
      index++;
    }

    if (count < k) {
      for (int i = 0; i < k - count; i++) {
        linkedList.pollLast();
      }
    } else {
      for (int i = index; i < number.length(); i++) {
        linkedList.add(number.charAt(i) - '0');
      }
    }

    StringBuilder sb = new StringBuilder();

    while (!linkedList.isEmpty()) {
      sb.append(linkedList.poll());
    }
    String answer = sb.toString();
    return answer;
  }
}
