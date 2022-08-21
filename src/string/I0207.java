package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class I0207 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] strings = br.readLine().split(" ");

    int sum = 0;
    int count = 0;

    for (int i = 0; i < N; i++) {
      switch (strings[i]) {
        case "1":
          count ++;
          sum += count;
          break;
        case "0":
          //sum += count;
          count = 0;
      }
    }

    System.out.println(sum);
  }

}
