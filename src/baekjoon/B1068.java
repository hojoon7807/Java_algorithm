package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B1068 {

  static ArrayList<Integer>[] child;
  static int[] leaf;
  static int root;

  static int deleteNode;
  static int n;
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    child = new ArrayList[n];

    for (int i = 0; i < n; i++) {
      child[i] = new ArrayList<>();
    }
    leaf = new int[n];
    String[] input = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      int parent = Integer.parseInt(input[i]);
      if (parent == -1) {
        root = i;
      } else {
        child[parent].add(i);
      }
    }

    deleteNode = Integer.parseInt(br.readLine());
    disconnect();

    if (root != deleteNode) {
      dfs(root, -1);
    }

    System.out.println(leaf[root]);
  }

  private static void disconnect(){
    for (int i = 0; i < n; i++) {
      if (child[i].contains(deleteNode)) {
        child[i].remove(child[i].indexOf(deleteNode));
      }
    }
  }

  private static void dfs(int node, int parent) {
    if (child[node].isEmpty()) {
      leaf[node] ++;
    }

    for (Integer child : child[node]) {
//      if (child == parent) {
//        continue;
//      }

      dfs(child, node);
      leaf[node] += leaf[child];
    }
  }
}
