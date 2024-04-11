import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, m;
  static int[][] arr;
  static List<Cloud> clouds = new ArrayList<>();

  static boolean[][] usedClouds;

  static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
  static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};

  static int[] diagonalR = {-1, -1, 1, 1};
  static int[] diagonalC = {-1, 1, -1, 1};
  /*
  첫번째 행, 열은 마지막 행, 열과 연결
  1. 방향 di 거리 si 로 이동하면 구름이 있는 칸의 물의 양 1 증가(이동은 경계를 넘어서)
  2. 대각선 방향으로 거리가 1인 칸에 물의 수 만큼 양이 증가. (경계 넘어가면 x)
  3. 물의 양이 2이상인 모든칸에 구름이 생기고, 물의양이 2 줄어든다. 앞서 진행된 구름이 사라진 칸은 적용 x
   */

  public static void main(String[] args) throws IOException {
    String[] nm = br.readLine().split(" ");
    n = Integer.parseInt(nm[0]);
    m = Integer.parseInt(nm[1]);

    arr = new int[n][n];
    usedClouds = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      arr[i] = Arrays.stream(br.readLine().split(" "))
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }

    initCloud();

    for (int i = 0; i < m; i++) {
      String[] ds = br.readLine().split(" ");
      int d = Integer.parseInt(ds[0]);
      int s = Integer.parseInt(ds[1]);

      // 3,3 3,4 4,3 4,4 -> 4,4 4,1 1,4 ,1,1
      moveAndIncrease(d, s);
      increaseDiagonal();
      addCloud();
    }

    System.out.println(getWater());
  }

  static int getWater(){
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        count += arr[i][j];
      }
    }

    return count;
  }

  static void addCloud(){
    ArrayList<Cloud> newClouds = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (arr[i][j] >= 2 && !usedClouds[i][j]) {
          arr[i][j] -=2;
          newClouds.add(new Cloud(i, j));
        }
      }
    }

    for (Cloud cloud : clouds) {
      usedClouds[cloud.r][cloud.c] = false;
    }

    clouds = newClouds;
  }

  static void increaseDiagonal(){
    for (Cloud cloud : clouds) {
      int count = 0;
      for (int i = 0; i < 4; i++) {
        int nr = cloud.r + diagonalR[i];
        int nc = cloud.c + diagonalC[i];

        if (isRange(nr, nc)) {
          if (arr[nr][nc] != 0) {
            count ++;
          }
        }
      }

      arr[cloud.r][cloud.c] += count;
      usedClouds[cloud.r][cloud.c] = true;
    }
  }

  static boolean isRange(int r, int c) {
    if (r >= 0 && r < n && c >= 0 && c < n) {
      return true;
    }

    return false;
  }

  static void moveAndIncrease(int d, int s){
    for (Cloud cloud : clouds) {
      cloud.r = (cloud.r + (dr[d - 1] + n) * s) % n;
      cloud.c = (cloud.c + (dc[d - 1] + n) * s) % n;

      arr[cloud.r][cloud.c] += 1;
    }
  }

  static void initCloud(){
    clouds.add(new Cloud(n - 1, 0));
    clouds.add(new Cloud(n - 1, 1));
    clouds.add(new Cloud(n - 2, 0));
    clouds.add(new Cloud(n - 2, 1));
  }

  static class Cloud {
    int r;
    int c;

    public Cloud(int r, int c) {
      this.r = r;
      this.c = c;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Cloud cloud = (Cloud) o;

      if (r != cloud.r) {
        return false;
      }
      return c == cloud.c;
    }
  }

}
