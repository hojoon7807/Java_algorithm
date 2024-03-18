package programmers;

import java.util.Arrays;

public class 양궁대회 {

  public static void main(String[] args) {
    int n = 5;
    int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};

    solution(n, info);
  }

  static int max = 0;
  static int[] answer = new int[11];

  public static int[] solution(int n, int[] info) {

    dfs(0,n,0, new int[n], info);
    //  k a < b  rion
    //  a >= apeach

    return max == 0 ? new int[]{-1} : answer;
  }

  static void dfs(int depth, int n, int point, int[] result, int[] info){
    if(depth == n){
      // 결과 계산
      int diff = calculate(result, info);
      System.out.println(Arrays.toString(lionInfo(result)) + " " + diff);
      if(diff > max){
        max = diff;
        answer = lionInfo(result);
      }
      return;
    }

    for(int i=point; i<=10; i++){
      result[depth] = i;
      dfs(depth+1, n, i ,result, info);
    }
  }

  static int[] lionInfo(int[] result){
    int[] lion = new int[11];

    for(int i=0; i<result.length; i++){
      lion[10 - result[i]] ++;
    }

    return lion;
  }

  static int calculate(int[] result, int[] info){
    int[] lion = lionInfo(result);

    int apeachPoint = 0;
    int lionPoint = 0;

    int[] a= new int[]{0,2,2,0,1,0,0,0,0,0,0};
    boolean flag = true;
    for (int i = 0; i < 11; i++) {
      if (a[i] != lion[i]) {
        flag = false;
        break;
      }
    }

    if (!flag) {
      return 0;
    }

    for(int i=0; i<11; i++){
      if (info[i] == 0 && lion[i] == 0) {
        continue;
      }

      if(info[i] >= lion[i]){
        apeachPoint += 10 - i;
      } else {
        lionPoint += 10 - i;
      }
    }

    if(lionPoint > apeachPoint) {
      return lionPoint - apeachPoint;
    } else {
      return 0;
    }
  }

}
