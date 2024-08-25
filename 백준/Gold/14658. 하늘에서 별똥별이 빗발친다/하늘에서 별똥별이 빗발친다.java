import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, m, l, k;
  static ArrayList<int[]> list = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    m = Integer.parseInt(input[1]);
    l = Integer.parseInt(input[2]);
    k = Integer.parseInt(input[3]);

    for (int i = 0; i < k; i++) {
      input = br.readLine().split(" ");
      int x = Integer.parseInt(input[0]);
      int y = Integer.parseInt(input[1]);

      list.add(new int[]{x, y});
    }

    int max = 0;
    for (int[] x : list) {
      for (int[] y : list) {
        int count = 0;
        for (int[] s : list) {
          int tx = x[0] + l;
          int ty = y[1] + l;

          if (x[0] <= s[0] && s[0] <= tx && y[1] <= s[1] && s[1] <= ty) {
            count++;
          }
        }
        max = Math.max(max, count);

      }

    }

    System.out.println(k - max);
  }

}
