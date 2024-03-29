
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int n,m;
  static boolean[] isVisited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] nm = br.readLine().split(" ");
    n = Integer.parseInt(nm[0]);
    m = Integer.parseInt(nm[1]);

    isVisited = new boolean[n + 1];

    StringBuilder sb = new StringBuilder();
    search(0, "", sb);

    System.out.println(sb);
  }

  static void search(int depth, String nums, StringBuilder sb){
    if (depth == m) {
      sb.append(nums).append("\n");
      return;
    }

    for (int i = 1; i <= n; i++) {
      if (!isVisited[i]) {
        isVisited[i] = true;
        search(depth + 1, nums + i + " ", sb);
        isVisited[i] = false;
      }
    }
  }

}
