package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1091 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] p = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    int[] card = new int[n];
    int[] shuffleCard = new int[n];

    for (int i = 0; i < n; i++) {
      card[i] = i;
      shuffleCard[i] = i;
    }

    int count = 0;

    if (isSameOrder(card, p)) {
      System.out.println(count);
      return;
    }

    while (true) {
      count++;
      shuffle(shuffleCard, s);

      if (isSame(card, shuffleCard)) {
        System.out.println(-1);
        return;
      }

      if (isSameOrder(shuffleCard, p)) {
        System.out.println(count);
        return;
      }
    }
  }

  private static boolean isSameOrder(int[] shuffleCard, int[] p) {
    for (int i = 0; i < p.length; i++) {
      int order = i % 3;
      if (p[shuffleCard[i]] != order) {
        return false;
      }
    }
    return true;
  }

  private static void shuffle(int[] shuffleCard, int[] s) {
    int[] tmp = shuffleCard.clone();
    for (int i = 0; i < s.length; i++) {
      shuffleCard[s[i]] = tmp[i];
    }
  }

  private static boolean isSame(int[] a, int[] b) {
    for (int i = 0; i < a.length; i++) {
      if (a[i] != b[i]) {
        return false;
      }
    }

    return true;
  }

}
