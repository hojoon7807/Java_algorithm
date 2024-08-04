
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static int[] arr;
  static boolean[] isVisited;
  static TreeSet<Integer> set = new TreeSet<>();

  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());
    isVisited = new boolean[n + 1];

    arr = new int[n + 1];

    for (int i = 0; i < n; i++) {
      arr[i + 1] = Integer.parseInt(br.readLine());
    }

    for (int i = 1; i <= n; i++) {
      isVisited = new boolean[n + 1];
      dfs(i, new ArrayList<>(), new ArrayList<>());
    }

    StringBuilder sb = new StringBuilder();
    sb.append(set.size()).append("\n");

    for (int i : set) {
      sb.append(i).append("\n");
    }

    System.out.println(sb);
  }

  static void dfs(int start, ArrayList<Integer> upArr, ArrayList<Integer> downArr) {
    if (isVisited[start]) {
      Collections.sort(upArr);
      Collections.sort(downArr);

      for (int i = 0; i < upArr.size(); i++) {
        if (!upArr.get(i).equals(downArr.get(i))) {
          return;
        }
      }

      set.addAll(upArr);
      return;
    }

    isVisited[start] = true;
    upArr.add(start);
    downArr.add(arr[start]);
    dfs(arr[start], upArr, downArr);
  }
}
