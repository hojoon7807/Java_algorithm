package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B1920 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

    String[] input = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      map.put(Integer.parseInt(input[i]), true);
    }

    int M = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    input = br.readLine().split(" ");

    for (int i = 0; i < M; i++) {
      if (map.get(Integer.parseInt(input[i]))== null) {
        sb.append(0 + "\n");
      } else {
        sb.append(1 + "\n");
      }
    }

    System.out.println(sb);
  }

}
