import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n,r,q;
  static ArrayList<ArrayList<Integer>> connect = new ArrayList<>();
  static int[] visited;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    r = Integer.parseInt(input[1]);
    q = Integer.parseInt(input[2]);

    for (int i = 0; i <= n; i++) {
      connect.add(new ArrayList<>());
    }

    visited = new int[n + 1];

    for (int i = 0; i < n - 1; i++) {
      input = br.readLine().split(" ");
      int a = Integer.parseInt(input[0]);
      int b = Integer.parseInt(input[1]);

      connect.get(a).add(b);
      connect.get(b).add(a);
    }
    
    countTree(r);

    for (int i = 0; i < q; i++) {
      int u = Integer.parseInt(br.readLine());

      sb.append(visited[u]).append("\n");
    }

    System.out.println(sb);
  }

  static int countTree(int cur){
    visited[cur] = 1;

    for(int child : connect.get(cur)){
      if (visited[child] == 0) {
        visited[cur] += countTree(child);
      }
    }

    return visited[cur];
  }
}
