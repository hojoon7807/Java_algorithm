package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class B12886 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int[] abc = new int[3];

    boolean[][] isVisited = new boolean[1501][1501];

    for (int i = 0; i < 3; i++) {
      abc[i] = Integer.parseInt(input[i]);
    }
    Arrays.sort(abc);

    if ((abc[0] + abc[1] + abc[2]) % 3 != 0) {
      System.out.println(0);
      return;
    }

    LinkedList<int[]> q = new LinkedList<>();

    q.add(abc);
    isVisited[abc[0]][abc[1]] = true;

    while (!q.isEmpty()) {
      int[] recent = q.poll();
      int a = recent[0];
      int b = recent[1];
      int c = recent[2];

      if (a == b && b == c) {
        System.out.println(1);
        return;
      }

      if (a != b) {
        int na = a * 2;
        int nb = b - a;
        int[] nArr = {na, nb, c};
        Arrays.sort(nArr);
        if (!isVisited[nArr[0]][nArr[1]]) {
          isVisited[nArr[0]][nArr[1]] = true;
          q.add(nArr);
        }
      }

      if (a != c) {
        int na = a * 2;
        int nc = c - a;
        int[] nArr = {na, b, nc};
        Arrays.sort(nArr);
        if (!isVisited[nArr[0]][nArr[1]]) {
          isVisited[nArr[0]][nArr[1]] = true;
          q.add(nArr);
        }
      }
    }
    System.out.println(0);
  }

}

