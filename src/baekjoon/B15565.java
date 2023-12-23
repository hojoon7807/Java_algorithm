package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15565 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nk = br.readLine().split(" ");
    int n = Integer.parseInt(nk[0]);
    int k = Integer.parseInt(nk[1]);

    int[] arr = new int[n];

    String[] input = br.readLine().split(" ");

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }

    int count = 0;
    int right = 0;
    int min = -1;
    for (int left = 0; left < n; left++) {
      while (right < n && count < k) {
        if(arr[right] == 1){
          count ++;
        }

        right ++;
      }

      if (count == k) {
        if (min == -1) {
          min = right - left;
        }
        min = Math.min(min, right - left);
      }

      if (arr[left] == 1) {
        count--;
      }
    }

    System.out.println(min);
  }

}
