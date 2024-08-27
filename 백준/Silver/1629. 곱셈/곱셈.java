
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static long A, B, C;

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void input() throws IOException {
    String[] abc = br.readLine().split(" ");
    A = Long.parseLong(abc[0]);
    B = Long.parseLong(abc[1]);
    C = Long.parseLong(abc[2]);
  }

  static void solution() {
    System.out.println(divide(B));
  }

  static long divide(long n) {
    if (n == 1) {
      return A % C;
    }

    long mid = n / 2;
    long tmp = divide(mid);

    if (n % 2 == 1) {
      return ((tmp * tmp)%C * (A % C)) % C;
    } else {
      return (tmp * tmp) % C;
    }
  }
}
