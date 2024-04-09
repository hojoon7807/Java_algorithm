import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n,m;
  static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    m = Integer.parseInt(input[1]);

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < m; i++) {
      input = br.readLine().split(" ");
      int a = Integer.parseInt(input[0]);
      int b = Integer.parseInt(input[1]);
      int c = Integer.parseInt(input[2]);

      graph.get(a).add(new Node(b, c));
      graph.get(b).add(new Node(a, c));

      max = Math.max(max, c);
      min = Math.min(min, c);
    }

    input = br.readLine().split(" ");

    int start = Integer.parseInt(input[0]);
    int end = Integer.parseInt(input[1]);

    max += 1;

    while(min + 1 < max){
      int mid = (min + max) >> 1;
      if(canMove(mid, start, end)){
        min = mid;
      } else {
        max = mid;
      }
    }

    System.out.println(min);
  }

  static boolean canMove(int mid, int start, int end){
    boolean[] isVisited = new boolean[n + 1];
    LinkedList<Integer> q = new LinkedList<>();
    isVisited[start] = true;
    q.add(start);

    while (!q.isEmpty()) {
      Integer cur = q.poll();

      if (cur == end) {
        return true;
      }

      for (Node next : graph.get(cur)) {
        if (!isVisited[next.to] && next.cost >= mid) {
          q.add(next.to);
          isVisited[next.to] = true;
        }
      }
    }

    return false;
  }

  static class Node {
    int to;
    int cost;

    public Node(int to, int cost) {
      this.to = to;
      this.cost = cost;
    }
  }

}
