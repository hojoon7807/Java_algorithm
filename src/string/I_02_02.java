package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class I_02_02 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int max = 0;
    int count = 0;
    String[] heights = br.readLine().split(" ");

    for (String height : heights) {
      if (max == 0) {
        count += 1;
        max = Integer.parseInt(height);
      } else if (Integer.parseInt(height) > max) {
        count += 1;
        max = Integer.parseInt(height);
      }
    }
    System.out.println(count);
  }
}
