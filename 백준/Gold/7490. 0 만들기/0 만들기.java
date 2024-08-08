import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int t;
  static int n;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    t = Integer.parseInt(br.readLine());

    while (t > 0) {
      n = Integer.parseInt(br.readLine());
      dfs(1, 1, 0, 1, "1");
      sb.append("\n");
      t--;
    }

    System.out.println(sb);
  }

  static void dfs(int depth, int num, int sum, int op, String s) {
    if (depth == n) {
      sum += num * op;

      if (sum == 0) {
        sb.append(s).append("\n");
      }
      return;
    }

    dfs(depth + 1, num * 10 + (depth + 1), sum, op, s + " " + (depth + 1));
    dfs(depth + 1, depth + 1, sum + (num * op), 1, s + "+" + (depth + 1));
    dfs(depth + 1, depth + 1, sum + (num * op), -1, s + "-" + (depth + 1));

  }

}
