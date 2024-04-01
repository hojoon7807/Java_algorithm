import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int r1, c1, r2, c2;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[][] arr;

  public static void main(String[] args) throws IOException {

    String[] input = br.readLine().split(" ");

    // 3200,000,000 2^3 * 10 ^ 6

    r1 = Integer.parseInt(input[0]);
    c1 = Integer.parseInt(input[1]);
    r2 = Integer.parseInt(input[2]);
    c2 = Integer.parseInt(input[3]);

    int maxNumLen = 0;
    for (int i = r1; i <= r2; i++) {
      for (int j = c1; j <= c2; j++) {
        maxNumLen = Math.max(maxNumLen, String.valueOf(getValue(i, j)).length());
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int i = r1; i <= r2; i++) {
      for (int j = c1; j <= c2; j++) {
        String s = String.valueOf(getValue(i, j));

        int diff = maxNumLen - s.length();
        for (int k = 0; k < diff; k++) {
          sb.append(" ");
        }
        sb.append(s).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

  static int getValue(int i, int j) {
    int maxLen = Math.max(Math.abs(i), Math.abs(j));

    int maxNum = (int) Math.pow((2 * maxLen + 1), 2);

    if (i == maxLen) {
      return maxNum - (maxLen - j);
    }

    maxNum -= 2 * maxLen;
    if (j == -maxLen) {
      return maxNum - (maxLen - i);
    }

    maxNum -= 2 * maxLen;
    if (i == -maxLen) {
      return maxNum - (maxLen + j);
    }

    maxNum -= 2 * maxLen;
    return maxNum - (maxLen + i);
  }
}
