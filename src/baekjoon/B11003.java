package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B11003 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());

    LinkedList<Node> deque = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < N; i++) {
      int now = Integer.parseInt(st.nextToken());

      while (!deque.isEmpty() && deque.getLast().value >= now) {
        deque.removeLast();
      }

      deque.add(new Node(i, now));

      if (deque.getFirst().index <= i - L) {
        deque.removeFirst();
      }

      sb.append(deque.getFirst().value + " ");
    }

    System.out.println(sb);
  }
  
  private static class Node {
    int index;
    int value;

    public Node(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }

}
