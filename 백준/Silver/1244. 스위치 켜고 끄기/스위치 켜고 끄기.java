
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[] switches;
  static int n, t;

  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());
    switches = new int[n + 1];

    String[] input = br.readLine().split(" ");

    for (int i = 0; i < n; i++) {
      switches[i + 1] = Integer.parseInt(input[i]);
    }

    t = Integer.parseInt(br.readLine());

    // 0 1 0 1 0 0 0 1
    // 0 1 1 1 0 1 0 1
    for (int i = 0; i < t; i++) {
      input = br.readLine().split(" ");
      int type = Integer.parseInt(input[0]);
      int num = Integer.parseInt(input[1]);

      if (type == 1) {
        boy(num);
      } else {
        girl(num);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      sb.append(switches[i]).append(" ");
      if (i % 20 == 0) {
        sb.append("\n");
      }
    }

    System.out.println(sb);
  }

  static void boy(int num) {
    for (int i = 1; i * num <= n; i++) {
      switches[i * num] = switches[i * num] == 1 ? 0 : 1;
    }
  }

  static void girl(int num) {

    int left = num;
    int right = num;

    while(left >= 1 && right <= n){
      left--;
      right++;

      if (left < 1 || right > n) {
        break;
      }

      if(switches[left] != switches[right]){
        break;
      }
    }

    for (int i = left+1; i <= right-1; i++) {
      switches[i] = switches[i] == 1 ? 0 : 1;
    }
  }

}
