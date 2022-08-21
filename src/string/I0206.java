package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class I0206 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] strings = br.readLine().split(" ");

    for (int i = 0; i < N; i++) {
      String reverse = new StringBuilder(strings[i]).reverse().toString();
      int num = Integer.parseInt(reverse);
      if (isPrime(num)) {
        System.out.print(num + " ");
      }
    }

  }

  public static boolean isPrime(int num) {
    boolean[] arr = new boolean[num + 1];
    arr[0] = true;
    arr[1] = true;
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (!arr[i]) {
        for (int j = i * i; j <= num; j += i) {
          arr[j] = true;
        }
      }
    }

    if (!arr[num]) {
      return true;
    }
    return false;
  }

}
