package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B10610 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] split = br.readLine().split("");

    Arrays.sort(split);

    if (!split[0].equals("0")) {
      System.out.println("-1");
      return;
    }

    int sum = 0;
    StringBuilder sb = new StringBuilder();

    for (int i = split.length-1; i >= 0 ; i--) {
      sb.append(split[i]);
      sum += Integer.parseInt(split[i]);
    }

    if (sum % 3 == 0) {
      System.out.println(sb);
    }else {
      System.out.println("-1");
    }
  }

}
