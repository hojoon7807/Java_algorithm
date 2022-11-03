package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B5430 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      String p = br.readLine();
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

      boolean flag = true;
      LinkedList<String> strings = new LinkedList<>();

      for (int i = 0; i < n; i++) {
        strings.add(st.nextToken());
      }

      boolean reverse = false;
      for (int i = 0; i < p.length(); i++) {
        if (p.charAt(i) == 'R') {
          reverse = !reverse;
        } else {
          if (!reverse) {
            if (strings.pollFirst() == null) {
              flag = false;
            }
          } else {
            if (strings.pollLast() == null) {
              flag = false;
            }
          }
        }
      }
      if (flag) {
        if (!reverse) {
          System.out.println(strings.toString().replaceAll(" ", ""));
        } else {
          Collections.reverse(strings);
          System.out.println(strings.toString().replaceAll(" ", ""));
        }
      } else {
        System.out.println("error");
      }
    }
  }

}
