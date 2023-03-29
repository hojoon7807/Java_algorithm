package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12891 {
  static int[] check = new int[4];
  static int[] myPasswordCheck = new int[4];
  static int checkCount = 0;
  static int answer = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int S = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());

    String DNA = br.readLine();

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < 4; i++) {
      check[i] = Integer.parseInt(st.nextToken());
      if (check[i] == 0) {
        checkCount++;
      }
    }

    for (int i = 0; i < P; i++) {
      add(DNA.charAt(i));
    }

    if (checkCount == 4) {
      answer++;
    }

    for (int i = 0; i < S-P ; i++) {
      add(DNA.charAt(P + i));
      delete(DNA.charAt(i));

      if (checkCount == 4) {
        answer ++;
      }
    }

    System.out.println(answer);
  }

  private static void add(char c) {
    switch (c) {
      case 'A':
        myPasswordCheck[0]++;
        if (myPasswordCheck[0] == check[0]) {
          checkCount++;
        }
        break;
      case 'C':
        myPasswordCheck[1]++;
        if (myPasswordCheck[1] == check[1]) {
          checkCount++;
        }
        break;
      case 'G':
        myPasswordCheck[2]++;
        if (myPasswordCheck[2] == check[2]) {
          checkCount++;
        }
        break;
      case 'T':
        myPasswordCheck[3]++;
        if (myPasswordCheck[3] == check[3]) {
          checkCount++;
        }
        break;
    }
  }

  private static void delete(char c) {
    switch (c) {
      case 'A':
        if (myPasswordCheck[0] == check[0]) {
          checkCount--;
        }
        myPasswordCheck[0]--;
        break;
      case 'C':
        if (myPasswordCheck[1] == check[1]) {
          checkCount--;
        }
        myPasswordCheck[1]--;
        break;
      case 'G':
        if (myPasswordCheck[2] == check[2]) {
          checkCount--;
        }
        myPasswordCheck[2]--;
        break;
      case 'T':
        if (myPasswordCheck[3] == check[3]) {
          checkCount--;
        }
        myPasswordCheck[3]--;
        break;
    }
  }
}
