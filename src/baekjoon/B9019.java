package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B9019 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      boolean[] isVisited = new boolean[10000];
      String[] t = br.readLine().split(" ");
      LinkedList<Result> q = new LinkedList<>();

      q.add(new Result(Integer.parseInt(t[0]), ""));
      isVisited[Integer.parseInt(t[0])] = true;

      while (!q.isEmpty()) {
        Result now = q.remove();

        if (now.num == Integer.parseInt(t[1])) {
          System.out.println(now.string);
          break;
        }

        int D = now.num * 2 > 9999 ? now.num % 10000 : now.num * 2;
        int S = now.num == 0 ? 9999 : now.num - 1;
        int L = now.num % 1000 * 10 + now.num / 1000;
        int R = now.num % 10 * 1000 + now.num / 10;

        if (!isVisited[D]) {
          q.add(new Result(D, now.string + "D"));
          isVisited[D] = true;
        }

        if (!isVisited[S]) {
          q.add(new Result(S, now.string + "S"));
          isVisited[S] = true;
        }

        if (!isVisited[L]) {
          q.add(new Result(L, now.string + "L"));
          isVisited[L] = true;
        }

        if (!isVisited[R]) {
          q.add(new Result(R, now.string + "R"));
          isVisited[R] = true;
        }
      }
    }
  }

  static class Result {
    int num;
    String string;

    public Result(int num, String string) {
      this.num = num;
      this.string = string;
    }
  }

}
