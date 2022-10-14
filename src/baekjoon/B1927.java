package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B1927 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(br.readLine());
      if (num == 0) {
        if (queue.isEmpty()) {
          sb.append(0 + "\n");
          continue;
        }
        sb.append(queue.poll() + "\n");
        continue;
      }
      queue.add(num);
    }

    System.out.println(sb);
  }

}
