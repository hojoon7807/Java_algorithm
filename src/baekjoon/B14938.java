package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class B14938 {
  static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
  static int[] items;
  static int n, m, r;

  static int max = Integer.MIN_VALUE;

  static int[] distance;

  static class Node{
    int nodeNum;
    int weight;

    public Node(int nodeNum, int weight) {
      this.nodeNum = nodeNum;
      this.weight = weight;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    n = input[0];
    m = input[1];
    r = input[2];

    distance = new int[n];

    String[] itemInput = br.readLine().split(" ");
    items = new int[itemInput.length];
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < itemInput.length; i++) {
      items[i] = Integer.parseInt(itemInput[i]);
    }

    for (int i = 0; i < r; i++) {
      String[] abl = br.readLine().split(" ");
      int a = Integer.parseInt(abl[0]);
      int b = Integer.parseInt(abl[1]);
      int l = Integer.parseInt(abl[2]);
      graph.get(a - 1).add(new Node(b - 1, l));
      graph.get(b - 1).add(new Node(a - 1, l));
    }

    for (int i = 0; i < n; i++) {
      search(i);
    }

    System.out.println(max);
  }

  static void search(int start) {
    int sum = 0;
    Arrays.fill(distance, Integer.MAX_VALUE);
    PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2) -> o1.weight - o2.weight);
    queue.add(new Node(start, 0));
    distance[start] = 0;

    while (!queue.isEmpty()) {
      Node now = queue.poll();
      int nowIndex = now.nodeNum;
      int nowDistance = now.weight;
      if (distance[nowIndex] < nowDistance) {
        continue;
      }

      for (Node next : graph.get(nowIndex)) {
        int sumDistance = distance[nowIndex] + next.weight;

        if (sumDistance < distance[next.nodeNum]) {
          distance[next.nodeNum] = sumDistance;
          queue.add(new Node(next.nodeNum, sumDistance));
        }
      }
    }
    for (int i = 0; i < n; i++) {
      if (distance[i] <= m) {
        sum += items[i];
      }
    }
    max = sum > max ? sum : max;
  }
}
