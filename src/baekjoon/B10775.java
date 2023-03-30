package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10775 {

  private static int[] gate;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int G = Integer.parseInt(br.readLine());
    int P = Integer.parseInt(br.readLine());

    gate = new int[G + 1];
    int answer = 0;

    for (int i = 0; i <= G; i++) {
      gate[i] = i;
    }

    for (int i = 1; i <= P; i++) {
      int g = Integer.parseInt(br.readLine());
      int gateCount = find(g);

      if (gateCount == 0) {
        break;
      }
      answer++;
      union(gateCount, gateCount - 1);
    }
    System.out.println(answer);
  }

  private static int find(int index) {
    if (index == gate[index]) {
      return index;
    }
    gate[index] = find(gate[index]);
    return gate[index];
  }

  private static void union(int a, int b) {
    a = find(a);
    b = find(b);

    if (a != b) {
      gate[a] = b;
    }
  }
}
