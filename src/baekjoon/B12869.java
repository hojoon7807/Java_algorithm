package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class B12869 {
  static int n;
  static int[] scv;
  static int[] attack = {9, 3, 1};
  static ArrayList<ArrayList<Integer>> combines = new ArrayList<>();
  static HashSet<String> set = new HashSet<>();
  static boolean[] isVisited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    String[] input = br.readLine().split(" ");

    isVisited = new boolean[n];
    scv = new int[n];
    for (int i = 0; i < n; i++) {
      scv[i] = Integer.parseInt(input[i]);
    }

    getCombine(0, new ArrayList<>());

        //12 10 4 , 3, 9 ,1
    LinkedList<ArrayList<Integer>> q = new LinkedList<>();
    for (int i = 0; i < combines.size(); i++) {
      ArrayList<Integer> list = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        list.add(scv[combines.get(i).get(j)]);
      }
      list.add(0);
      q.add(list);
    }

    int answer =0;
    while (!q.isEmpty()) {
      ArrayList<Integer> poll = q.poll();

      if(isEnd(poll)){
        answer = poll.get(n);
        break;
      }

      for (int i = 0; i < combines.size(); i++) {
        ArrayList<Integer> list = new ArrayList<>();
        String string = "";
        for (int j = 0; j < n; j++) {
          int remain = poll.get(combines.get(i).get(j)) - attack[j];
          list.add(remain);
          string += remain;
        }
        if (!set.contains(string)) {
          list.add(poll.get(n) + 1);
          q.add(list);
          set.add(string);
        }

      }
    }
    System.out.println(answer);
  }

  private static boolean isEnd(ArrayList<Integer> list) {
    for (int i = 0; i < n; i++) {
      if (list.get(i) > 0) {
        return false;
      }
    }
    return true;
  }


  private static void getCombine(int depth, ArrayList<Integer> combine){
    if (depth == n) {
      combines.add(new ArrayList<>(combine));
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!isVisited[i]) {
        isVisited[i] = true;
        combine.add(i);
        getCombine(depth + 1, combine);
        isVisited[i] = false;
        combine.remove(depth);
      }
    }
  }

}
