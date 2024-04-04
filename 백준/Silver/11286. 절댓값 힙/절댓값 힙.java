import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;

  /*
  개념 및 접근
  ------------------------
  - 우선순위 큐 사용
  - 정렬 기준 절대값이 작은 기준 -> 절대값이 같은 값이 있다면 작은 순으로
  - pq 비어있으면 0 출력
   */
  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> {
      int x = Math.abs(o1);
      int y = Math.abs(o2);

      if (x == y) {
        return o1 - o2;
      }
      return x - y;
    }));

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      Integer input = Integer.valueOf(br.readLine());
      if (input.equals(0)) {
        if (pq.isEmpty()) {
          sb.append(0).append("\n");
        } else {
          sb.append(pq.poll()).append("\n");
        }
      } else {
        pq.add(input);
      }
    }

    System.out.println(sb);
  }
}
