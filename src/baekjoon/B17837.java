package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B17837 {

  private static class Horse {

    int r;
    int c;
    int d;

    public Horse(int r, int c, int d) {
      this.r = r;
      this.c = c;
      this.d = d;
    }

    public void changeDirect(){
      if (d == 0 || d == 2) {
        d ++;
      } else{
        d --;
      }
    }
  }

  static int N, K;
  static Horse[] horses;
  static int[][] colors;
  static LinkedList<Integer>[][] map;

  static int[] dr = {0, 0, -1, 1};
  static int[] dc = {1, -1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    colors = new int[N][N];
    map = new LinkedList[N][N];
    horses = new Horse[K];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int color = Integer.parseInt(st.nextToken());
        colors[i][j] = color;
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        map[i][j] = new LinkedList<>();
      }
    }
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken())-1;
      int c = Integer.parseInt(st.nextToken())-1;
      int d = Integer.parseInt(st.nextToken())-1;

      horses[i] = new Horse(r, c, d);
      map[r][c].add(i);
    }

    start();
  }

  private static void start(){
    int count = 0;
    while(count <= 1000){
      count ++;
      // 말의 수 만큼 반복
      for (int i = 0; i < K; i++) {
        Horse currentHorse = horses[i];
        LinkedList<Integer> horseList = map[currentHorse.r][currentHorse.c];
        int currentIndex = horseList.indexOf(i);

        int nr = currentHorse.r + dr[currentHorse.d];
        int nc = currentHorse.c + dc[currentHorse.d];

        // blue || out
        if (nr < 0 || nr >= N || nc < 0 || nc >= N || colors[nr][nc] == 2) {
          currentHorse.changeDirect();
          nr = currentHorse.r + dr[currentHorse.d];
          nc = currentHorse.c + dc[currentHorse.d];

          // 반대로 이동해도 blue or out 경우 정지
          if (nr < 0 || nr >= N || nc < 0 || nc >= N || colors[nr][nc] == 2) {
            continue;
          }
        }

        // white
        if (colors[nr][nc] == 0) {
          while (horseList.size() > currentIndex) {
            int tmp = horseList.remove(currentIndex);

            horses[tmp].r = nr;
            horses[tmp].c = nc;

            map[nr][nc].add(tmp);

            if (map[nr][nc].size() >= 4) {
              System.out.println(count);
              return;
            }
          }
          // red
        } else if (colors[nr][nc] == 1) {
          while (horseList.size() > currentIndex) {
            int tmp = horseList.removeLast();
            horses[tmp].r = nr;
            horses[tmp].c = nc;

            map[nr][nc].add(tmp);

            if (map[nr][nc].size() >= 4) {
              System.out.println(count);
              return;
            }
          }
        }
      }

      if(count > 1000) System.out.println(-1);
    }

  }
}
