package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B2933 {

  static int R, C;
  static char[][] map;
  static int[][] cluster;
  static int[] dr = {0, 1, 0, -1};
  static int[] dc = {1, 0, -1, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    map = new char[R][C];

    for (int i = 0; i < R; i++) {
      String input = br.readLine();
      for (int j = 0; j < C; j++) {
        map[i][j] = input.charAt(j);
      }
    }

    int N = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int height = Integer.parseInt(st.nextToken());
      destroyMineral(R - height, i % 2);
      moveCluster();
    }

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        bw.write(map[i][j]);
      }
      bw.newLine();
    }
    bw.flush();
  }

  private static void moveCluster() {
    cluster = new int[R][C];
    int clusterNum = 1;

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (map[i][j] == 'x' && cluster[i][j] == 0) {
          if(findCluster(i, j, clusterNum)){
            return;
          }
        }
        clusterNum ++;
      }
    }
  }

  private static boolean findCluster(int i, int j, int clusterNum) {
    LinkedList<int[]> queue = new LinkedList<>();
    int lowestHeight = -1;
    ArrayList<int[]> nodes = new ArrayList<>();

    queue.add(new int[]{i, j});
    cluster[i][j] = clusterNum;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      Math.max(lowestHeight, current[0]);

      for (int k = 0; k < 4; k++) {
        int nr = current[0] + dr[k];
        int nc = current[1] + dc[k];

        if (nr >= 0 && nr < R && nc >= 0 && nc < C && cluster[nr][nc] == 0 && map[nr][nc] == 'x') {
          cluster[nr][nc] = clusterNum;
          queue.add(new int[]{nr, nc});
        }
      }

      nodes.add(current);
    }

    if (lowestHeight != R - 1) {
      downCluster(nodes);
      return true;
    }
    return false;
  }

  private static void downCluster(ArrayList<int[]> nodes) {
    int move = 1;

    for (int[] node : nodes) {
      map[node[0]][node[1]] = '.';
    }

    outerLoop:
    while(true){
      for (int[] node : nodes) {
        int down = node[0] + move;
        if (down == R || map[down][node[1]] == 'x') {
          move --;
          break outerLoop;
        }
      }
      move ++;
    }

    for (int[] node : nodes) {
      map[node[0] + move][node[1]] = 'x';
    }
  }

  private static void destroyMineral(int height, int dir) {
    if (dir == 0) {
      for (int i = 0; i < C; i++) {
        if (map[height][i] == 'x') {
          map[height][i] = '.';
          return;
        }
      }
    } else {
      for (int i = C - 1; i >= 0; i--) {
        if (map[height][i] == 'x') {
          map[height][i] = '.';
          return;
        }
      }

    }
  }
}