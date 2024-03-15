package programmers;

import java.util.LinkedList;

public class 택배상자 {

  public static void main(String[] args) {
    System.out.println(solution(new int[]{4, 3, 1, 2, 5}));
    System.out.println(solution(new int[]{5,4,3,2,1}));
    System.out.println(solution(new int[]{3,5,4,2,1}));
  }

  public static int solution(int[] order) {
    // 4 3 1 2 5
    LinkedList<Integer> main = new LinkedList<>();
    LinkedList<Integer> sub = new LinkedList<>();

    for(int i=0;i<order.length; i++){
      main.add(order[i]);
    }

    int answer = 0;

    for (int i = 1; i <= order.length ; i++) {
      sub.add(i);
      while (!sub.isEmpty() && sub.peekLast().equals(main.peek())) {
        sub.pollLast();
        main.poll();
        answer++;
      }
    }

    return answer;
  }

}
