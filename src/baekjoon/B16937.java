package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B16937 {

  static int H;
  static int W;
  static int N;
  static Sticker[] stickers;
  static int max = 0;
  static boolean[] isVisited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] HW = br.readLine().split(" ");
    H = Integer.parseInt(HW[0]);
    W = Integer.parseInt(HW[1]);

    N = Integer.parseInt(br.readLine());

    stickers = new Sticker[N];
    isVisited = new boolean[N];

    for (int i = 0; i < N; i++) {
      String[] rc = br.readLine().split(" ");
      stickers[i] = new Sticker(Integer.parseInt(rc[0]), Integer.parseInt(rc[1]));
    }

    for (int i = 0; i < N - 1; i++) {
      Sticker first = stickers[i];
      for (int j = i + 1; j < N; j++) {
        Sticker second = stickers[j];

        // 회전 x
        if (first.r + second.r <= H && Math.max(first.c, second.c) <= W ||
            first.r + second.r <= W && Math.max(first.c, second.c) <= H) {
          max = Math.max(max, first.getArea() + second.getArea());
        }

        // first 회전
        else if (first.c + second.r <= H && Math.max(first.r, second.c) <= W ||
            first.c + second.r <= W && Math.max(first.r, second.c) <= H) {
          max = Math.max(max, first.getArea() + second.getArea());
        }

        // second 회전
        else if (first.r + second.c <= H && Math.max(first.c, second.r) <= W ||
            first.r + second.c <= W && Math.max(first.c, second.r) <= H) {
          max = Math.max(max, first.getArea() + second.getArea());
        }
        // first, second 회전
        else if (first.c + second.c <= H && Math.max(first.r, second.r) <= W ||
            first.c + second.c <= W && Math.max(first.r, second.r) <= H) {
          max = Math.max(max, first.getArea() + second.getArea());
        }
      }
    }

    System.out.println(max);

  }

//  static private void dfs(int depth, int h, int w, int area) {
//    if (depth == 2) {
//      max = Math.max(max, area);
//      return;
//    }
//
//    for (int i = 0; i < N; i++) {
//      if (!isVisited[i]) {
//        isVisited[i] = true;
//        Sticker sticker = stickers[i];
//        int r = sticker.r;
//        int c = sticker.c;
//
//        if (h + r <= H && c <= W) {
//          dfs(depth + 1, h + r, c, area + sticker.getArea());
//          isVisited[i] = false;
//          continue;
//        }
//
//        if (r <= H && w + c <= W) {
//          dfs(depth + 1, r, w + c, area + sticker.getArea());
//          isVisited[i] = false;
//          continue;
//        }
//        if (h + c <= H && r <= W) {
//          dfs(depth + 1, h + r, c, area + sticker.getArea());
//          isVisited[i] = false;
//          continue;
//        }
//
//        if (c <= H && w + r <= W) {
//          dfs(depth + 1, r, w + c, area + sticker.getArea());
//          isVisited[i] = false;
//          continue;
//        }
//        isVisited[i] = false;
//      }
//    }


  static class Sticker {

    int r;
    int c;

    public Sticker(int r, int c) {
      this.r = r;
      this.c = c;
    }

    public int getArea() {
      return r * c;
    }
  }

}
