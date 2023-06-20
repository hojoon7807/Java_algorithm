package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class B16235 {

  static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
  static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

  static int[][] A;
  static int[][] ground;
  static LinkedList<Tree> trees = new LinkedList<>();
  static ArrayList<Tree> deadTrees = new ArrayList<>();


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");

    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);
    int k = Integer.parseInt(input[2]);

    A = new int[N][N];
    ground = new int[N][N];

    for (int i = 0; i < N; i++) {
      input = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        A[i][j] = Integer.parseInt(input[j]);
      }
    }

    for (int[] ints : ground) {
      Arrays.fill(ints, 5);
    }

    for (int i = 0; i < M; i++) {
      input = br.readLine().split(" ");
      int r = Integer.parseInt(input[0]) - 1;
      int c = Integer.parseInt(input[1]) - 1;
      int age = Integer.parseInt(input[2]);

      trees.add(new Tree(r, c, age));
    }

    trees.sort(Comparator.comparingInt(tree -> tree.age));
    while (k > 0) {
      spring();
      summer();
      fall();
      winter();
      k--;
    }

    System.out.println(trees.size());
  }

  static void spring() {
    for (int i = 0; i < trees.size(); ) {
      Tree recent = trees.poll();
      if (ground[recent.r][recent.c] < recent.age) {
        deadTrees.add(recent);
      } else {
        ground[recent.r][recent.c] -= recent.age;
        recent.age++;
        trees.add(recent);
        i++;
      }
    }
  }

  static void summer() {
    for (Tree tree : deadTrees) {
      int add = tree.age / 2;
      ground[tree.r][tree.c] += add;
    }
    deadTrees.clear();
  }

  static void fall() {
    List<Tree> newTrees = new LinkedList<>();
    for (Tree tree : trees) {
      if (tree.age % 5 == 0) {
        for (int i = 0; i < 8; i++) {
          int nr = tree.r + dr[i];
          int nc = tree.c + dc[i];

          if (nr >= 0 && nr < ground.length && nc >= 0 && nc < ground.length) {
            newTrees.add(new Tree(nr, nc, 1));
          }
        }
      }
    }
    trees.addAll(0, newTrees);
  }

  static void winter() {
    for (int i = 0; i < ground.length; i++) {
      for (int j = 0; j < ground.length; j++) {
        ground[i][j] += A[i][j];
      }
    }
  }

  static class Tree {

    int r;
    int c;
    int age;

    public Tree(int r, int c, int age) {
      this.r = r;
      this.c = c;
      this.age = age;
    }
  }

}
