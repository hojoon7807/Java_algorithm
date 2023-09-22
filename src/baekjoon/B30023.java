package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class B30023 {

  static Map<String, String> map = Map.of("R", "G", "G", "B", "B", "R");
  static int n;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    String[] rgbs = br.readLine().split("");

    int count = 0;
    int answer = Integer.MAX_VALUE;
    for (int i = 0; i < 3; i++) {
      String[] clone = rgbs.clone();
      for (int j = 0; j < n - 2; j++) {
        // red
        if (i == 0) {
          while (!clone[j].equals("R")) {
            clone[j] = map.get(clone[j]);
            clone[j+1] = map.get(clone[j+1]);
            clone[j+2] = map.get(clone[j+2]);
            count ++;
          }
        }
        // green
        if (i == 1) {
          while (!clone[j].equals("G")) {
            clone[j] = map.get(clone[j]);
            clone[j+1] = map.get(clone[j+1]);
            clone[j+2] = map.get(clone[j+2]);
            count ++;
          }
        }
        // blue
        if (i == 2) {
          while (!clone[j].equals("B")) {
            clone[j] = map.get(clone[j]);
            clone[j+1] = map.get(clone[j+1]);
            clone[j+2] = map.get(clone[j+2]);
            count ++;
          }
        }
      }

      if (isSame(clone)) {
        answer = Math.min(answer, count);
      }
      count = 0;
    }

    System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

  }

  static boolean isSame(String[] rgbs){
    String head = rgbs[0];
    for (int i = 1; i < n; i++) {
      if (!head.equals(rgbs[i])) {
        return false;
      }
    }
    return true;
  }

}
