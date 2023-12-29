package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B16472 {

  private static int n;
  private static int answer = 0;
  private static String input;
  private static char[] alphas = new char[26];
  private static int kind = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    input = br.readLine();

    solution();

    System.out.println(answer);
  }

  private static void solution() {
    int left = 0;
    for (int right = 0; right < input.length(); right++) {
      add(right);
      while (kind > n) {
        remove(left++);
      }

      answer = Math.max(answer, right - left + 1);
    }
  }

  private static void add(int index) {
    int alpha = input.charAt(index) - 'a';
    if (alphas[alpha] == 0) {
      kind++;
    }

    alphas[alpha]++;
  }

  private static void remove(int index) {
    int alpha = input.charAt(index) - 'a';
    alphas[alpha]--;
    if (alphas[alpha] == 0) {
      kind--;
    }
  }


}
