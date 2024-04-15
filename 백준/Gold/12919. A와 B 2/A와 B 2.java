import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static String s,t;
  static boolean flag = false;

  /*
  S -> T 를 만들 수 있는지 알아내자
  S,T 의 최대길이 49, 50 으로 완전탐색
  1. 뒤에 A를 추가
  2. 뒤에 B를 추가하고 문자열 뒤집기

  2^50 가지 경우의 수가 생기므로 S->T는 시간초과
  T -> S 로 변경
   */

  public static void main(String[] args) throws IOException {
    s = br.readLine();
    t = br.readLine();

    search(t);

    System.out.println(flag ? 1 : 0);
  }

  static void search(String tmp){
    if (flag) {
      return;
    }

    if (tmp.length() == s.length()) {
      if (tmp.equals(s)) {
        flag = true;
      }
      return;
    }

    // 마지막이 A라면
    if(tmp.endsWith("A")){
      search(tmp.substring(0, tmp.length() - 1));
    }

    if(tmp.startsWith("B")){
      search(new StringBuilder(tmp).reverse().substring(0, tmp.length() - 1));
    }
  }
}
