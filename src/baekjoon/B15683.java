package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B15683 {

  static int n, m;
  static int[][] room;
  static int min = 90;
  static ArrayList<int[]> cctv = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nm = br.readLine().split(" ");
    n = Integer.parseInt(nm[0]);
    m = Integer.parseInt(nm[1]);

    room = new int[n][m];

    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");

      for (int j = 0; j < m; j++) {
        int value = Integer.parseInt(input[j]);

        if (1 <= value && value <= 5) {
          cctv.add(new int[]{i, j, value});
        }
        room[i][j] = Integer.parseInt(input[j]);
      }
    }

    combine(0, new int[cctv.size()]);

    System.out.println(min);
  }

  static void combine(int index, int[] arr) {
    if (index == cctv.size()) {
      min = Math.min(min, cal(arr));
      return;
    }

    int num = cctv.get(index)[2];

    switch (num) {
      case 1:
        for (int i = 0; i < 4; i++) {
          arr[index] = i;
          combine(index + 1, arr);
        }
        break;
      case 2:
        for (int i = 0; i < 2; i++) {
          arr[index] = i;
          combine(index + 1, arr);
        }
        break;
      case 3:
        for (int i = 0; i < 4; i++) {
          arr[index] = i;
          combine(index + 1, arr);
        }
        break;
      case 4:
        for (int i = 0; i < 4; i++) {
          arr[index] = i;
          combine(index + 1, arr);
        }
        break;
      case 5:
        arr[index] = 5;
        combine(index + 1, arr);
        break;
    }

  }

  static int cal(int[] combine) {
    int[][] clone = new int[n][m];
    for (int i = 0; i < n; i++) {
      clone[i] = room[i].clone();
    }

    for (int i = 0; i < cctv.size(); i++) {
      int num = cctv.get(i)[2];
      int dir = combine[i];

      if (num == 1) {
        one(clone, dir, cctv.get(i)[0], cctv.get(i)[1]);
      } else if (num == 2) {
        two(clone, dir, cctv.get(i)[0], cctv.get(i)[1]);

      } else if (num == 3) {
        three(clone, dir, cctv.get(i)[0], cctv.get(i)[1]);

      } else if (num == 4) {
        four(clone, dir, cctv.get(i)[0], cctv.get(i)[1]);

      } else if (num == 5) {
        five(clone, dir, cctv.get(i)[0], cctv.get(i)[1]);
      }
    }

    int non = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (clone[i][j] == 0) {
          non ++;
        }
      }
    }
    return non;
  }

  static void one(int[][] clone, int dir, int startR, int startC) {
    if (dir == 0) {
      // right
      for (int i = startC + 1; i < m; i++) {
        int next = clone[startR][i];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[startR][i] = -1;
      }
    } else if (dir == 1) {
      //down
      for (int i = startR + 1; i < n; i++) {
        int next = clone[i][startC];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[i][startC] = -1;
      }
    } else if (dir == 2) {
      // left
      for (int i = startC - 1; i >= 0; i--) {
        int next = clone[startR][i];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[startR][i] = -1;
      }
    } else if (dir == 3) {
      //up
      for (int i = startR - 1; i >= 0; i--) {
        int next = clone[i][startC];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[i][startC] = -1;
      }
    }
  }

  static void two(int[][] clone, int dir, int startR, int startC) {
    if (dir == 0) {
      // <->
      for (int i = startC + 1; i < m; i++) {
        int next = clone[startR][i];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[startR][i] = -1;
      }

      for (int i = startC - 1; i >= 0; i--) {
        int next = clone[startR][i];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[startR][i] = -1;
      }
    } else if (dir == 1) {
      // up down
      for (int i = startR + 1; i < n; i++) {
        int next = clone[i][startC];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[i][startC] = -1;
      }

      for (int i = startR - 1; i >= 0; i--) {
        int next = clone[i][startC];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[i][startC] = -1;
      }
    }
  }

  static void three(int[][] clone, int dir, int startR, int startC) {
    if (dir == 0) {
      // right up
      for (int i = startC + 1; i < m; i++) {
        int next = clone[startR][i];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[startR][i] = -1;
      }

      for (int i = startR - 1; i >= 0; i--) {
        int next = clone[i][startC];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[i][startC] = -1;
      }
    } else if (dir == 1) {
      //down right
      for (int i = startC + 1; i < m; i++) {
        int next = clone[startR][i];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[startR][i] = -1;
      }

      for (int i = startR + 1; i < n; i++) {
        int next = clone[i][startC];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[i][startC] = -1;
      }
    } else if (dir == 2) {
      // left down
      for (int i = startC - 1; i >= 0; i--) {
        int next = clone[startR][i];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[startR][i] = -1;
      }

      for (int i = startR + 1; i < n; i++) {
        int next = clone[i][startC];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[i][startC] = -1;
      }
    } else if (dir == 3) {
      //up left
      for (int i = startR - 1; i >= 0; i--) {
        int next = clone[i][startC];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[i][startC] = -1;
      }

      for (int i = startC - 1; i >= 0; i--) {
        int next = clone[startR][i];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[startR][i] = -1;
      }
    }
  }

  static void four(int[][] clone, int dir, int startR, int startC) {
    if (dir == 0) {
      // right left up
      for (int i = startC + 1; i < m; i++) {
        int next = clone[startR][i];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[startR][i] = -1;
      }

      for (int i = startC - 1; i >= 0; i--) {
        int next = clone[startR][i];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[startR][i] = -1;
      }

      for (int i = startR - 1; i >= 0; i--) {
        int next = clone[i][startC];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[i][startC] = -1;
      }
    } else if (dir == 2) {
      //up right down
      for (int i = startR - 1; i >= 0; i--) {
        int next = clone[i][startC];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[i][startC] = -1;
      }

      for (int i = startR + 1; i < n; i++) {
        int next = clone[i][startC];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[i][startC] = -1;
      }

      for (int i = startC + 1; i < m; i++) {
        int next = clone[startR][i];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[startR][i] = -1;
      }

    } else if (dir == 2) {
      // left right down
      for (int i = startC + 1; i < m; i++) {
        int next = clone[startR][i];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[startR][i] = -1;
      }

      for (int i = startC - 1; i >= 0; i--) {
        int next = clone[startR][i];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[startR][i] = -1;
      }

      for (int i = startR + 1; i < n; i++) {
        int next = clone[i][startC];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[i][startC] = -1;
      }


    } else if (dir == 3) {
      //up down left
      for (int i = startR - 1; i >= 0; i--) {
        int next = clone[i][startC];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[i][startC] = -1;
      }

      for (int i = startR + 1; i < n; i++) {
        int next = clone[i][startC];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[i][startC] = -1;
      }

      for (int i = startC - 1; i >= 0; i--) {
        int next = clone[startR][i];
        if (next == 6) {
          break;
        }

        if (1 <= next && next <= 5) {
          continue;
        }

        clone[startR][i] = -1;
      }
    }
  }

  static void five(int[][] clone, int dir, int startR, int startC) {
    for (int i = startR - 1; i >= 0; i--) {
      int next = clone[i][startC];
      if (next == 6) {
        break;
      }

      if (1 <= next && next <= 5) {
        continue;
      }

      clone[i][startC] = -1;
    }

    for (int i = startR + 1; i < n; i++) {
      int next = clone[i][startC];
      if (next == 6) {
        break;
      }

      if (1 <= next && next <= 5) {
        continue;
      }

      clone[i][startC] = -1;
    }

    for (int i = startC - 1; i >= 0; i--) {
      int next = clone[startR][i];
      if (next == 6) {
        break;
      }

      if (1 <= next && next <= 5) {
        continue;
      }

      clone[startR][i] = -1;
    }
    for (int i = startC + 1; i < m; i++) {
      int next = clone[startR][i];
      if (next == 6) {
        break;
      }

      if (1 <= next && next <= 5) {
        continue;
      }

      clone[startR][i] = -1;
    }
  }


}
