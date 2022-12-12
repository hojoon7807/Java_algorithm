package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2285 {
  private static class Node{
    int x;
    int a;

    public Node(int x, int a) {
      this.x = x;
      this.a = a;
    }
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Node[] town = new Node[N];

    long population = 0;

    for (int i = 0; i < N; i++) {
      String[] input = br.readLine().split(" ");
      town[i] = new Node(Integer.parseInt(input[0]), Integer.parseInt(input[1]));

      population += Integer.parseInt(input[1]);
    }

    Arrays.sort(town, (n1, n2) -> {
      if (n1.x == n2.x) {
        return n1.a - n2.a;
      }
      return n1.x - n2.x;
    });

    long count = 0;
    for (int i = 0; i < N; i++) {
      count += town[i].a;

      if (count > population / 2) {
        System.out.println(town[i].x);
        break;
      }
    }
  }

}
