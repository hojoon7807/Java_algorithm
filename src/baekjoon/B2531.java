package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2531 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, d, k, c;
  static int[] arr;
  static boolean isExist = false;
  static boolean[] isEat;
  static int answer = 0;

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    isEat = new boolean[d + 1];
    arr = new int[n];

    for (int i = 0; i < n; i++) {
      int kind = Integer.parseInt(br.readLine());
      arr[i] = kind;
      if (kind == c) {
        isExist = true;
      }
    }
  }

  static void solution() {
    int index = 0;
    while (index < n) {
      int kind = 0;
      for (int i = index; i < index + k; i++) {
        // 0 1 2 3 4-> 2 = 2 3 = 3, 4 =4, 5 = 0;
        int realIdx = i % n;
        if (!isEat[arr[realIdx]]) {
          isEat[arr[realIdx]] = true;
          kind++;
        }
      }

      // 추가 쿠폰 먹었냐
      if (!isEat[c]) {
        // 안먹었는데 벨트에 존재하지 않을 경우
        kind ++;
//        if (!isExist) {
//          kind++;
//        } else {
//          // 안먹었는데 벨트에 존재 앞
//          // 4 0 1 2 3
//          int prevIdx = (index + k - 1)% n;
//          int nextIdx = (index + k) % n;
//        }
      }


      for (int i = index; i < index + k; i++) {
        int realIdx = i % n;
        isEat[arr[realIdx]] = false;
      }

      answer = Math.max(answer, kind);
      index ++;
    }

    System.out.println(answer);
  }
}
