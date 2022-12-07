package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B5639 {

  static ArrayList<Integer> list = new ArrayList<>();
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input;

    while (true) {
      input = br.readLine();
      if (input == null || input.equals(""))
        break;
      list.add(Integer.parseInt(input));
    }

    postOrder(0, list.size()-1);

    System.out.println(sb);
  }

  private static void postOrder(int left, int right) {
    if (left > right) {
      return;
    }
    int rightIdx = left + 1;

    while (rightIdx <= right && list.get(rightIdx) < list.get(left)) {
      rightIdx ++;
    }

    postOrder(left+1, rightIdx - 1);
    postOrder(rightIdx, right);
    sb.append(list.get(left) +  "\n");
  }

}
