import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static int[][] w;
  static boolean[] isVisited;
  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws Exception {
    n = Integer.parseInt(br.readLine());
    w = new int[n][n];
    isVisited = new boolean[n];

    for (int i = 0; i < n; i++) {
      w[i] = Arrays.stream(br.readLine().split(" "))
                   .mapToInt(Integer::parseInt)
                   .toArray();
    }

    isVisited[0] = true;
    dfs(0, 0, 1);
    System.out.println(min);
  }

  static void dfs(int start, int cost, int count){
    if(count == n){
      if(w[start][0] == 0){
        return;
      }

      min = Math.min(min, cost + w[start][0]);
      return;
    }

    for (int i = 1; i < n; i++) {
      if (!isVisited[i] && w[start][i] != 0) {
        isVisited[i] = true;
        dfs(i, cost + w[start][i], count + 1);
        isVisited[i] = false;
      }
    }
  }

}
