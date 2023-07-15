package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B24523 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    if (n == 1) {
      System.out.println(-1);
      return;
    }

    int[] resultArr = new int[n];

    int tmp = arr[0];
    for (int i = 1; i < n; i++) {
      if (i == n - 1) {
        resultArr[i] = -1;
      }
      if(tmp != arr[i]){
        resultArr[i-1] = i+1;
        tmp = arr[i];
      }
    }

    for (int i = n-2; i >= 0; i--) {
      if(resultArr[i] == 0){
        resultArr[i] = resultArr[i+1];
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i : resultArr) {
      sb.append(i + " ");
    }
    System.out.println(sb);
  }

}
