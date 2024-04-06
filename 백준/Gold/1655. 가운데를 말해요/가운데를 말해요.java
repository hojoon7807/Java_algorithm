import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
  /*
  현재까지 말한 숫자의 중간 값을 출력한다
  홀수라면 중간 값, 짝수라면 두수중 작은 값
  1 -> 1, 5 -> 1,2,5 -> 1,2,5,10 -> -99,1,2,5,10 -> -99,1,2,5,7,10 -> -99,1,2,5,5,7,10
  max, min 두개의 힙을 둬 max 가 min 보다 사이즈가 같거나 1개 더 많도록 쌓는다.
  그럼 중간을 기준으로 양쪽으로 최소 최대를 구할 수 있음
  max 의 값이 무조건 중간의 값
   */

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;

  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      int v = Integer.parseInt(br.readLine());
      max.add(v);

      if (i == 0) {
        sb.append(max.peek()).append("\n");
        continue;
      }

      if (max.size() - min.size() > 1) {
        min.add(max.poll());
      }

      if (max.peek() > min.peek()) {
        min.add(max.poll());
      }

      if (min.size() > max.size()) {
        max.add(min.poll());
      }

      sb.append(max.peek()).append("\n");
    }

    System.out.println(sb);
  }

}
