package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class B1427 {
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split("");

    Arrays.sort(input, Comparator.reverseOrder());

    StringBuilder sb = new StringBuilder();

    for (String s : input) {
      sb.append(s);
    }

    System.out.println(sb);
  }

}
