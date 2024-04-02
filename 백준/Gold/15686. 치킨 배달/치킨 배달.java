
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

  static private class Node {

    int r;
    int c;

    public Node(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }

  static int N;
  static int M;
  static int min = Integer.MAX_VALUE;
  static ArrayList<Node> chickens = new ArrayList<>();
  static ArrayList<Node> people = new ArrayList<>();
  static boolean[] isVisited;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NM = br.readLine().split(" ");

    N = Integer.parseInt(NM[0]);
    M = Integer.parseInt(NM[1]);

    for (int i = 0; i < N; i++) {
      String[] input = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        if (input[j].equals("2")) {
          chickens.add(new Node(i, j));
        } else if (input[j].equals("1")) {
          people.add(new Node(i, j));
        }
      }
    }

    isVisited = new boolean[chickens.size()];

    dfs(0, 0);

    System.out.println(min);
  }

  static void dfs(int start, int count) {
    if (count == M) {
      int sum = 0;
      for (int i = 0; i < people.size(); i++) {
        int tmp = Integer.MAX_VALUE;
        for (int j = 0; j < chickens.size(); j++) {
          if (isVisited[j]) {
            int dist = Math.abs(people.get(i).r - chickens.get(j).r) + Math.abs(
                people.get(i).c - chickens.get(j).c);

            tmp = Math.min(dist, tmp);
          }
        }
        sum += tmp;
      }
      min = Math.min(sum, min);
      return;
    }

    for (int i = start; i < chickens.size(); i++) {
      isVisited[i] = true;
      dfs(i + 1, count + 1);
      isVisited[i] = false;
    }
  }
}

