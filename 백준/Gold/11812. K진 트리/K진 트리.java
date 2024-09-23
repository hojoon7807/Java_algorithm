import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static long n, k, q;

  public static void main(String[] args) throws Exception {
    String[] input = br.readLine().split(" ");
    n = Long.parseLong(input[0]);
    k = Long.parseLong(input[1]);
    q = Long.parseLong(input[2]);

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < q; i++) {
      input = br.readLine().split(" ");

      long x = Long.parseLong(input[0]);
      long y = Long.parseLong(input[1]);

      // k == 1 ->

      if (k == 1) {
        sb.append(Math.abs(x - y)).append("\n");
        continue;
      }

      // 범위 = (parent * k) - (k-2) 부모 노드 * k + 1
      // 부모가 같을 때 까지 찾고 거리 리턴

      int count = 0;

      while (x != y) {
        long max = Math.max(x, y);
        y = Math.min(x, y);
        count ++;

        x = (max - 2) / k + 1;;
      }

      sb.append(count).append("\n");
    }

    System.out.println(sb);
  }

}
