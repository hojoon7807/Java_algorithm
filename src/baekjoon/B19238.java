package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B19238 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  static int[] dr = {-1, 0, 0, 1};
  static int[] dc = {0, -1, 1, 0};
  static int N, M;
  static long fuel;
  static int[][] map;
  static Location curTaxi;
  static ArrayList<Location> userList = new ArrayList<>();
  static ArrayList<Location> destinationList = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    fuel = Long.parseLong(st.nextToken());

    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    int taxiR = Integer.parseInt(st.nextToken()) - 1;
    int taxiC = Integer.parseInt(st.nextToken()) - 1;
    curTaxi = new Location(taxiR, taxiC);

    int userNum = -1;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int userR = Integer.parseInt(st.nextToken()) - 1;
      int userC = Integer.parseInt(st.nextToken()) - 1;
      int desR = Integer.parseInt(st.nextToken()) - 1;
      int desC = Integer.parseInt(st.nextToken()) - 1;

      map[userR][userC] = userNum;
      userList.add(new Location(userR, userC));
      destinationList.add(new Location(desR, desC));

      userNum--;
    }
  }

  static void solution() {
    for (int i = 0; i < M; i++) {
      // 가까운 손님 찾기
      Location closeUser = findCloseUser();

      // 손님한테 갈수 없는 경우
      if (closeUser == null) {
        System.out.println(-1);
        return;
      }

      // 손님한테 이동 연료 -;
      fuel -= closeUser.cost;

      // 손님한테 이동할 연료가 없으면
      if (fuel < 0) {
        System.out.println(-1);
        return;
      }

      int destNum = -map[closeUser.r][closeUser.c] - 1;
      map[closeUser.r][closeUser.c] = 0;

      //System.out.println("user Num" + destNum + " path" + closeUser.cost);

      curTaxi = new Location(closeUser.r, closeUser.c, 0);

      // 목적지 이동
      Location destination = findDestination(destNum);

      // 목적지 갈수 없는 경우
      if (destination == null) {
        System.out.println(-1);
        return;
      }

      // 목적지 이동 연료
      fuel -= destination.cost;

      // 목적지 이동 연료 부족
      if (fuel < 0) {
        System.out.println(-1);
        return;
      }

      // 이동 후 연료 충전
      fuel += destination.cost * 2;

      // 위치 갱신
      curTaxi = new Location(destination.r, destination.c, 0);

    }
    System.out.println(fuel);
  }

  static Location findDestination(int destNum){
    Location destination = destinationList.get(destNum);
    boolean[][] isVisited = new boolean[N][N];
    PriorityQueue<Location> pq = new PriorityQueue<>((o1, o2) -> {
      if (o1.cost == o2.cost) {
        if (o1.r == o2.r) {
          return o1.c - o2.c;
        }

        return o1.r - o2.r;
      }

      return o1.cost - o2.cost;
    });

    isVisited[curTaxi.r][curTaxi.c] = true;

    pq.add(new Location(curTaxi.r, curTaxi.c, 0));

    Location dest = null;
    while (!pq.isEmpty()) {
      Location cur = pq.poll();

      if (destination.r == cur.r && destination.c == cur.c) {
        dest = cur;
        break;
      }

      for (int i = 0; i < 4; i++) {
        int nr = cur.r + dr[i];
        int nc = cur.c + dc[i];

        if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 1) {
          continue;
        }

        if (isVisited[nr][nc]) {
          continue;
        }

        isVisited[nr][nc] = true;
        pq.add(new Location(nr, nc, cur.cost + 1));

      }
    }
    return dest;
  }

  static Location findCloseUser() {
    boolean[][] isVisited = new boolean[N][N];
    PriorityQueue<Location> pq = new PriorityQueue<>((o1, o2) -> {
      if (o1.cost == o2.cost) {
        if (o1.r == o2.r) {
          return o1.c - o2.c;
        }

        return o1.r - o2.r;
      }

      return o1.cost - o2.cost;
    });

    isVisited[curTaxi.r][curTaxi.c] = true;

    pq.add(new Location(curTaxi.r, curTaxi.c, 0));

    Location user = null;
    while (!pq.isEmpty()) {
      Location cur = pq.poll();

      if (map[cur.r][cur.c] < 0) {
        user = cur;
        break;
      }

      for (int i = 0; i < 4; i++) {
        int nr = cur.r + dr[i];
        int nc = cur.c + dc[i];

        if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 1) {
          continue;
        }

        if (isVisited[nr][nc]) {
          continue;
        }

        isVisited[nr][nc] = true;
        pq.add(new Location(nr, nc, cur.cost + 1));

      }
    }
    return user;
  }

  static class Location {

    int r;
    int c;

    int cost;

    public Location(int r, int c, int cost) {
      this.r = r;
      this.c = c;
      this.cost = cost;
    }

    public Location(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }
}
