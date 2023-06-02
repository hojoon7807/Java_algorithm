package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1652 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    char[][] room = new char[n][n];

    for (int i = 0; i < n; i++) {
      String input = br.readLine();
      for (int j = 0; j < n; j++) {
        room[i][j] = input.charAt(j);
      }
    }

    int row = 0;
    int cal = 0;


    for (int i = 0; i < n; i++) {
      boolean flag = false;
      for (int j = 0; j < n-1; j++) {
        if (room[i][j] == '.' && room[i][j + 1] == '.' && !flag) {
          row++;
          flag = true;
        }

        if (room[i][j] == 'X') {
          flag = false;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      boolean flag = false;
      for (int j = 0; j < n-1; j++) {
        if (room[j][i] == '.' && room[j+1][i] == '.' && !flag) {
          cal++;
          flag = true;
        }

        if (room[j][i] == 'X') {
          flag = false;
        }
      }
    }

    System.out.println(row + " " + cal);
  }

}
