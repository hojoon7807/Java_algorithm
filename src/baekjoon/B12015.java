package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B12015 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static int[] a;
  static ArrayList<Integer> list = new ArrayList();

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void solution(){
    list.add(a[0]);

    for(int i=1; i<n; i++){
      if(list.get(list.size()-1) < a[i]){
        list.add(a[i]);
        continue;
      }
      //  리스트의 값 중 a[i]보다 작은 가까운 가장 큰 인덱스 찾기
      // 10
      int left = -1;
      int right = list.size();

      while(left+1<right){
        int mid = (left + right)/2;

        // list[]  a[i] =< list[]
        // a[i] <= list[mid]

        // 9 10 8
        // 1 2
        // 1 3   // 2
        if(list.get(mid) >= a[i]){
          right = mid;
        } else {
          left = mid;
        }
      }

      list.set(right, a[i]);
    }

    System.out.println(list.size());
  }


  static void input() throws IOException {
    n = Integer.parseInt(br.readLine());
    a = new int[n];

    String[] split = br.readLine().split(" ");

    for(int i=0; i<n; i++){
      a[i] = Integer.parseInt(split[i]);
    }
  }

}
