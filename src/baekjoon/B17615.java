package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17615 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String balls = br.readLine();

    int answer = Integer.MAX_VALUE;
    //왼쪽으로 빨간공 모으기
    int tempCount = 0;
    boolean flag = false;
    for (int i = 0; i < balls.length(); i++) {
      if(balls.charAt(i) == 'B') flag = true;
      else if(flag && balls.charAt(i) == 'R') tempCount ++;
    }

    answer = Math.min(answer, tempCount);

    //왼쪽으로 파란공 모으기
    tempCount = 0;
    flag = false;
    for (int i = 0; i < balls.length(); i++) {
      if(balls.charAt(i) == 'R') flag = true;
      else if(flag && balls.charAt(i) == 'B') tempCount ++;
    }

    answer = Math.min(answer, tempCount);

    //오른쪽으로 파란공 모으기
    tempCount = 0;
    flag = false;
    for (int i = balls.length()-1; i >= 0; i--) {
      if(balls.charAt(i) == 'R') flag = true;
      else if(flag && balls.charAt(i) == 'B') tempCount ++;
    }

    answer = Math.min(answer, tempCount);

    //오른쪽으로 빨간공 모으기
    tempCount = 0;
    flag = false;
    for (int i = balls.length()-1; i >= 0; i--) {
      if(balls.charAt(i) == 'B') flag = true;
      else if(flag && balls.charAt(i) == 'R') tempCount ++;
    }

    answer = Math.min(answer, tempCount);

    System.out.println(answer);

  }

}
