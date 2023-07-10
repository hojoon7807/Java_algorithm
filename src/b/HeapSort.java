package b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeapSort {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n + 1];

    String[] input = br.readLine().split(" ");
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(input[i - 1]);
    }

    heapSort(arr, n);

    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= n; i++) {
      sb.append(arr[i] + " ");
    }

    System.out.println(sb);

  }

  private static void heapify(int[] arr, int n, int node) {
    int largest = node;
    int left = node * 2;
    int right = node * 2 + 1;

    if (left <= n && arr[left] > arr[largest]) {
      largest = left;
    }

    if (right <= n && arr[right] > arr[largest]) {
      largest = right;
    }

    if (largest != node) {
      swap(arr, node, largest);
      heapify(arr, n, largest);
    }
  }

  private static void heapSort(int[] arr, int n) {
    for (int i = n / 2; i >= 1; i--) {
      heapify(arr, n, i);
    }

    for (int i = n; i > 1; i--) {
      swap(arr, i, 1);
      heapify(arr, i - 1, 1);
    }
  }

  private static void swap(int[] arr, int a, int b) {
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }
}
