package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B11286 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
      if(Math.abs(o1) == Math.abs(o2)) {
        return o1 - o2;
      } else {
        return Math.abs(o1) - Math.abs(o2);
      }
    });
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      int input = Integer.parseInt(br.readLine());

      if (input == 0) {
        if (queue.isEmpty()) {
          sb.append(0 + "\n");
        } else{
          sb.append(queue.poll() + "\n");
        }
      } else {
        queue.add(input);
      }
    }

    System.out.println(sb);
  }
}
