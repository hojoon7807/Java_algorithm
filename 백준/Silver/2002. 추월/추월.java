
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

  static int n;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static Map<String, Integer> orderMap = new HashMap<>();

  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      orderMap.put(br.readLine(), i);
    }

    int answer = 0;

    int[] out = new int[n];

    for (int i = 0; i < n; i++) {
      out[i] = orderMap.get(br.readLine());
    }

    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (out[i] > out[j]) {
          answer++;
          break;
        }
      }
    }

    System.out.println(answer);
  }

}
