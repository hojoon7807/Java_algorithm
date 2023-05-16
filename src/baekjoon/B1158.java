package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B1158 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int k = Integer.parseInt(input[1]);

    LinkedList<Integer> queue = new LinkedList<>();

    StringBuilder sb = new StringBuilder("<");
    for (int i = 1; i <= n; i++) {
      queue.add(i);
    }

    while (!queue.isEmpty()) {
      for (int i = 0; i < k-1; i++) {
        queue.add(queue.poll());
      }

      sb.append(queue.poll() + ", ");
    }
    sb.delete(sb.length()-2, sb.length());
    sb.append(">");
    System.out.println(sb);
  }
}
