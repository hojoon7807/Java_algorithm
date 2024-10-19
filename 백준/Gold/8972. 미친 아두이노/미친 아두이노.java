import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

  static class Node {

    private int r, c;
    private boolean live;

    public Node(int r, int c) {
      this.r = r;
      this.c = c;
      this.live = true;
    }
  }

  static int R, C;
  static Node jong;
  static ArrayList<Node> mad = new ArrayList<>();
  static int[] dr = { 1, 1, 1, 0, 0, 0, -1, -1, -1 };
  static int[] dc = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    R = Integer.parseInt(input.split(" ")[0]);
    C = Integer.parseInt(input.split(" ")[1]);
    mad.add(new Node(0, 0));
    for (int r = 0; r < R; r++) {
      input = br.readLine();
      for (int c = 0; c < C; c++) {
        if (input.charAt(c) == 'I') {
          jong = new Node(r, c);
        } else if (input.charAt(c) == 'R') {
          mad.add(new Node(r, c));
        }
      }
    }
    input = br.readLine();
    for (int t = 0; t < input.length(); t++) {
      int dir = Integer.parseInt(input.substring(t, t + 1)) - 1;
      jong.r += dr[dir];
      jong.c += dc[dir];
      int[][] tmp_map = new int[R][C];
      for (int i = 1; i < mad.size(); i++) {
        Node now = mad.get(i);
        if (now.live == false) continue;
        int nd = nextDir(now.r, now.c);
        int nr = now.r + dr[nd];
        int nc = now.c + dc[nd];
        if (nr == jong.r && nc == jong.c) {
          StringBuilder sb = new StringBuilder();
          sb.append("kraj ").append(t + 1);
          System.out.println(sb.toString());
          return;
        }
        if (tmp_map[nr][nc] == 0) {
          tmp_map[nr][nc] = i;
          mad.get(i).r += dr[nd];
          mad.get(i).c += dc[nd];
        } else {
          mad.get(i).live = false;
          mad.get(tmp_map[nr][nc]).live = false;
        }
      }
    }
    br.close();
    char[][] map = new char[R][C];
    map[jong.r][jong.c] = 'I';
    for (int i = 1; i < mad.size(); i++) {
      Node now = mad.get(i);
      if (now.live == false) continue;
      map[now.r][now.c] = 'R';
    }
    StringBuilder sb = new StringBuilder();
    for (int r = 0; r < R; r++) {
      for (int c = 0; c < C; c++) {
        if (map[r][c] == 'I') {
          sb.append('I');
        } else if (map[r][c] == 'R') {
          sb.append('R');
        } else {
          sb.append('.');
        }
      }
      sb.append('\n');
    }
    System.out.print(sb.toString());
  }

  static int nextDir(int r, int c) {
    int dir = 0;
    int min_d = Integer.MAX_VALUE;
    for (int d = 0; d < 9; d++) {
      int tmp_d = Math.abs(r + dr[d] - jong.r) + Math.abs(c + dc[d] - jong.c);
      if (tmp_d < min_d) {
        min_d = tmp_d;
        dir = d;
      }
    }
    return dir;
  }
}