package b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSort {
  static int[] mergeArr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String[] split = br.readLine().split(" ");

    int[] arr = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
    mergeArr = new int[n];

    mergeSort(arr, 0, n - 1);

    StringBuilder sb = new StringBuilder();

    for (int i : arr) {
      sb.append(i + " ");
    }

    System.out.println(sb);
  }

  public static void mergeSort(int[] arr, int low, int high) {
    if (low < high) {
      int mid = (low + high) / 2;
      mergeSort(arr, low, mid);
      mergeSort(arr, mid + 1, high);
      merge(arr, low, mid, high);
    }
  }

  public static void merge(int[] arr, int low, int mid, int high) {
    int i = low;
    int j = mid + 1;

    int index = low;

    while (i <= mid && j <= high) {
      if (arr[i] <= arr[j]) {
        mergeArr[index] = arr[i];
        index++;
        i++;
      } else {
        mergeArr[index] = arr[j];
        index++;
        j++;
      }
    }

    while (i <= mid) {
      mergeArr[index] = arr[i];
      index++;
      i++;
    }

    while (j <= high) {
      mergeArr[index] = arr[j];
      index++;
      j++;
    }

    for (int k = low; k <= high; k++) {
      arr[k] = mergeArr[k];
    }
  }
}
