package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B10816 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] cards= br.readLine().split(" ");
    int M = Integer.parseInt(br.readLine());
    String[] nums= br.readLine().split(" ");

    StringBuilder sb = new StringBuilder();

    HashMap<String, Integer> map = new HashMap<>();

    for (int i = 0; i <N; i++) {
      map.put(cards[i], map.getOrDefault(cards[i], 0) + 1);
    }

    for (int i = 0; i < M; i++) {
      sb.append(map.getOrDefault(nums[i], 0) + " ");
    }

    System.out.println(sb.toString());
  }
}
