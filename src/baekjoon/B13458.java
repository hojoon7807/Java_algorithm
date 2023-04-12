package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B13458 {
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] people = new int[N];
    String[] input = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      people[i] = Integer.parseInt(input[i]);
    }

    input = br.readLine().split(" ");
    int B = Integer.parseInt(input[0]);
    int C = Integer.parseInt(input[1]);

    long result = 0;
    for (int i = 0; i < N; i++) {
      int recent = people[i];

      result ++;
      recent -= B;

      if (recent <= 0) {
        continue;
      }
      if (recent % C == 0) {
        result += recent/C;
      } else {
        result += recent/C + 1;
      }
    }

    System.out.println(result);
  }

}
