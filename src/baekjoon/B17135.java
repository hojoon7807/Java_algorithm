package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B17135 {

  static int maxCount = 0;
  static int n, m, d;
  static int[][] arr;

  static int turn;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] nmd = br.readLine().split(" ");
    n = Integer.parseInt(nmd[0]);
    m = Integer.parseInt(nmd[1]);
    d = Integer.parseInt(nmd[2]);

    arr = new int[n + 1][m];

    int minIndex = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        int value = Integer.parseInt(input[j]);

        if (value == 1) {
          minIndex = Math.min(minIndex, i);
        }

        arr[i][j] = value;
      }
    }

    turn = n - minIndex;

    if (turn == 0) {
      System.out.println(0);
      return;
    }

    arrange(0, 0);
    System.out.println(maxCount);
  }

  static void arrange(int depth, int index) {
    if (depth == 3) {
      maxCount = Math.max(maxCount, start());
      return;
    }

    for (int i = index; i < m; i++) {
      arr[n][i] = 2;
      arrange(depth + 1, i + 1);
      arr[n][i] = 0;
    }
  }

  static int start() {
    int[][] copyArr = copyArr();
    int count = 0;
    for (int i = 0; i < turn; i++) {
      count += attack();
      moveDown();
    }

    arr = copyArr;
    return count;
  }

  static int[][] copyArr() {
    int[][] copy = new int[n + 1][m];

    for (int i = 0; i <= n; i++) {
      copy[i] = arr[i].clone();
    }

    return copy;
  }

  static int attack() {
    int count = 0;
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
      if (o1[2] == o2[2]) {
        return o1[1] - o2[1];
      } else {
        return o1[2] - o2[2];
      }
    });

    for (int i = 0; i < m; i++) {
      if (arr[n][i] == 2) {
        // 가장 왼쪽 공격
        for (int j = n - 1; j >= 0; j--) {
          for (int k = 0; k < m; k++) {
            // 가장 왼쪽 갱신
            if (arr[j][k] == 1 || arr[j][k] == 3) {
              // 3 - 0 + 3 - 1
              int distance = Math.abs(n - j) + Math.abs(i - k);
              if (distance <= d) {
                pq.add(new int[]{j, k, distance});
              }
            }
          }
        }

//        if (mostLeft != null) {
//          if (arr[mostLeft[0]][mostLeft[1]] == 1) {
//            count ++;
//            arr[mostLeft[0]][mostLeft[1]] = 3;
//          }
//        }

        if (!pq.isEmpty()) {
          int[] point = pq.poll();
          if (arr[point[0]][point[1]] == 1) {
            count++;
            arr[point[0]][point[1]] = 3;
          }
        }
        pq.clear();
      }
    }
    return count;
  }

  static void moveDown() {
    for (int i = 0; i < m; i++) {
      arr[n - 1][i] = 0;
    }

    for (int i = n - 2; i >= 0; i--) {
      for (int j = 0; j < m; j++) {
        if (arr[i][j] == 3) {
          arr[i + 1][j] = 0;
        } else {
          arr[i + 1][j] = arr[i][j];
        }
      }
    }

    for (int i = 0; i < m; i++) {
      arr[0][i] = 0;
    }

  }
}
