import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  /*
  - 공유기 끼리 가능한 멀리 떨어뜨려놔야된다.
  - 거리 차이 확인을 위해 sort
  - 거리를 기준으로 이분탐색을하며 공유기를 놓을 수 있는지 체크
  - TTTT/FFFF
  - 최대 거리 = 1000000000
   */
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, c;
  static int[] homes;

  public static void main(String[] args) throws IOException {
    String[] nc = br.readLine().split(" ");

    n = Integer.parseInt(nc[0]);
    c = Integer.parseInt(nc[1]);

    homes = new int[n];

    for (int i = 0; i < n; i++) {
      homes[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(homes);

    int left = 1;
    int right = homes[n - 1] + 1;

    while (left + 1 < right) {
      int mid = (left + right) >> 1;

      if(check(mid)){
        left = mid;
      } else {
        right = mid;
      }
    }

    System.out.println(left);
  }

  static boolean check(int len){
    int count = 1;
    int cur = homes[0];

    for (int i = 1; i < n; i++) {
      if(homes[i] - cur >= len){
        count ++;
        cur = homes[i];
      }

      if (count >= c) {
        return true;
      }
    }
    return false;
  }

}
