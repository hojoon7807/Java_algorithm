package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class I0204 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] answer = new int[N];

    for (int i = 0; i < N; i++) {
      if (i < 2) {
        answer[i] = 1;
      } else {
        answer[i] = answer[i - 1] + answer[i - 2];
      }
    }

    for (int i : answer) {
      System.out.print(i + " ");
    }
  }
}
