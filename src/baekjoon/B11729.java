package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11729 {
  static int K;
  static StringBuilder sb = new StringBuilder("");
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    hanoi(N,1,3);
    System.out.println(K);
    System.out.println(sb.toString());
  }

  static void hanoi(int n,int start, int end) {
    K ++;
    if (n == 1) {
      sb.append(start + " " + end + "\n");
      //System.out.println(start + " " + end);
      return;
    }

    hanoi(n - 1, start, 6-(start+end));
    sb.append(start + " " + end + "\n");
//    System.out.println(start + " " + end);
    hanoi(n - 1, 6-(start+end), end);
  }

}
