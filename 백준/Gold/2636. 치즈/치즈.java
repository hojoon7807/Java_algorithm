import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

  static int[][] arr;
  static int[] dr = {0, 1, 0, -1};
  static int[] dc = {1, 0, -1, 0};
  static int n, m;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  /*
  내부의 공기는 밖 공기와 연결될 때 까지 치즈에 영향을 주지않는다
  BFS -> 공기 체크
  치즈 제거
  제거된 치즈 개수 비교
  반복
   */

  public static void main(String[] args) throws IOException {
    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    m = Integer.parseInt(input[1]);

    arr = new int[n][m];
    int cheeseCount = 0;

    for (int i = 0; i < n; i++) {
      input = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        int value = Integer.parseInt(input[j]);

        if (value == 1) {
          cheeseCount++;
        }
        arr[i][j] = value;
      }
    }

    int time = 1;

    while (true) {
      makeAir();
      ArrayList<Node> list = getRemoveCheese();

      // 치즈가 다 없어지면 끝
      if (list.size() == cheeseCount) {
        System.out.println(time + "\n" + list.size());
        return;
      }

      for (Node node : list) {
        arr[node.r][node.c] = -1;
      }

      cheeseCount -= list.size();
      time++;
    }
  }

  static ArrayList<Node> getRemoveCheese() {
    ArrayList<Node> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (arr[i][j] == 1) {
          for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];

            if (isAir(nr, nc)) {
              list.add(new Node(i, j));
              break;
            }
          }
        }
      }
    }

    return list;
  }

  static boolean isAir(int r, int c) {
    if (r >= 0 && r < n && c >= 0 && c < m && arr[r][c] == -1) {
      return true;
    }

    return false;
  }

  static void makeAir() {
    LinkedList<Node> q = new LinkedList<>();
    boolean[][] isVisited = new boolean[n][m];
    isVisited[0][0] = true;
    arr[0][0] = -1;
    q.add(new Node(0, 0));

    while (!q.isEmpty()) {
      Node poll = q.poll();
      for (int i = 0; i < 4; i++) {
        int nr = poll.r + dr[i];
        int nc = poll.c + dc[i];

        if (canGo(nr, nc)) {
          if (!isVisited[nr][nc]) {
            arr[nr][nc] = -1;
            isVisited[nr][nc] = true;
            q.add(new Node(nr, nc));
          }
        }
      }
    }
  }

  static boolean canGo(int r, int c) {
    if (r >= 0 && r < n && c >= 0 && c < m && arr[r][c] != 1) {
      return true;
    }

    return false;
  }

  static class Node {

    int r;
    int c;

    public Node(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }

}
