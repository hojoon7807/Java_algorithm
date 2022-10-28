package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;

public class B14425 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] NM = br.readLine().split(" ");

    HashMap<String, Integer> s = new HashMap<>();

    for (int i = 0; i < Integer.parseInt(NM[0]); i++) {
      s.put(br.readLine(), 0);
    }

    for (int i = 0; i < Integer.parseInt(NM[1]); i++) {
      String string = br.readLine();
      if (s.containsKey(string)) {
        s.put(string, s.get(string) + 1);
      }
    }

    Collection<Integer> values = s.values();

    int answer = 0;

    for (Integer value : values) {
      answer += value;
    }

    System.out.println(answer);
  }

}
