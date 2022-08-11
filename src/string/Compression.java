package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Compression {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String string = br.readLine();
    String answer = "";
    int count = 1;

    for (int i = 0; i < string.length(); i++) {
      if (i == 0) {
        answer += string.charAt(i);
      }else if(string.charAt(i-1) == string.charAt(i)){
        count ++;
      }else {
        if (count == 1){
          answer += string.charAt(i);
        }else{
          answer += count;
          count = 1;
          answer += string.charAt(i);
        }

      }
    }

    if(count != 1){
      answer += count;
    }

    System.out.println(answer);
  }

}
