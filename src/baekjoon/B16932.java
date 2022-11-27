package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B16932 {

  static int[][] map;
  static boolean[][] isVisited;
  static int group = 1;
  static HashMap<Integer, Integer> sumMap = new HashMap<>();
  static int[] dr = {1, -1, 0, 0};
  static int[] dc = {0, 0, 1, -1};
  static int N;
  static int M;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    isVisited = new boolean[N][M];

    ArrayList<int[]> oneList = new ArrayList<int[]>();
    ArrayList<int[]> zeroList = new ArrayList<int[]>();
    ArrayList<Integer> zeroList2 = new ArrayList<>();
    Collections.sort(zeroList2);
    for (int i = 0; i < N; i++) {
      String[] s = br.readLine().split(" ");
      for (int j = 0; j < M; j++) {
        int num = Integer.parseInt(s[j]);
        if (num == 1) {
          map[i][j] = num;
          oneList.add(new int[]{i, j});
        } else {
          map[i][j] = num;
          zeroList.add(new int[]{i, j});
        }
      }
    }

    for (int[] one : oneList) {
      int r = one[0];
      int c = one[1];

      if (!isVisited[r][c]) {
        makeGroup(one);
        group++;
      }
    }

    for (int[] ints : map) {
      System.out.println(Arrays.toString(ints));
    }
  }

  public static void makeGroup(int[] rc) {
    LinkedList<int[]> queue = new LinkedList<>();
    queue.add(rc);
    map[rc[0]][rc[1]] = group;
    isVisited[rc[0]][rc[1]] = true;

    int sum = 1;
    while (!queue.isEmpty()) {
      int[] recent = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nr = recent[0] + dr[i];
        int nc = recent[1] + dc[i];

        if (nr >= 0 && nr < N && nc >= 0 && nc < M &&
            !isVisited[nr][nc] && map[nr][nc] != 0) {
          queue.add(new int[]{nr, nc});
          map[nr][nc] = group;
          isVisited[nr][nc] = true;
          sum ++;
        }
      }
    }
    sumMap.put(group, sum);
  }

}
