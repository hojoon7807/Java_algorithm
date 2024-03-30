
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    String s = br.readLine();

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n * 2 + 1; i++) {
      sb.append(i % 2 == 0 ? "I" : "O");
    }

    String p = sb.toString();
    int pLen = p.length();

    int index = 0;

    int answer = 0;

    int pI = n + 1;
    int pO = n;
    int iCount = 0;
    int oCount = 0;

    for (int i = 0; i < m; i++) {
      char c = s.charAt(i);

      // 앞서 비교한 문자열이 p일때
      if (iCount == pI && oCount == pO) {
        if (i + 1 >= m) {
          break;
        }

        // 다음 char가 I면 초기화
        if (c == 'I') {
          iCount = 1;
          oCount = 0;
          continue;
        }
        //현재와 다음 인덱스가 OI 반복되면 count + 1;
        if (c == 'O' && s.charAt(i + 1) == 'I') {
          answer++;
          i++;
          continue;
        }
      }

      if (c == 'O') {
        // o가 i보다 같거나 많으면 올릴수 없음
        if (oCount >= iCount) {
          oCount = 0;
          iCount = 0;
          continue;
        } else {
          oCount ++;
        }
      }

      if (c == 'I') {
        if (iCount > oCount) {
          iCount = 1;
          oCount = 0;
          continue;
        } else {
          iCount ++;
        }
      }

      if (iCount == pI && oCount == pO) {
        answer ++;
      }
    }

    System.out.println(answer);
  }

}
