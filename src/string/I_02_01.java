package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class I_02_01 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] strings = br.readLine().split(" ");

    ArrayList<String> answer = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      if (i == 0) {
        answer.add(strings[i]);
        continue;
      }

      if (Integer.parseInt(strings[i - 1]) < Integer.parseInt(strings[i])) {
        answer.add(strings[i]);
      }
    }

    for (String s : answer) {
      System.out.print(s+" ");
    }
  }
}
