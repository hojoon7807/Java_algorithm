package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11728 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();

  static String str;
  static int[] Dy;
  static int N, MOD = 1000000;

  static boolean check(char A, char B) {  // 'AB' 라는 두 자리 숫자가 하나의 수로 해독이 가능한가?
    if (A == '0') {
      return false;
    }
    if (A == '1') {
      return true;
    }
    if (A >= '3') {
      return false;
    }
    return B <= '6';
  }

  static void pro() {
    Dy = new int[N];

    if (str.charAt(0) != '0') {
      Dy[0] = 1;
    }

    for (int i = 1; i < N; i++) {
      if (str.charAt(i) != '0') {
        Dy[i] = Dy[i - 1];
      }
      if (check(str.charAt(i - 1), str.charAt(i))) {
        if (i >= 2) {
          Dy[i] += Dy[i - 2];
        } else {
          Dy[i] += 1;
        }
        Dy[i] %= MOD;
      }
    }

    System.out.println(Dy[N - 1]);
  }

  public static void main(String[] args) throws IOException {
    str = br.readLine();
    N = str.length();
    pro();
  }

}
