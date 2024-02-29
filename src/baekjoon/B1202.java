package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B1202 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, k;
  static int[] bags;
  static Jewellery[] jewelleries;
  static long answer = 0;

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void solution(){
    Arrays.sort(bags);
    Arrays.sort(jewelleries, Comparator.comparingInt(o -> o.weight));

    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    int index = 0;
    for (int i = 0; i < bags.length; i++) {
      while (index < jewelleries.length && jewelleries[index].weight <= bags[i]) {
        pq.add(jewelleries[index].price);
        index ++;
      }

      if (!pq.isEmpty()) {
        answer += pq.poll();
      }
    }

    System.out.println(answer);
  }

  static void input() throws IOException {
    String[] input = br.readLine().split(" ");

    n = Integer.parseInt(input[0]);
    k = Integer.parseInt(input[1]);

    jewelleries = new Jewellery[n];
    bags = new int[k];

    for (int i = 0; i < n; i++) {
      input = br.readLine().split(" ");
      int m = Integer.parseInt(input[0]);
      int v = Integer.parseInt(input[1]);

      jewelleries[i] = new Jewellery(m, v);
    }

    for (int i = 0; i < k; i++) {
      bags[i] = Integer.parseInt(br.readLine());
    }
  }

  static class Jewellery {
    int weight;
    int price;

    public Jewellery(int weight, int price) {
      this.weight = weight;
      this.price = price;
    }
  }

}
