import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, m;
  static int[][] map;

  static int[] dr = {-1, 0, 1, 0};
  static int[] dc = {0, -1, 0, 1};
  static int answer = 0;
  static ArrayList<Node> maxGroup;

  static boolean[][] isVisited;

  /*
  m 가지의 색이 있고 색은 m이하 자연수로 표현
  검은색 -1, 무지개 0
  그룹 조건 = 색이 모두 같아야하고, 무지개 블록은 포함 가능, 검은색은 불가능, 2개 이상
  max 그룹 -> 개수, 무지개, 열
  그룹의 개수^2 더한 후 제거
  중력 ( 검은색을 제외한 모든 블록이 아래로 이동
  반시계 90도 회전
  중력
   */


  public static void main(String[] args) throws IOException {
    String[] nm = br.readLine().split(" ");
    n = Integer.parseInt(nm[0]);
    m = Integer.parseInt(nm[1]);

    map = new int[n][n];

    for (int i = 0; i < n; i++) {
      map[i] = Arrays.stream(br.readLine().split(" "))
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }

    while (true) {
      findGroup();
      if (maxGroup.isEmpty()) {
        break;
      }
      getScoreAndRemove();
      gravity();
      rotate();
      gravity();
    }

    System.out.println(answer);

  }

  static void gravity() {
    for (int i = n - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        if (map[i][j] >= 0 && map[i][j] <= m) {
          int max = i;
          for (int k = i + 1; k < n; k++) {
            if (map[k][j] == -2) {
              max = k;
            } else {
              break;
            }
          }

          if (max != i) {
            map[max][j] = map[i][j];
            map[i][j] = -2;
          }
        }
      }
    }
  }

  static void rotate() {
    int[][] copy = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        copy[n-j-1][i] = map[i][j];
      }
    }

    map = copy;
  }

  static void getScoreAndRemove() {
    int count = maxGroup.size();
    answer += count * count;

    for (Node node : maxGroup) {
      map[node.r][node.c] = -2;
    }
  }

  static void findGroup() {
    maxGroup = new ArrayList<>();
    isVisited = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!isVisited[i][j] && map[i][j] >= 1 && map[i][j] <= m) {
          ArrayList<Node> group = makeGroup(new Node(i, j), map[i][j]);
          if (group.size() >= 2) {
            setMaxGroup(group);
          }

          // 무지개만 되돌리기
          backRainbow(group);
        }
      }
    }
  }

  static void backRainbow(ArrayList<Node> group) {
    for (Node node : group) {
      if (map[node.r][node.c] == 0) {
        isVisited[node.r][node.c] = false;
      }
    }
  }

  static void setMaxGroup(ArrayList<Node> newGroup) {
    if (newGroup.size() > maxGroup.size()) {
      maxGroup = newGroup;
    } else if (newGroup.size() == maxGroup.size()) {
      int newRainbow = 0;
      int maxRainbow = 0;

      for (Node node : newGroup) {
        if (map[node.r][node.c] == 0) {
          newRainbow++;
        }
      }

      for (Node node : maxGroup) {
        if (map[node.r][node.c] == 0) {
          maxRainbow++;
        }
      }

      if (newRainbow > maxRainbow) {
        maxGroup = newGroup;
      } else if (newRainbow == maxRainbow) {
        if (newGroup.get(0).compareTo(maxGroup.get(0)) > 0) {
          maxGroup = newGroup;
        }
      }
    }
  }

  static ArrayList<Node> makeGroup(Node start, int color) {
    isVisited[start.r][start.c] = true;
    LinkedList<Node> q = new LinkedList<>();
    q.add(start);
    ArrayList<Node> group = new ArrayList<>();
    group.add(start);

    while (!q.isEmpty()) {
      Node cur = q.poll();
      for (int i = 0; i < 4; i++) {
        int nr = cur.r + dr[i];
        int nc = cur.c + dc[i];

        if (isValid(nr, nc, color)) {
          Node next = new Node(nr, nc);
          q.add(next);
          group.add(next);
          isVisited[nr][nc] = true;
        }
      }
    }

    return group;
  }

  static boolean isValid(int r, int c, int color) {
    if (r >= 0 && r < n && c >= 0 && c < n && !isVisited[r][c] &&
        (map[r][c] == color || map[r][c] == 0)) {
      return true;
    }

    return false;
  }

  static class Node implements Comparable<Node> {

    int r;
    int c;

    public Node(int r, int c) {
      this.r = r;
      this.c = c;
    }

    @Override
    public int compareTo(Node o) {
      if (this.r == o.r) {
        return this.c - o.c;
      }

      return this.r - o.r;
    }
  }
}
