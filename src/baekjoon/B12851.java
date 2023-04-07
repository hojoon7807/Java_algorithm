package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B12851 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");

    int N = Integer.parseInt(input[0]);
    int K = Integer.parseInt(input[1]);

    LinkedList<Integer> q = new LinkedList<>();
    q.add(N);
    int[] time = new int[100001];
    time[N] = 1;
    int min = Integer.MAX_VALUE;
    int count = 0;
    if (N >= K) {
      System.out.println((N-K) + "\n1");
      return;
    }
    while(!q.isEmpty()) {
      Integer now = q.poll();

      int[] nx = {now - 1, now + 1, now * 2};

      if(min < time[now]) continue;

      for (int i = 0; i < 3; i++) {
        if (0 <= nx[i] && nx[i] <= 100000) {
          if(nx[i] == K){
            min = time[now];
            count ++;
            continue;
          }
          if (time[nx[i]] == 0||time[now] + 1 == time[nx[i]]) {
            q.add(nx[i]);
            time[nx[i]] = time[now] + 1;
          }
        }
      }
    }
    System.out.println(min + "\n" + count);
  }
}
