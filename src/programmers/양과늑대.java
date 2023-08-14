package programmers;

import java.util.Arrays;

public class 양과늑대 {

  static int[] visit = new int[1 << 17];
  static int len;

  // 루트는 무조건 양
  static int answer = 1;
  static int[] l = new int[20];
  static int[] r = new int[20];
  static int[] val = new int[20];
  public static void solve(int state) {
    if (visit[state] == 1) {
      return;
    }
    visit[state] = 1;

    int wolf = 0, num = 0;
    for (int i = 0; i < len; i++) {
      if ((state & (1 << i)) != 0) {
        num++;
        wolf += val[i];
      }
    }

    // 늑대가 절반 이상인 경우, ex) visit 4 wolf 2;
    if (2 * wolf >= num) {
      return;
    }
    answer = Math.max(num - wolf, answer);

    for (int i = 0; i < len; i++) {
      // i 의 비트가 꺼져 있으면 넘김
      if ((state & (1 << i)) == 0) {
        continue;
      }

      if (l[i] != -1) {
        solve(state | 1 << l[i]);
      }

      if (r[i] != -1) {
        solve(state | 1 << r[i]);
      }
    }
  }

  public static int solution(int[] info, int[][] edges) {
    len = info.length;

    Arrays.fill(l, -1);
    Arrays.fill(r, -1);
    for (int i = 0; i < len; i++) {
      val[i] = info[i];
    }

    for (int i = 0; i < len - 1; i++) {
      int a = edges[i][0]; // parent
      int b = edges[i][1]; // child

      if (l[a] == -1) {
        l[a] = b;
      } else {
        r[a] = b;
      }
    }

    return answer;
  }
}
