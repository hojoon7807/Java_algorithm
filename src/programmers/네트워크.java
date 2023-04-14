package programmers;

import java.io.IOException;
import java.util.HashSet;

public class 네트워크 {

  static int[] parent;
  public static void main(String[] args) throws IOException {
    int n = 7;
    int[][] arr = {
        {1,0,0,0,0,0,1},
        {0,1,1,0,1,0,0},
        {0,1,1,1,0,0,0},
        {0,0,1,1,0,0,0},
        {0,1,0,0,1,1,0},
        {0,0,0,0,1,1,1},
        {1,0,0,0,0,1,1}
    };

    solution(n, arr);
  }

  public static int solution(int n, int[][] computers) {
    int answer = 0;
    parent = new int[n];

    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
    for (int i = 0; i < n; i++) {
      for (int j = i+1; j < n; j++) {
        if (computers[i][j] == 1) {
          union(i,j);
        }
      }
    }

    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      set.add(find(parent[i]));
    }
    return set.size();
  }

  private static int find(int a) {
    if (parent[a] == a) {
      return a;
    }else {
      return parent[a] = find(parent[a]);
    }
  }

  private static void union(int a, int b){
    a = find(a);
    b = find(b);

    if (a < b) {
      parent[b] = a;
    } else if (a > b) {
      parent[a] = b;
    }
  }
}
