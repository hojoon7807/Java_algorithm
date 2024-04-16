import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, k;
  static int[] arr;

  /*
  2
  1 3 6 6 7 9

  2 3 0 1 2

  총 거리에서 차이를 빼자

  5
  3 6 7 8 10 12 14 15 18 20

  3 1 1 2 2 2 1 3 2
   */
  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());
    k = Integer.parseInt(br.readLine());

    arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

    if (n <= k) {
      System.out.println(0);
      return;
    }
    
    Arrays.sort(arr);

    int[] diff = new int[n - 1];

    for (int i = 0; i < n - 1; i++) {
      diff[i] = arr[i + 1] - arr[i];
    }

    int answer = arr[n - 1] - arr[0];

    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    for (int i : diff) {
      pq.add(i);
    }

    for (int i = 0; i < k - 1; i++) {
      answer -= pq.poll();
    }

    System.out.println(answer);
  }

}
