package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class B1939 {
  static boolean[] isVisited;
  static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NM = br.readLine().split(" ");
    int N = Integer.parseInt(NM[0]);
    int M = Integer.parseInt(NM[1]);

    for (int i = 0; i <=N; i++) {
      list.add(new ArrayList<>());
    }

    int max = Integer.MIN_VALUE;
    int min = 1;
    for (int i = 0; i < M; i++) {
      String[] ABC = br.readLine().split(" ");
      int A = Integer.parseInt(ABC[0]);
      int B = Integer.parseInt(ABC[1]);
      int C = Integer.parseInt(ABC[2]);

      list.get(A).add(new int[]{B, C});
      list.get(B).add(new int[]{A, C});

      max = Math.max(max, C);
    }

    String[] factory = br.readLine().split(" ");

    int start = Integer.parseInt(factory[0]);
    int end = Integer.parseInt(factory[1]);

    while (min <= max) {
      isVisited = new boolean[N + 1];
      int mid = (min + max)/2;

      if (bfs(start, end, mid)) {
        min = mid + 1;
      }else{
        max = mid - 1;
      }
    }

    System.out.println(max);
  }

  private static boolean bfs(int start, int end, int mid) {

    LinkedList<Integer> queue = new LinkedList<>();
    queue.add(start);
    isVisited[start] = true;

    while (!queue.isEmpty()) {
      Integer recent = queue.remove();

      if (recent == end) {
        return true;
      }

      for (int[] array : list.get(recent)) {
        if (!isVisited[array[0]] && mid <= array[1]) {
          isVisited[array[0]] = true;
          queue.add(array[0]);
        }
      }
    }
    return false;
  }

}
