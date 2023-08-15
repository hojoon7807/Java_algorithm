package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class 퍼즐조각채우기 {

  int gameLen, tableLen;
  int[] dr = {1, 0, 0, -1};
  int[] dc = {0, -1, 1, 0};
  boolean[][] gameVisit;
  boolean[][] tableVisit;

  int answer = 0;

  public static void main(String[] args) {
    퍼즐조각채우기 m = new 퍼즐조각채우기();
//    System.out.println(m.solution(new int[][]{{1,1,0,0,1,0}, {0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}}, new int[][] {
//        {1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}
//    }));
    //System.out.println(m.solution(new int[][]{{0,0,0},{1,1,0},{1,1,1}}, new int[][]{{1,1,1},{1,0,0},{0,0,0}}));
    System.out.println(m.solution(new int[][]{
        {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
        {1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0},
        {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1},
        {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
        {0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1},
        {0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0},
        {0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0},
        {1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0},
        {0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0},
        {0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1},
        {0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0}
    }, new int[][]{
        {1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1},
        {1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1},
        {1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0},
        {0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0},
        {1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0},
        {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1},
        {1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1},
        {0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1},
        {1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1},
        {1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1},
        {1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1}
    }));
  }

  public int solution(int[][] game_board, int[][] table) {
    gameLen = game_board.length;
    tableLen = table.length;


    gameVisit = new boolean[gameLen][gameLen];
    tableVisit = new boolean[tableLen][tableLen];
    List<List<Node>> puzzles = new ArrayList<>();

    for (int i = 0; i < tableLen; i++) {
      for (int j = 0; j < tableLen; j++) {
        if (table[i][j] == 1 && !tableVisit[i][j]) {
          puzzles.add(getPuzzle(new Node(i, j), table));
        }
      }
    }


    for (int i = 0; i < gameLen; i++) {
      for (int j = 0; j < gameLen; j++) {
        if (game_board[i][j] == 0 && !gameVisit[i][j]) {
          fill(new Node(i, j), puzzles, game_board);
        }
      }
    }

    return answer;
  }

  public void fill(Node node, List<List<Node>> puzzles, int[][] board) {
    // 비어있는 구간과 퍼즐을 찾는다
    List<Node> empty = getEmpty(node, board);

    for (int i = 0; i < puzzles.size(); i++) {
      List<Node> puzzle = puzzles.get(i);

      if (empty.size() != puzzle.size()) {
        continue;
      }

      // rotate
      for (int j = 0; j < 3; j++) {
        // 같으면 끝냄
        if (isSame(empty, puzzle)) {
          answer += puzzle.size();
          puzzles.remove(i);
          return;
        } else {
          puzzle = puzzle.stream().map(n -> rotate(n)).collect(Collectors.toList());
          Collections.sort(puzzle);
        }
      }
    }
  }

  public boolean isSame(List<Node> empty, List<Node> puzzle) {
    int diffR = empty.get(0).r - puzzle.get(0).r;
    int diffC = empty.get(0).c - puzzle.get(0).c;
    for (int i = 1; i < empty.size(); i++) {
      Node emptyNode = empty.get(i);
      Node puzzleNode = puzzle.get(i);

      if (emptyNode.r - puzzleNode.r != diffR || emptyNode.c - puzzleNode.c != diffC) {
        return false;
      }
    }
    return true;
  }

  public Node rotate(Node node) {
    int rotateR = node.c;
    int rotateC = tableLen - node.r - 1;
    return new Node(rotateR, rotateC);
  }

  public List<Node> getEmpty(Node node, int[][] board) {
    LinkedList<Node> q = new LinkedList<>();
    q.add(node);
    gameVisit[node.r][node.c] = true;
    ArrayList<Node> empty = new ArrayList<>();
    empty.add(node);

    while (!q.isEmpty()) {
      Node recent = q.poll();

      for (int i = 0; i < 4; i++) {
        int nr = recent.r + dr[i];
        int nc = recent.c + dc[i];

        if (nr >= 0 && nr < gameLen && nc >= 0 && nc < gameLen && board[nr][nc] == 0 &&!gameVisit[nr][nc]) {
          gameVisit[nr][nc] = true;
          Node next = new Node(nr, nc);
          q.add(next);
          empty.add(next);
        }
      }
    }
    Collections.sort(empty);
    return empty;
  }

  public List<Node> getPuzzle(Node node, int[][] table) {
    LinkedList<Node> q = new LinkedList<>();
    q.add(node);
    tableVisit[node.r][node.c] = true;
    ArrayList<Node> puzzle = new ArrayList<>();
    puzzle.add(node);
    while (!q.isEmpty()) {
      Node recent = q.poll();

      for (int i = 0; i < 4; i++) {
        int nr = recent.r + dr[i];
        int nc = recent.c + dc[i];

        if (nr >= 0 && nr < tableLen && nc >= 0 && nc < tableLen && table[nr][nc] == 1 && !tableVisit[nr][nc]) {
          tableVisit[nr][nc] = true;
          Node next = new Node(nr, nc);
          q.add(next);
          puzzle.add(next);
        }
      }
    }
    Collections.sort(puzzle);
    return puzzle;
  }

  static class Node implements Comparable<Node> {

    int r;
    int c;

    public Node(int r, int c) {
      this.r = r;
      this.c = c;
    }

    @Override
    public int compareTo(Node o) {
      if (this.r == o.r) {
        return this.c - o.c;
      } else {
        return this.r - o.r;
      }
    }
  }

}
