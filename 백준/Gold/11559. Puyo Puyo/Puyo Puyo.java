import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static char[][] field = new char[12][6];
  static int count = 0;
  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};
  static boolean[][] isVisited = new boolean[12][6];
  static Map<Integer, ArrayList<Node>> map = new HashMap<>();
  /*
  같은 색상 별로 그룹을 만든다
  그룹의 개수가 4 이상이라면 그룹 터뜨리기
  한번에 여러 그룹이 터지면 카운트는 1
  터뜨리고 난뒤 모든 색상 내리기
   */

  public static void main(String[] args) throws IOException {
    for (int i = 0; i < 12; i++) {
      field[i] = br.readLine().toCharArray();
    }

    start();
    System.out.println(count);
  }

  static void start() {
    while (true) {
      isVisited = new boolean[12][6];
      int groupNum = 1;
      boolean flag = false;

      for (int i = 11; i >= 0; i--) {
        for (int j = 0; j < 6; j++) {
          if (field[i][j] != '.' && !isVisited[i][j]) {
            makeGroup(field[i][j], new Node(i, j), groupNum);
            groupNum++;
          }
        }
      }

      for (ArrayList<Node> group : map.values()) {
        if (group.size() >= 4) {
          flag = true;
          destroy(group);
        }
      }

      if (flag) {
        count++;
      } else {
        break;
      }

      goDown();
      map.clear();
    }
  }

  static void destroy(ArrayList<Node> group) {
    group.forEach(node -> field[node.r][node.c] = '.');
  }

  static void goDown() {
    for (int i = 0; i < 6; i++) {
      for (int j = 11; j >= 0; j--) {
        // 해당 위치에 뿌요가 있으면 . 찾기
        if (field[j][i] != '.') {
          for (int k = 11; k > j; k--) {
            // . 발견하면 옮기기
            if (field[k][i] == '.') {
              field[k][i] = field[j][i];
              field[j][i] = '.';
              break;
            }
          }
        }
      }
    }
  }

  static void makeGroup(char color, Node node, int groupNum) {
    ArrayList<Node> group = new ArrayList<>();
    group.add(node);
    map.put(groupNum, group);

    LinkedList<Node> q = new LinkedList<>();
    isVisited[node.r][node.c] = true;
    q.add(node);

    while (!q.isEmpty()) {
      Node cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int nr = cur.r + dr[i];
        int nc = cur.c + dc[i];

        if (isValid(nr, nc, color)) {
          Node next = new Node(nr, nc);
          group.add(next);
          isVisited[nr][nc] = true;
          q.add(next);
        }
      }
    }
  }

  static boolean isValid(int r, int c, char color) {
    if (r < 0 || r >= 12 || c < 0 || c >= 6) {
      return false;
    }

    if (isVisited[r][c]) {
      return false;
    }

    if (field[r][c] != color) {
      return false;
    }

    return true;
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
