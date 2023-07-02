package b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int maxLen = 0;

    String[] split = br.readLine().split(" ");

    for (String s : split) {
      maxLen = Math.max(maxLen, s.length());
    }

    int[] arr = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
    int position = 1;
    int maxPos = (int) Math.pow(10, maxLen + 1);

    while (maxPos >= position) {
      ArrayList<Integer>[] radixArr = new ArrayList[10];
      for (int i = 0; i < 10; i++) {
        radixArr[i] = new ArrayList<>();
      }

      for (int i = 0; i < n; i++) {
        int value = arr[i];
        int index = value / position % 10;

        radixArr[index].add(value);
      }

      int index = 0;
      for (ArrayList<Integer> list : radixArr) {
        for (Integer num : list) {
          arr[index] = num;
          index++;
        }
      }

      position *= 10;
    }

    StringBuilder sb = new StringBuilder();
    for (int i : arr) {
      sb.append(i + " ");
    }
    System.out.println(sb);
  }

}
