import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {

  /*
  오큰수 = i 보다 오른쪽에 있으면서 가장 가까운 큰수
  뒤부터 탐색
   */
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;

  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());

    int[] nums = Arrays.stream(br.readLine().split(" "))
                       .mapToInt(Integer::parseInt)
                       .toArray();

    int[] answer = new int[n];

    Stack<Integer> stack = new Stack<>();

    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty()) {
        if(!stack.isEmpty() && stack.peek() > nums[i]){
          answer[i] = stack.peek();
          break;
        } else {
          stack.pop();
        }
      }

      if (stack.empty()) {
        answer[i] = -1;
      }

      stack.add(nums[i]);
    }

    StringBuilder sb = new StringBuilder();

    for (int i : answer) {
      sb.append(i).append(" ");
    }

    System.out.println(sb);
  }
}
