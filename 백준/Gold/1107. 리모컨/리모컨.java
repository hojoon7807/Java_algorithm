import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, m;
  static int min = Integer.MAX_VALUE;
  static boolean[] broken = new boolean[10];

  /*
  채널 이동 방법
  1. 버튼을 눌러서 바로가냐
  2. 버튼을 눌러서 임의의 채널로 이동 후 + or -
  3. 그냥 + , -

  초기 min = n - 현재 100
  0 <= n <= 500,000 이므로 999,999 까지 탐색
  반복문 돌면서 해당 채널로 이동할 수 있는지 체크
  이동가능하면 min 갱신
  이동 불가능하면 continue;
   */

  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    String[] input = null;
    
    if (m != 0) {
      input = br.readLine().split(" ");
    }

    for (int i = 0; i < m; i++) {
      broken[Integer.parseInt(input[i])] = true;
    }

    min = Math.abs(n - 100);

    for (int i = 0; i <= 999999; i++) {
      if (isBroken(i)) {
        continue;
      }

      int len = Integer.toString(i).length();
      min = Math.min(min, len + Math.abs(n - i));
    }

    System.out.println(min);
  }

  static boolean isBroken(int channel) {
    while (true) {
      if (broken[channel % 10]) {
        return true;
      }

      channel /= 10;

      if (channel == 0) {
        break;
      }
    }

    return false;
  }

}
