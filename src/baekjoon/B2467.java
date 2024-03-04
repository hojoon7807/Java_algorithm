package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2467 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static int[] arr;
  static int min = Integer.MAX_VALUE;
  static int a,b;


  public static void main(String[] args) throws IOException {
  input();
  solution();
  }
  static void solution(){
    int left = 0;
    int right = n-1;

    while (left < right) {
      int sum = arr[left] + arr[right];

      if (sum == 0) {
        System.out.println(arr[left] + " " + arr[right]);
        return;
      }

      if (min > Math.abs(sum)) {
        min = Math.abs(sum);
        a = arr[left];
        b = arr[right];
      }
      if (sum > 0) {
        right --;
      } else if(sum < 0){
        left ++;
      }
    }

    System.out.println(a + " " + b);
  }

  static void input()throws IOException {
    n = Integer.parseInt(br.readLine());
    arr = new int[n];

    String[] input = br.readLine().split(" ");

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }
  }

}
