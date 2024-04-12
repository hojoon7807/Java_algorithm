import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n,k;
  static int[] arr;

  /*
  입력 받은 키순대로 정렬
  왼쪽은 오른쪽 보다 <= 이다
  조를 자르는 기준
  각 자리에서 키 차이가 큰애들을 하나씩 없앤다
  1 3 5 6 / 10
  2 2 1 4

   */
  public static void main(String[] args) throws IOException {
    String[] nk = br.readLine().split(" ");

    n = Integer.parseInt(nk[0]);
    k = Integer.parseInt(nk[1]);

    arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

    int[] diff = new int[n - 1];

    for (int i = 0; i < n - 1; i++) {
      diff[i] = arr[i + 1] - arr[i];
    }

    Arrays.sort(diff);

    int answer = 0;
    for (int i = 0; i < n - k; i++) {
      answer += diff[i];
    }

    System.out.println(answer);
  }

}
