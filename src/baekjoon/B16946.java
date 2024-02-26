package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B16946 {
  /*
  3 3
101
010
101
   */

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, m;
  static int[][] arr;
  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};
  static boolean[][] isVisited;
  static ArrayList<Integer> groupList = new ArrayList<>();
  static HashMap<Integer, Integer> map = new HashMap<>();

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n][m];
    isVisited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      String[] split = br.readLine().split("");
      for (int j = 0; j < m; j++) {
        int wall = Integer.parseInt(split[j]);
        arr[i][j] = wall;

        if (wall == 1) {
          isVisited[i][j] = true;
        }
      }
    }
  }

  static void solution() {

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (arr[i][j] == 0 && !isVisited[i][j]) {
          makeGroup(i, j);
          groupList.clear();
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        sb.append(arr[i][j] % 10);
      }

      sb.append("\n");
    }

    System.out.println(sb);
  }

  // 0, 1, 2, 3, 4
  // 5, 6, 7, 8, 9
  // 10,11,12,13,14
  //
  static int encodeIndex(int r, int c) {
    return r * m + c;
  }

  static int[] decodeIndex(int index) {
    int r = index / m;
    int c = index % m;

    return new int[]{r, c};
  }

  static void makeGroup(int r, int c) {
    LinkedList<int[]> q = new LinkedList<>();
    q.add(new int[]{r, c});
    isVisited[r][c] = true;
    int count = 0;
    while (!q.isEmpty()) {
      int[] cur = q.poll();

      count++;
      groupList.add(encodeIndex(cur[0], cur[1]));
      for (int i = 0; i < 4; i++) {
        int nr = cur[0] + dr[i];
        int nc = cur[1] + dc[i];

        if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
          continue;
        }

        if (isVisited[nr][nc]) {
          continue;
        }

        q.add(new int[]{nr, nc});
        isVisited[nr][nc] = true;

      }
    }

    HashSet<Integer> set = new HashSet<>();

    for (Integer element : groupList) {
      int[] index = decodeIndex(element);
      int groupR = index[0];
      int groupC = index[1];

      for (int i = 0; i < 4; i++) {
        int nr = groupR + dr[i];
        int nc = groupC + dc[i];

        if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
          continue;
        }

        if (arr[nr][nc] > 0) {
          if (set.contains(encodeIndex(nr, nc))) {
            continue;
          }

          arr[nr][nc] += count;
          set.add(encodeIndex(nr, nc));
        }
      }
    }

  }


}
