package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;

public class B12886 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int[] abc = new int[3];

    HashSet<int[]> set = new HashSet<>();

    boolean[][] isVisited = new boolean[1501][1501];

    for (int i = 0; i < 3; i++) {
      abc[i] = Integer.parseInt(input[i]);
    }

    if ((abc[0] + abc[1] + abc[2]) % 3 != 0) {
      System.out.println(0);
      return;
    }

    LinkedList<int[]> q = new LinkedList<>();
    q.add(new int[]{abc[0], abc[1], abc[2]});
    isVisited[abc[0]][abc[1]] = true;
  }
}

