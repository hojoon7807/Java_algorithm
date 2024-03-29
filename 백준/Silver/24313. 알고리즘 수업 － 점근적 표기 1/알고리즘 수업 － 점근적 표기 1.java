import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int a1, a0, c, n0;

  public static void main(String[] args) throws IOException {
    String[] input = br.readLine().split(" ");
    a1 = Integer.parseInt(input[0]);
    a0 = Integer.parseInt(input[1]);
    c = Integer.parseInt(br.readLine());
    n0 = Integer.parseInt(br.readLine());

    for(int i = n0; i<= 100; i++){
      if (f(i) > c * g(i)) {
        System.out.println(0);
        return;
      }
    }

    System.out.println(1);
  }

  static int f(int n) {
    return a1 * n + a0;
  }

  static int g(int n) {
    return n;
  }

}
