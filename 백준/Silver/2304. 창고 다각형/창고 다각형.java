import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  /*
  완전탐색으로 풀이
  왼쪽과 오른쪽 기준을 나누어서
  다음 인덱스보다 작거나 같은 경우 넓이를 합쳐가며 값을 구한다.
  가장 큰 높이는 마지막에 더하기
   */

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static Stick[] arr;
  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());
    arr = new Stick[n];

    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      int location = Integer.parseInt(input[0]);
      int height = Integer.parseInt(input[1]);
      arr[i] = new Stick(location, height);
    }

    Arrays.sort(arr);

    Stick last = arr[0];
    int answer = 0;
    int maxIndex = 0;

    for (int i = 1; i < n; i++) {
      Stick cur = arr[i];

      if(last.height <= cur.height){
        answer += (cur.location - last.location) * last.height;
        last = cur;
        maxIndex = i;
      }
    }

    last = arr[n-1];

    for (int i = n-2; i >= maxIndex ; i--) {
      Stick cur = arr[i];

      if(last.height <= cur.height){
        answer += (last.location - cur.location) * last.height;
        last = cur;
      }
    }

    answer += arr[maxIndex].height;

    System.out.println(answer);
  }

  static class Stick implements Comparable<Stick>{
    int location;
    int height;

    public Stick(int location, int height) {
      this.location = location;
      this.height = height;
    }

    @Override
    public int compareTo(Stick o) {
      return this.location - o.location;
    }
  }
}
