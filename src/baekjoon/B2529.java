package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B2529 {
  private static boolean[] isVisited = new boolean[10];
  private static String[] inequalitySigns = new String[10];
  private static int k;
  private static ArrayList<String> list = new ArrayList<>();


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    k = Integer.parseInt(br.readLine());
    inequalitySigns = br.readLine().split(" ");

    dfs("", 0);

    Collections.sort(list);

    System.out.println(list.get(list.size()-1));
    System.out.println(list.get(0));

  }

  private static void dfs(String num, int depth) {
    if (depth == k+1){
      list.add(num);
      return;
    }

    for (int i = 0; i < 10; i++) {
      if(isVisited[i] == true) continue;
      if(depth == 0 || check(num.charAt(depth-1) - '0', i, inequalitySigns[depth-1])){
        isVisited[i] = true;
        dfs(num+i, depth+1);
        isVisited[i] = false;
      }

    }
  }

  private static boolean check(int fisrt, int second, String inequalitySign) {
    if(inequalitySign.equals(">")){
      return fisrt > second;
    }else{
      return fisrt < second;
    }
  }
}
