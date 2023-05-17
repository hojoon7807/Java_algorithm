package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B1043 {

  private static int[] parent;
  private static ArrayList<ArrayList<Integer>> parties = new ArrayList<>();
  private static int[] knownPeople;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");

    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);

    parent = new int[N+1];

    for (int i = 0; i < M; i++) {
      parties.add(new ArrayList<>());
    }

    for (int i = 0; i <= N; i++) {
      parent[i] = i;
    }

    input = br.readLine().split(" ");
    int knownTrue = Integer.parseInt(input[0]);

    if (knownTrue == 0) {
      System.out.println(M);
      return;
    } else if (knownTrue == N) {
      System.out.println(0);
      return;
    }
    knownPeople = new int[knownTrue];

    for (int i = 0; i < knownTrue; i++) {
      knownPeople[i] = Integer.parseInt(input[i]);
    }

    for (int i = 0; i < M; i++) {
      input = br.readLine().split(" ");
      int partyPeople = Integer.parseInt(input[0]);
      int recent = -1;
      int prev;
      for (int j = 0; j < partyPeople; j++) {
        if (j > 0) {
          prev = recent;
          recent = Integer.parseInt(input[j]);
          union(prev, recent);
        } else {
          recent = Integer.parseInt(input[j]);
        }
        parties.get(i).add(recent);
      }
    }

    for (ArrayList<Integer> party : parties) {
      boolean flag = false;
      for (Integer partyPerson : party) {
        if(flag) break;
        for (int knownPerson : knownPeople) {
          if (find(partyPerson) == find(knownPerson)) {
            flag = true;
            break;
          }
        }
      }
      if (flag) M--;
    }

    System.out.println(M);
  }

  private static int find(int x) {
    if (x != parent[x]) {
      parent[x] = find(parent[x]);
    }

    return parent[x];
  }

  private static void union(int x, int y) {
    x = find(x);
    y = find(y);

    if (x != y) {
      parent[y] = x;
    }
  }

}
