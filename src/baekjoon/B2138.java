package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2138 {
  static int N;
  static boolean[] lightA;
  static boolean[] lightB;
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  N = Integer.parseInt(br.readLine());

  lightA = new boolean[N];
  lightB = new boolean[N];

  String[] split = br.readLine().split("");

  for (int i = 0; i < N; i++) {
    lightA[i] = split[i].equals("1");
  }

  split = br.readLine().split("");

  for (int i = 0; i < N; i++) {
    lightB[i] = split[i].equals("1");
  }

  if (N == 2) {

  }

}
  static void isPossible() {
    if (lightA[0] == lightB[0] && lightA[N - 1] == lightB[N - 1]) {
      for (int i = 1; i < N-1; i++) {
//        if (lightA[i] != )
      }
    }

  }

}
