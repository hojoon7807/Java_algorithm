package inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class I0601 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    int[] arr = new int[N];

    String[] strings = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(strings[i]);
    }

    for (int i = 0; i < N; i++) {
      int min = Integer.MAX_VALUE;
      int tmp = arr[i];
      int index = -1;
      for (int j = i; j < N; j++) {
        if (arr[j] < min) {
          min = arr[j];
          index = j;
        }
      }

      arr[i] = min;
      arr[index] = tmp;
      sb.append(arr[i] + " ");
    }

    System.out.println(sb);
  }

}
