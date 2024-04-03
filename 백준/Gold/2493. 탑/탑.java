import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int n;

  /*
  왼쪽의 자기보다 큰 탑만 볼 수 있다.
  큰 탑의 인덱스를 출력한다.
  뒷 번호의 건물이 앞 건물보다 크면 앞에 있는 건물들은 비교할 필요없다.
   */
  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());

    Stack<Top> stack = new Stack<>();

    int[] heights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= n; i++) {
      while (!stack.isEmpty()) {
        if (stack.peek().height > heights[i - 1]) {
          sb.append(stack.peek().num).append(" ");
          break;
        } else {
          stack.pop();
        }
      }

      if (stack.isEmpty()) {
        sb.append("0").append(" ");
      }

      stack.push(new Top(i, heights[i-1]));
    }

    System.out.println(sb);
  }

  static class Top {
    int num;
    int height;

    public Top(int num, int height) {
      this.num = num;
      this.height = height;
    }
  }
}
