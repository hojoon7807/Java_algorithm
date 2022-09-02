package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class I0301 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] a = new int[N];

    String[] strings = br.readLine().split(" ");

    for (int i = 0; i < N; i++) {
      a[i] = Integer.parseInt(strings[i]);
    }

    int M = Integer.parseInt(br.readLine());
    int[] b = new int[M];

    strings = br.readLine().split(" ");
    for (int i = 0; i < M; i++) {
      b[i] = Integer.parseInt(strings[i]);
    }

    for (Integer integer : solution(N, M, a, b)) {
      System.out.print(integer + " ");
    }
  }

  static ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
    ArrayList<Integer> list = new ArrayList<>();

    int p1 = 0;
    int p2 = 0;
    while (p1 < n && p2 < m) {
      if (a[p1] < b[p2]) {
        list.add(a[p1++]);
      } else {
        list.add(b[p2++]);
      }
    }

    while (p1 < n) {
      list.add(a[p1++]);
    }
    while (p2 < m) {
      list.add(b[p2++]);
    }

    return list;
  }

}
