import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n,m;

  /*
  개념 및 접근
  -----------------------
  - 합체한 카드를 최소로 만드려면 카드를 뽑을 때 마다 최소의 2장을 뽑아서 합치면 된다.
  - 우선순위 큐를 사용해 최소값 뽑기
  - 합체한 카드로 값 변경
  - 합체한 카드를 다시 큐에 집어 넣기
   */

  public static void main(String[] args) throws IOException {
    String[] nm = br.readLine().split(" ");

    n = Integer.parseInt(nm[0]);
    m = Integer.parseInt(nm[1]);

    PriorityQueue<Long> pq = new PriorityQueue<>();

    String[] input = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      pq.add(Long.parseLong(input[i]));
    }

    for (int i = 0; i < m; i++) {
      Long x = pq.poll();
      Long y = pq.poll();

      long sum = Long.sum(x, y);

      pq.add(sum);
      pq.add(sum);
    }

    long answer = 0;

    while (!pq.isEmpty()) {
      answer += pq.poll();
    }

    System.out.println(answer);
  }

}
