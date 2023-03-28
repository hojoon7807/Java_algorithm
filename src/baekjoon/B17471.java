package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class B17471 {

  static int N;
  static int[] population;
  static ArrayList<ArrayList<Integer>> graph = new ArrayList();
  static boolean[] isSelected;
  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    isSelected = new boolean[N];

    population = new int[N];
    for (int i = 0; i < N; i++) {
      graph.add(new ArrayList());
    }

    String[] split = br.readLine().split(" ");

    for (int i = 0; i < N; i++) {
      population[i] = Integer.parseInt(split[i]);
      String[] info = br.readLine().split(" ");
      int m = Integer.parseInt(info[0]);
      for (int j = 1; j <= m; j++) {
        int a = i;
        int b = Integer.parseInt(info[j]) - 1;
        graph.get(a).add(b);
      }
    }

    dfs(0);

    if (min == Integer.MAX_VALUE) {
      System.out.println(-1);
    }else {
      System.out.println(min);
    }
  }

  static private void dfs(int index) {
    if (index == N) {
      ArrayList<Integer> aList = new ArrayList<>();
      ArrayList<Integer> bList = new ArrayList<>();

      for (int i = 0; i < N; i++) {
        if (isSelected[i]) {
          aList.add(i);
        } else {
          bList.add(i);
        }
      }

      if (aList.size() == N || bList.size() == N) {
        return;
      }

      if (isLinked(aList) && isLinked(bList)) {
        min = Math.min(calculatePopulation(aList, bList), min);
      }
      return;
    }

    isSelected[index] = true;
    dfs(index + 1);
    isSelected[index] = false;
    dfs(index + 1);
  }

  static private boolean isLinked(List<Integer> list) {
    LinkedList<Integer> queue = new LinkedList<>();
    boolean[] isVisited = new boolean[N];
    queue.add(list.get(0));
    isVisited[list.get(0)] = true;
    int count = 1;

    while (!queue.isEmpty()) {
      Integer current = queue.poll();
      for (Integer next : graph.get(current)) {
        if (!isVisited[next] && list.contains(next)) {
          count++;
          isVisited[next] = true;
          queue.add(next);
        }
      }
    }

    if (list.size() == count) {
      return true;
    } else {
      return false;
    }
  }

  private static int calculatePopulation(List<Integer> aList, List<Integer> bList) {
    int aSum = 0, bSum = 0;

    for (Integer value : aList) {
      aSum += population[value];
    }

    for (Integer value : bList) {
      bSum += population[value];
    }

    return Math.abs(aSum - bSum);
  }
}
