import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;

public class Main {

  static int[] dr = {0, 1, 0, -1};
  static int[] dc = {1, 0, -1, 0};

  static int n, k, l;
  static int[][] map;
  static HashMap<Integer, String> timeInfo = new HashMap<>();
  static ArrayDeque<Snake> snake = new ArrayDeque<>();
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  /*
  뱀의 경로를 map 배열에 나타내고 머리와 꼬리를 판단하기 위해 Deque 사용
  벽 OR 자기 몸으로 이동하면 종료
  사과가 없을때만 꼬리 감소
  시간이 되면 회전
   */
  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());

    map = new int[n][n];

    k = Integer.parseInt(br.readLine());
    for (int i = 0; i < k; i++) {
      String[] input = br.readLine().split(" ");
      int r = Integer.parseInt(input[0]) - 1;
      int c = Integer.parseInt(input[1]) - 1;

      map[r][c] = 1;
    }

    l = Integer.parseInt(br.readLine());

    for (int i = 0; i < l; i++) {
      String[] xc = br.readLine().split(" ");
      int x = Integer.parseInt(xc[0]);
      String c = xc[1];

      timeInfo.put(x, c);
    }

    snake.add(new Snake(0, 0));
    map[0][0] = 2;

    int time = 0;
    int direct = 0;

    while (true) {
      int nr = snake.peekLast().r + dr[direct];
      int nc = snake.peekLast().c + dc[direct];
      time++;

      // 벽에 부딪히면
      if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
        break;
      }

      // 가려는 위치가 자기 몸이라면
      if (map[nr][nc] == 2) {
        break;
      }

      // 가려는 위치에 사과가 없다면 꼬리를 옮긴다
      if (map[nr][nc] != 1) {
        Snake tail = snake.pollFirst();
        map[tail.r][tail.c] = 0;
      }

      snake.addLast(new Snake(nr, nc));
      map[nr][nc] = 2;

      // 시간이 되면 회전
      if (timeInfo.containsKey(time)) {
        String d = timeInfo.get(time);
        if (d.equals("D")) {
          direct = (direct + 1) % 4;
        } else {
          direct = direct == 0 ? 3 : direct - 1;
        }
      }
    }

    System.out.println(time);
  }

  static class Snake {

    int r;
    int c;

    public Snake(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }
}
