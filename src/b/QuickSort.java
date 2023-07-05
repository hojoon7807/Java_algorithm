package b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuickSort {
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    quickSort(arr, 0, n - 1);

    StringBuilder sb = new StringBuilder();
    for (int i : arr) {
      sb.append(i + " ");
    }

    System.out.println(sb);
  }

  private static int partition(int[] arr, int low, int high) {
    int pivot = selectPivot(arr, low, high);
    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (arr[j] < pivot) {
        i++;
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
      }
    }
    int tmp = arr[i+1];
    arr[i + 1] = arr[high];
    arr[high] = tmp;

    return i+1;
  }

  private static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int pos = partition(arr, low, high);
      quickSort(arr, low, pos -1 );
      quickSort(arr, pos+1, high);
    }
  }

  private static int selectPivot(int[] arr, int low, int high) {
    int len = high - low + 1;

//    if (len <= 3) {
//      return arr[high];
//    } else {
//      int frontValue = arr[low];
//      int backValue = arr[high];
//      int midValue = arr[(low + high) / 2];
//
//      int[] tmpArr = {frontValue, backValue, midValue};
//      Arrays.sort(tmpArr);
//
//      return tmpArr[1];
//    }
//  }

    return arr[high];
  }
}
