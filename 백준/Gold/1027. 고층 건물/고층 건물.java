import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static int[] arr;

  static double a;
  static double b;


  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());
    arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    int[] answerArr = new int[n];

    for (int front = 0; front < n - 1; front++) {
      for (int back = front + 1; back < n; back++) {
        cal(front, arr[front], back, arr[back]);

        boolean flag = true;
        for (int mid = front + 1; mid < back; mid++) {
          if (arr[mid] >= a * mid + b) {
            flag = false;
            break;
          }
        }

        if (flag) {
          answerArr[front]++;
          answerArr[back]++;
        }
      }
    }

    int answer = 0;

    for (int i : answerArr) {
      answer = Math.max(answer, i);
    }

    System.out.println(answer);
  }

  static void cal(int x1, int y1, int x2, int y2) {
    a = (double) (y2 - y1) / (double) (x2 - x1);
    // y = ax + b;
    b = y1 - a * x1;
  }
}
