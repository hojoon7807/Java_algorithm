package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1138 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    String[] input = br.readLine().split(" ");

    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      int leftTaller = Integer.parseInt(input[i]);
      int count = 0;
      for (int j = 0; j < n; j++) {
        if (arr[j] == 0 && count == leftTaller) {
          arr[j] = i+1;
          break;
        }
        if (arr[j] == 0) {
          count ++;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i : arr) {
      sb.append(i).append(" ");
    }

    System.out.println(sb);
  }

}
