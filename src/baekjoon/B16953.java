package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;

public class B16953 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] split = br.readLine().split(" ");
    HashSet<Long> visitedSet = new HashSet<>();
    long a = Long.parseLong(split[0]);
    long b = Long.parseLong(split[1]);

    LinkedList<long[]> q = new LinkedList<>();
    q.add(new long[]{a, 1});

    while (!q.isEmpty()) {
      long[] poll = q.poll();
      long recentNum = poll[0];
      long recentCount = poll[1];

      if (recentNum == b) {
        System.out.println(recentCount);
        return;
      }

      long nextDoubleNum = recentNum * 2;
      long nextPlusNum = recentNum * 10 + 1;

      if (nextDoubleNum <= b) {
        if (!visitedSet.contains(nextDoubleNum)) {
          visitedSet.add(nextDoubleNum);
          q.add(new long[]{nextDoubleNum, recentCount + 1});
        }
      }

      if (nextPlusNum <= b) {
        if (!visitedSet.contains(nextPlusNum)) {
          visitedSet.add(nextPlusNum);
          q.add(new long[]{nextPlusNum, recentCount + 1});
        }
      }
    }
    System.out.println(-1);
  }
}
