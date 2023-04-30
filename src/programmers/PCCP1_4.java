package programmers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class PCCP1_4 {

  public static void main(String[] args) throws IOException {
    solution(new int[][]{{2, 0, 10}, {1, 5, 5}, {3, 5, 3}, {3, 12, 2}});
  }

  public static long[] solution(int[][] program) {
    LinkedList<Program> queue = Arrays.stream(program).map(Program::new)
        .sorted(Comparator.comparing(p -> p.calledTime))
        .collect(
            Collectors.toCollection(LinkedList::new));

    PriorityQueue<Program> waitQ = new PriorityQueue<>((o1, o2) -> {
      if (o1.priority != o2.priority) {
        return o1.priority - o2.priority;
      } else {
        return o1.calledTime - o2.calledTime;
      }
    });

    long[] answer = new long[11];
    long time = 0;
    while (!queue.isEmpty() || !waitQ.isEmpty()) {
      // 호출한 큐가 실행된 시간보다 빠를때까지 대기 큐에 집어 넣는다.
      while (!queue.isEmpty() && time >= queue.peek().calledTime) {
        waitQ.add(queue.poll());
      }

      // 대기 큐가 비어있으면 실행완료 시점까지 호출된 프로그램이 없으므로 시간을 갱신시켜준다.
      if (waitQ.isEmpty()) {
        time = queue.peek().calledTime;
        continue;
      }

      Program recent = waitQ.poll();
      answer[recent.priority] += time - recent.calledTime;
      time += recent.executeTime;
    }
    answer[0] = time;

    return answer;
  }

  private static class Program {
    int priority;
    int calledTime;
    int executeTime;

    public Program(int[] arr) {
      this.priority = arr[0];
      this.calledTime = arr[1];
      this.executeTime = arr[2];
    }
  }

}
