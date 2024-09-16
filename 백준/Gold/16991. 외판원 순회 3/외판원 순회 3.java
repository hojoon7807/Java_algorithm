import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static double[][] dp;
  static double INF = 123456789;
  static Point[] points;

  public static void main(String[] args) throws Exception{
    n = Integer.parseInt(br.readLine());
    points = new Point[n];

    for (int i = 0; i < n; i++) {
      String[] xy = br.readLine().split(" ");

      int x = Integer.parseInt(xy[0]);
      int y = Integer.parseInt(xy[1]);

      points[i] = new Point(x, y);
    }

    dp = new double[n][1 << n];

    // dp 초기화 각 노드에서 모든 노드 방문 가능
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], INF);
    }

    System.out.println(tsp(0, 1));
  }

  static double tsp(int start, int visited) {
    if (visited == (1 << n) - 1) {
      return points[start].calDist(points[0]);
    }

    if (dp[start][visited] != INF) {
      return dp[start][visited];
    }

    for (int i = 1; i < n; i++) {
      if((visited & (1<<i)) == 0){
        dp[start][visited] = Math.min(dp[start][visited],
            tsp(i, visited | (1 << i)) + points[start].calDist(points[i]));
      }
    }

    return dp[start][visited];
  }

  static class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    double calDist(Point point) {
      return Math.sqrt(Math.pow(this.x - point.x, 2) + Math.pow(this.y - point.y, 2));
    }
  }

}
