package programmers;

import java.util.ArrayList;

public class 미로탈출명령어 {


  static int R,C,X,Y,K, N,M;
  static int[] dr = {1,0,0,-1};
  static int[] dc = {0,-1,1,0};
  static char[] directChar = {'d','l','r','u'};
  static ArrayList<String> results = new ArrayList();

  public static void main(String[] args) {
    미로탈출명령어 m = new 미로탈출명령어();
    String solution = m.solution(3, 4, 2, 3, 3, 1, 5);
    System.out.println(solution);
  }

  public String solution(int n, int m, int x, int y, int r, int c, int k) {
    int impossibleCount = Math.abs(x-r) + Math.abs(y-c);

    N = n;
    M = m;
    R = r;
    C = c;
    X = x;
    Y = y;
    K = k;

    if((k - impossibleCount) % 2 == 1) {
      return "impossible";
    }

    StringBuilder sb = new StringBuilder();
    String answer = "";

    char[] arr = new char[K];
    int count = 0;

    while (true) {
      if(check(x,y,count)){
        continue;
      }

      if(count == k && x == R && y == C){
        answer = String.valueOf(arr);
        break;
      }

      for (int i=0; i<4; i++){
        int nx = x + dr[i];
        int ny = y + dc[i];

        if(nx>=1 && nx <= N && ny >= 1 && ny <= M){
          arr[count] = directChar[i];
          x = nx;
          y = ny;
          count ++;
          break;
        }
      }
    }

    return answer;
  }

  private static boolean check(int nx, int ny, int count) {
    int i = Math.abs(R - nx) + Math.abs(C - ny);
    int remain = K - count;
    if(i > remain || (remain-i)%2 != 0){
      return true;
    }
    return false;
  }
}
