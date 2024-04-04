import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static int[] arr;

  /*
  개념 및 접근
  ----------------------
  - o(n^3) = 1,000,000,000 터질 가능성 높다
  - 두수의 합을 Set add -> 두수의 합을 구할 때 같은 수의 합도 가능, 합이 중복될 경우 존재
  - 이중 for 문을 돌면서 arr[i] - arr[j] 가 set에 존재하는지 확인
   */

  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());
    arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    HashSet<Integer> sumSet = new HashSet<>();
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        sumSet.add(arr[i] + arr[j]);
      }
    }

    Arrays.sort(arr);
    for (int i = n - 1; i >= 0; i--) {
      for (int j = 0; j < n-1; j++) {
        int diff = arr[i] - arr[j];
        if (diff > 0) {
          if (sumSet.contains(diff)) {
            System.out.println(arr[i]);
            return;
          }
        }
      }
    }
  }
}
