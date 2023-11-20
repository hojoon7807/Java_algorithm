package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1764 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] nm = br.readLine().split(" ");

    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);

    String[] arrN = new String[n];
    String[] arrM = new String[m];

    for (int i = 0; i < n; i++) {
      arrN[i] = br.readLine();
    }

    for (int i = 0; i < m; i++) {
      arrM[i] = br.readLine();
    }

    Arrays.sort(arrN);
    Arrays.sort(arrM);

    int count = 0;
    StringBuilder sb = new StringBuilder();
    for (String person : arrN) {
      int start = 0;
      int end = m-1;
      while (start <= end) {
        int mid = (start+end) >> 1;

        String target = arrM[mid];
        if(target.equals(person)){
          count ++;
          sb.append(target).append("\n");
          break;
        }

        if (person.compareTo(target) > 0) {
          start = mid + 1;
        } else {
          end = mid -1;
        }
      }
    }

    System.out.println(count);
    System.out.println(sb);
  }
}
