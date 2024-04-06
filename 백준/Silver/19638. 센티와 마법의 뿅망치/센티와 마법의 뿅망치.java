import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, hc, t;

  public static void main(String[] args) throws IOException {
    String[] input = br.readLine().split(" ");

    n = Integer.parseInt(input[0]);
    hc = Integer.parseInt(input[1]);
    t = Integer.parseInt(input[2]);

    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    for (int i = 0; i < n; i++) {
      pq.add(Integer.parseInt(br.readLine()));
    }

    int count = 0;

    while (t > count) {
      if (pq.peek() < hc) {
        break;
      }

      if (pq.peek() == 1) {
        break;
      }

      Integer max = pq.poll();
      count++;
      pq.add(max >> 1);
    }

    if (pq.peek() < hc) {
      System.out.println("YES");
      System.out.println(count);
    } else {
      System.out.println("NO");
      System.out.println(pq.peek());
    }

  }

}
