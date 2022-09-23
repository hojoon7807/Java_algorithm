package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class B1933 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Building> queue = new PriorityQueue<>((o1, o2) -> {
      if (o1.x == o2.x) {
        return o2.height - o1.height;
      }
      return o1.x - o2.x;
    });


    for (int i = 0; i < N; i++) {
      String[] input = br.readLine().split(" ");
      for (int j = 0; j < 3; j++) {
        int start = Integer.parseInt(input[0]);
        int height = Integer.parseInt(input[1]);
        int end = Integer.parseInt(input[2]);
        queue.add(new Building(start, height));
        queue.add(new Building(end, -height));
      }
    }

    int maxHeight = 0;
    TreeMap<Integer, Integer> map = new TreeMap<>((o1, o2) -> o2 - o1);
    StringBuilder sb = new StringBuilder();
    map.put(0, 1);

    while (!queue.isEmpty()) {
      Building building = queue.poll();

      if (building.height > 0) {
        map.put(building.height, map.getOrDefault(building.height, 0) + 1);
      } else {
        Integer val = map.get(-building.height);
        if (val == 1) {
          map.remove(-building.height);
        } else {
          map.replace(-building.height, val - 1);
        }
      }

      int height = map.firstKey();

      if (height != maxHeight) {
        sb.append(building.x + " " + height + " ");
        maxHeight = height;
      }
    }

    System.out.println(sb.toString());
  }

  static class Building{
    int x;
    int height;

    public Building(int x, int height) {
      this.x = x;
      this.height = height;
    }
  }

}
