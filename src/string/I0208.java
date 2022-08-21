package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class I0208 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] grades = br.readLine().split(" ");
    int[] answer = new int[N];

    for (int i = 0; i < N; i++) {
      answer[i] = 1;
      for (int j = 0; j < N; j++) {
        if (Integer.parseInt(grades[j]) > Integer.parseInt(grades[i])) {
          answer[i] += 1;
        }
      }
      System.out.print(answer[i] + " ");
    }
  }
}
