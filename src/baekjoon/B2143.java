package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B2143 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<Integer, Integer> aMap = new HashMap<>();
    int T = Integer.parseInt(br.readLine());
    int N = Integer.parseInt(br.readLine());
    String[] aInput = br.readLine().split(" ");
    long answer = 0;
    for (int i = 0; i < N; i++) {
      int sum = Integer.parseInt(aInput[i]);
      for (int j = i; j < N; j++) {
        if (j == i) {
          aMap.put(sum, aMap.getOrDefault(sum, 0) + 1);
        } else {
          sum += Integer.parseInt(aInput[j]);
          aMap.put(sum, aMap.getOrDefault(sum, 0) + 1);
        }
      }
    }

    int M = Integer.parseInt(br.readLine());
    String[] bInput = br.readLine().split(" ");
    for (int i = 0; i < M; i++) {
      int sum = Integer.parseInt(bInput[i]);
      for (int j = i; j < M; j++) {
        if (j == i) {
          int tmp = T - sum;
          answer += aMap.getOrDefault(tmp, 0);
        } else {
          sum += Integer.parseInt(bInput[j]);
          int tmp = T - sum;
          answer += aMap.getOrDefault(tmp, 0);
        }
      }
    }
    System.out.println(answer);
  }

}
