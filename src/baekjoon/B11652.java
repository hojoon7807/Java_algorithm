package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B11652 {
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    HashMap<Long, Integer> map = new HashMap<>();

    for (int i = 0; i < N; i++) {
      Long num = Long.parseLong(br.readLine());

      map.put(num, map.getOrDefault(num, 0)+1);
    }

    int max = Integer.MIN_VALUE;

    long answer = 0;

    for (long key : map.keySet()) {
      Integer tmp = map.get(key);
      if (tmp > max) {
        max = tmp;
        answer = key;
      } else if (tmp == max) {
        answer = Math.min(key, answer);
      }
    }

    System.out.println(answer);
  }
}
