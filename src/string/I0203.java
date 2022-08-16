package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class I0203 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    String[] A = br.readLine().split(" ");
    String[] B = br.readLine().split(" ");

    for (int i = 0; i < N; i++) {
      int result = Integer.parseInt(A[i]) - Integer.parseInt(B[i]);
      if(result == 1 || result == -2) System.out.println("A");
      else if(result == 0) System.out.println("D");
      else System.out.println("B");
    }
  }

}
