package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1170 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, m;
  static int nLen;
  static boolean[] remote = new boolean[10];
  static int answer;

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void input() throws IOException {
    String sn = br.readLine();
    nLen = sn.length();
    n = Integer.parseInt(sn);
    m = Integer.parseInt(br.readLine());
    if (m > 0) {
      String[] split = br.readLine().split(" ");

      for (int i = 0; i < m; i++) {
        remote[Integer.parseInt(split[i])] = true;
      }
    }
  }

  static void solution() {
    // 채널을 입력해서 변경하려면 적어도 n의 길이만큼 눌러야됌
    // init = 100  103  100자리까지 3번에 가능, 98 2자리 1자
    // + - 를 이용해 옮기는 경우
    answer = Math.abs(n - 100);

    search(0, "");

    System.out.println(answer);
  }

  static void search(int depth, String s) {
    if (depth > 0) {
      int curChannel = Integer.parseInt(s);
      int count = Math.abs(curChannel - n) + Integer.toString(curChannel).length();
      answer = Math.min(answer, count);
    }

    if (depth == nLen + 1) {
      return;
    }

    for (int i = 0; i <= 9; i++) {
      if (!remote[i]) {
        search(depth + 1, s + i);
      }
    }
  }
}
