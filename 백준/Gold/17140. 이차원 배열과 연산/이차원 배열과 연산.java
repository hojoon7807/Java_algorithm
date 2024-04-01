import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {

  static int[][] a = new int[101][101];
  static int r, c, k;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int maxR = 3, maxC = 3;

  public static void main(String[] args) throws IOException {
    String[] rck = br.readLine().split(" ");
    r = Integer.parseInt(rck[0]);
    c = Integer.parseInt(rck[1]);
    k = Integer.parseInt(rck[2]);

    for (int i = 1; i <= 3; i++) {
      String[] input = br.readLine().split(" ");
      for (int j = 1; j <= 3; j++) {
        a[i][j] = Integer.parseInt(input[j - 1]);
      }
    }

    int count = 0;

    while (count <= 100) {
      if (a[r][c] == k) {
        System.out.println(count);
        return;
      }

      count++;
      if (maxR >= maxC) {
        r();
      } else {
        c();
      }
    }

    System.out.println(-1);
  }

  static void r() {
    HashMap<Integer, Integer> map = new HashMap<>();
    PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
      if (o1.count == o2.count) {
        return o1.num - o2.num;
      } else {
        return o1.count - o2.count;
      }
    });
    
    for (int i = 1; i <= maxR; i++) {
      for (int j = 1; j <= maxC; j++) {
        // 0 일 때 무시
        if (a[i][j] != 0) {
          int num = a[i][j];
          map.put(num, map.getOrDefault(num, 0) + 1);
          a[i][j] = 0;
        }
      }
      
      map.forEach((k, v) -> pq.add(new Pair(k, v)));
      map.clear();

      int index = 1;
      while (!pq.isEmpty()) {
        if (index > 100) {
          break;
        }

        Pair cur = pq.poll();

        a[i][index++] = cur.num;
        a[i][index] = cur.count;

        maxC = Math.max(maxC, index);
        index++;
      }
      
      pq.clear();
    }
  }

  static void c() {
    HashMap<Integer, Integer> map = new HashMap<>();
    PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
      if (o1.count == o2.count) {
        return o1.num - o2.num;
      } else {
        return o1.count - o2.count;
      }
    });
    
    for (int i = 1; i <= maxC; i++) {
      for (int j = 1; j <= maxR; j++) {
        if (a[j][i] != 0) {
          int num = a[j][i];
          map.put(num, map.getOrDefault(num, 0) + 1);
          a[j][i] = 0;
        }
      }
      
      map.forEach((k, v) -> pq.add(new Pair(k, v)));
      map.clear();

      int index = 1;
      while (!pq.isEmpty()) {
        if (index == 100) {
          break;
        }

        Pair cur = pq.poll();

        a[index++][i] = cur.num;
        a[index][i] = cur.count;

        maxR = Math.max(maxR, index);
        index++;
      }
      
      pq.clear();
    }
  }

  static class Pair {

    int num;
    int count;

    public Pair(int num, int count) {
      this.num = num;
      this.count = count;
    }
  }

}
