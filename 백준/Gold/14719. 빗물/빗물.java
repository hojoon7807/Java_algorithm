import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int h;
  static int w;
  static int[] arr;
  public static void main(String[] args) throws IOException {
    String[] input = br.readLine().split(" ");
    h = Integer.parseInt(input[0]);
    w = Integer.parseInt(input[1]);
    arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    int answer = 0;
    // 올라가는 지점 찾기
    for(int i=0; i<w; i++){
      int cur = arr[i];

      int mid = 0;
      for(int j=i-1; j >=0; j--){
        int prev = arr[j];

        //30102
        //30403
        if(prev != 0){
          int dist = i-j-1;

          if(prev >= cur){
            answer += dist * (cur-mid);
            break;
          } else {
            if(prev > mid){
              answer += dist * (prev-mid);
              mid = Math.max(prev, mid);
            }
          }
        }
      }
    }

    System.out.println(answer);
  }
}
