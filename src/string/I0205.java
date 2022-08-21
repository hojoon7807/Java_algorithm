package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class I0205 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    boolean[] arr = new boolean[N + 1];

    int count = 0;

    arr[0] = true;
    arr[1] = true;

    for (int i = 2; i <= N ; i++) {
      if(arr[i]) continue;

      for (int j = 2 * i; j <= N; j += i) {
        arr[j] = true;
      }
    }

    for (boolean b : arr) {
      if(!b) count ++;
    }

    System.out.println(count);
  }
}
