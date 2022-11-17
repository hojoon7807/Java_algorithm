package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B20055 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NK = br.readLine().split(" ");

    String[] A = br.readLine().split(" ");
    int N = Integer.parseInt(NK[0]);
    int K = Integer.parseInt(NK[1]);

    LinkedList<Belt> container = new LinkedList<>();

    for (int i = 0; i < 2 * N; i++) {
      container.add(new Belt(Integer.parseInt(A[i])));
    }

    int count = 0;

    while (K>0) {
      count++;
      // step 1
      Belt belt = container.pollLast();
      container.addFirst(belt);

      Belt downBelt = container.get(N - 1);
      downBelt.robot = false;

      //step 2
      for (int i = N - 2; i > 0; i--) {
        Belt recentBelt = container.get(i);
        if (recentBelt.robot) {
          Belt nextBelt = container.get(i + 1);
          if (!nextBelt.robot && nextBelt.durability > 0) {
            if (i + 1 == N - 1) {
              recentBelt.robot = false;
              nextBelt.durability--;
              if (nextBelt.durability == 0) {
                K--;
              }
            } else {
              recentBelt.robot = false;
              nextBelt.robot = true;
              nextBelt.durability--;
              if (nextBelt.durability == 0) {
                K--;
              }
            }
          }
        }
      }

      //step 3
      Belt upBelt = container.get(0);
      if (!upBelt.robot && upBelt.durability > 0) {
        upBelt.robot = true;
        upBelt.durability--;
        if (upBelt.durability == 0) {
          K--;
        }
      }
    }
    System.out.println(count);
  }

  static class Belt {
    int durability;
    boolean robot;

    public Belt(int durability) {
      this.durability = durability;
    }
  }
}
