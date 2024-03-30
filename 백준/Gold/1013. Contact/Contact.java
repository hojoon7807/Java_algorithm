import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {

  static int n;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
  public static void main(String[] args) throws IOException {
    Pattern p = Pattern.compile("(100+1+|01)+");

    StringBuilder sb = new StringBuilder();
    
    n = Integer.parseInt(br.readLine());
    
    for (int i = 0; i < n; i++) {
      boolean result = p.matcher(br.readLine()).matches();
      sb.append(result ? "YES" : "NO").append("\n");
    }

    System.out.println(sb);
  }

}
