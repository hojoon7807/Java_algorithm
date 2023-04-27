package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class B10815 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    HashSet<Integer> set = new HashSet<>();
    String[] input = br.readLine().split(" ");

    for (int i = 0; i < N; i++) {
      set.add(Integer.parseInt(input[i]));
    }

    int M = Integer.parseInt(br.readLine());

    input = br.readLine().split(" ");
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < M; i++) {
      if (set.contains(Integer.parseInt(input[i]))) {
        sb.append(1 + " ");
      } else {
        sb.append(0 + " ");
      }
    }

    System.out.println(sb);
  }
}
