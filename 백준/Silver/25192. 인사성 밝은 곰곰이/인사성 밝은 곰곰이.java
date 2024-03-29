import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

  static int n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    HashSet<String> set = new HashSet<>();

    int answer = 0;

    for (int i = 0; i < n; i++) {
      String input = br.readLine();

      if (input.equals("ENTER")) {
        set.clear();
        continue;
      }

      if (!set.contains(input)) {
        set.add(input);
        answer++;
      }
    }

    System.out.println(answer);
  }
}
