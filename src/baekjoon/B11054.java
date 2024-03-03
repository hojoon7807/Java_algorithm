package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B11054 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static int[] arr;
  static ArrayList<Integer> list = new ArrayList<>();

  public static void main(String[] args) throws IOException {

    input();
    solution();
  }

  static void solution() {
    int answer = 0;
    for (int i = 0; i < n; i++) {
      int sum = 0;
      int pivot = arr[i];
      for (int j = 0; j < i; j++) {
        int target = arr[j];
        if (target < pivot) {
          if (list.isEmpty() || list.get(list.size() - 1) < target) {
            list.add(target);
          } else {
            int index = binarySearch(target);
            list.set(index, target);
          }
        }

      }


      sum += list.size();
      list.clear();

      for (int j = n-1; j > i; j--) {
        int target = arr[j];
        if (target < pivot) {
          if (list.isEmpty() || list.get(list.size() - 1) < target) {
            list.add(target);
          } else {
            int index = binarySearch(target);
            list.set(index, target);
          }
        }
      }

      sum += list.size() + 1;

      answer = Math.max(sum, answer);
      list.clear();
    }

    System.out.println(answer);
  }

  static int binarySearch(int target) {
    int left = -1;
    int right = list.size();

    while (left + 1 < right) {
      int mid = (left + right) >> 1;
      // target <= list.get(mid)
      if (list.get(mid) >= target) {
        right = mid;
      } else {
        left = mid;
      }
    }

    return right;
  }

  static void input() throws IOException {
    n = Integer.parseInt(br.readLine());
    arr = new int[n];
    String[] input = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }
  }

}
