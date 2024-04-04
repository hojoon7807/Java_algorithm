import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;

  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    int answer = 0;

    for (int i = 0; i < n; i++) {
      pq.add(Integer.valueOf(br.readLine()));
    }

    if (n == 1) {
      System.out.println(0);
      return;
    }

    while (!pq.isEmpty()) {
      int x = pq.poll();
      int y = pq.poll();

      int compare = x+y;
      answer += compare;

      if (!pq.isEmpty()) {
        pq.add(compare);
      }
    }

    System.out.println(answer);
  }

}
