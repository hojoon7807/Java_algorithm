package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11659 {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer StringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int N = Integer.parseInt(StringTokenizer.nextToken());
    int M = Integer.parseInt(StringTokenizer.nextToken());

    long[] S = new long[N + 1];

    StringTokenizer = new StringTokenizer(bufferedReader.readLine());

    for (int i = 1; i <= N; i++) {
      S[i] = S[i - 1] + Integer.parseInt(StringTokenizer.nextToken());
    }

    StringBuilder sb = new StringBuilder();

    for (int q = 0; q < M; q++) {
      StringTokenizer = new StringTokenizer(bufferedReader.readLine());
      int i = Integer.parseInt(StringTokenizer.nextToken());
      int j = Integer.parseInt(StringTokenizer.nextToken());

      sb.append(S[j]-S[i-1]).append("\n");
    }
    System.out.println(sb);
  }
}
