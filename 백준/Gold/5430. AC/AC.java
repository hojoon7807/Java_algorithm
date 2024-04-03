import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int t;
  static StringBuilder sb = new StringBuilder();
  static ArrayDeque<String> deque = new ArrayDeque<>();

  public static void main(String[] args) throws IOException {
    t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      solution();
      sb.append("\n");
      deque.clear();
    }

    System.out.println(sb);
  }

  static void solution() throws IOException {
    String p = br.readLine();
    int n = Integer.parseInt(br.readLine());
    String[] input = br.readLine().replaceAll("\\[|\\]", "").split(",");

    for (String s : input) {
      if(!s.equals(""))
      deque.add(s);
    }

    boolean isR = false;
    int len = p.length();

    for (int i = 0; i < len; i++) {
      char command = p.charAt(i);
      if (command == 'R') {
        isR = !isR;
      } else {
        if (deque.isEmpty()) {
          sb.append("error");
          return;
        }

        if (isR) {
          deque.pollLast();
        } else {
          deque.pollFirst();
        }
      }
    }
    dequeToString(isR);
  }

  static void dequeToString(boolean isR) {
    sb.append("[");

    int len = deque.size();
    for (int i = 0; i < len; i++) {
      if (i == len - 1) {
        sb.append(deque.poll());
        break;
      }

      if (isR) {
        sb.append(deque.pollLast()).append(",");
      } else {
        sb.append(deque.pollFirst()).append(",");
      }
    }

    sb.append("]");
  }
}
