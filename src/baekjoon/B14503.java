package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14503 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n,m;
  static int[][] room;
  // 북 동 남 서
  // 0 1  2 3
  static int[] dr = {-1,0,1,0};
  static int[] dc = {0,1,0,-1};
  static int curR;
  static int curC;
  static int d;

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void input() throws IOException {
    String[] nm = br.readLine().split(" ");
    n = Integer.parseInt(nm[0]);
    m = Integer.parseInt(nm[1]);
    room = new int[n][m];

    String[] input = br.readLine().split(" ");
    curR = Integer.parseInt(input[0]);
    curC = Integer.parseInt(input[1]);
    d = Integer.parseInt(input[2]);

    for(int i=0; i<n; i++){
      input = br.readLine().split(" ");
      for(int j=0; j<m; j++){
        room[i][j] = Integer.parseInt(input[j]);
      }
    }
  }

  static void solution(){
    int answer = 0;
    while(true){
      //1.
      if(room[curR][curC] == 0){
        room[curR][curC] = 2;
        answer++;
      }

      //2.
      if(!hasEmpty()){
        int backR = curR - dr[d];
        int backC = curC - dc[d];

        //1)
        if(backR < 0 || backR >= n || backC < 0 || backC >= m || room[backR][backC] == 1){
          System.out.println(answer);
          return;
        } else {
          curR = backR;
          curC = backC;
          continue;
        }
      }

      //3.
      //1) 0>1>2>3>0
      int nd = ((d+1) % 4 + 2) % 4;
      int rotateR = curR + dr[nd];
      int rotateC = curC + dc[nd];
      if(rotateR < 0 || rotateR >= n || rotateC < 0 || rotateC >= m ||
          room[rotateR][rotateC] == 1 || room[rotateR][rotateC] == 2){
        d = nd;
      } else {
        curR = rotateR;
        curC = rotateC;
        d = nd;
      }
    }

  }

  static boolean hasEmpty(){
    for(int i=0; i<4; i++){
      int nr = curR + dr[i];
      int nc = curC + dc[i];

      if(room[nr][nc] == 0){
        return true;
      }
    }

    return false;
  }
}
