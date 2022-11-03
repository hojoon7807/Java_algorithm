package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17609 {

  static String st;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      st = br.readLine();
      System.out.println(check(0, 0, st.length()-1));
    }



  }

  static int check(int count, int left, int right){
    if (count == 2) {
      return count;
    }

    while (left < right) {
      if (st.charAt(left) != st.charAt(right)) {
        int leftCheck = check(count + 1, left + 1, right);
        int rightCheck = check(count + 1, left, right - 1);
        count = Math.min(leftCheck, rightCheck);
        break;
      }
      left++;
      right--;
    }
    return count;
  }

}
