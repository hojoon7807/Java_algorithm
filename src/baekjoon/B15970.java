package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B15970 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static Node[] arr;
  static int[] dist;

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void input() throws IOException {
    n = Integer.parseInt(br.readLine());
    arr = new Node[n];
    dist = new int[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int point = Integer.parseInt(st.nextToken());
      int color = Integer.parseInt(st.nextToken());

      arr[i] = new Node(point, color);
    }
  }

  static void solution(){
    Arrays.sort(arr, Comparator.comparingInt(o -> o.point));
    for (int i = 0; i < n-1; i++) {
      for (int j = i+1; j < n; j++) {
        if (arr[i].color == arr[j].color) {
          dist[i] = arr[j].point - arr[i].point;
          break;
        }
      }
    }

    for (int i = n-1; i >= 1 ; i--) {
      for (int j = i - 1; j >= 0; j--) {
        if (arr[i].color == arr[j].color) {
          int diff = arr[i].point - arr[j].point;
          if (diff < dist[i] || dist[i] == 0) {
            dist[i] = diff;
            break;
          }
        }
      }
    }

    int answer = 0;
    for (int i = 0; i < n; i++) {
      answer += dist[i];
    }

    System.out.println(answer);
  }
  static class Node {
    int point;
    int color;

    public Node(int point, int color) {
      this.point = point;
      this.color = color;
    }
  }
}
