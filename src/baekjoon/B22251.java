package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B22251 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int k = Integer.parseInt(input[1]);
    int p = Integer.parseInt(input[2]);
    int x = Integer.parseInt(input[3]);

    String[] floors = new String[]{
        "1011111",
        "0000101",
        "1110110",
        "1110101",
        "0101101",
        "1111001",
        "1111011",
        "1000101",
        "1111111",
        "1111101"
    };

    int answer = 0;

    for (int i = 1; i <= n; i++) {
      if (i == x) {
        continue;
      }

      int count = 0;
      int start = x;
      int end = i;
      for (int j = 0; j < k; j++) {
        for (int l = 0; l < 7; l++) {
          if (floors[start%10].charAt(l) != floors[end%10].charAt(l)) {
            count++;
          }
        }
        start /= 10;
        end /= 10;
      }

      if (count <= p) {
        answer++;
      }
    }

    System.out.println(answer);
  }
}
