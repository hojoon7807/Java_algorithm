package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B14232 {
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long k = Long.parseLong(br.readLine());

    ArrayList<Long> count = new ArrayList<>();

    for (long i = 2; i * i <= k; i++) {
      while (k % i == 0) {
        count.add(i);
        k /= i;
      }
    }

    if (k != 1) {
      count.add(k);
    }

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(count.size()).append("\n");

    for (Long jew : count) {
      stringBuilder.append(jew).append(" ");
    }

    System.out.println(stringBuilder);

  }

}
