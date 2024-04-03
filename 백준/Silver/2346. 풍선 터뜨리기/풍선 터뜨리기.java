import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int n;

  /*
  1~n 개의 풍선이 원형으로 놓여있다,
  시작은 1번 풍선 -> 입력이 음수일 경우 왼쪽으로 양수일 경우 오른쪽으로
  3 2 1 -3 -1
  1 4
   */
  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());
    ArrayDeque<Pair> deque = new ArrayDeque<>();

    String[] input = br.readLine().split(" ");

    for (int i = 1; i <= n; i++) {
      deque.add(new Pair(i, Integer.parseInt(input[i - 1])));
    }

    StringBuilder sb = new StringBuilder();

    while (!deque.isEmpty()) {
      Pair cur = deque.pollFirst();
      sb.append(cur.num).append(" ");

      if (deque.isEmpty()) {
        break;
      }

      if (cur.value > 0) {
        for (int i = 1; i < cur.value; i++) {
          deque.addLast(deque.pollFirst());
        }
      } else {
        for (int i = -1; i >= cur.value; i--) {
          deque.addFirst(deque.pollLast());
        }
      }
    }

    System.out.println(sb);
  }

  private static class Pair {

    int num;
    int value;

    public Pair(int num, int value) {
      this.num = num;
      this.value = value;
    }
  }
}
