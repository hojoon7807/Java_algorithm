package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class B1339 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    ArrayList<String> list = new ArrayList<>();
    int[] alpha = new int[26];
    for (int i = 0; i < N; i++) {
      list.add(br.readLine());
    }

    for (int i = 0; i < N; i++) {
      String alphas = list.get(i);
      int tmp = (int) Math.pow(10, alphas.length() - 1);
      for (int j = 0; j < alphas.length(); j++) {
        alpha[alphas.charAt(j) - 'A'] += tmp;
        tmp /= 10;
      }
    }

    int num = 9;
    int sum = 0;
    Arrays.sort(alpha);

    for (int i = alpha.length - 1; i >= 0; i--) {
      sum += alpha[i] * num;
      num--;
    }

    System.out.println(sum);
  }
}
