package programmers;

public class 입국심사 {
  public long solution(int n, int[] times) {
    long start = 1;
    // 1,000,000,000 * 1,000,000,000
    long end = 1000000000000000000L;

    // t 시간 동안 몇몇을 처리할 수 있는지 체크
    // t 시간에 n 이상을 처리할 수 있으면 감소
    // 최솟값을 구해야함

    while(start < end){
      long mid = (start + end)/2;

      if(isValid(n, mid, times)){
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return start;
  }

  public boolean isValid(int n, long t, int[] times){
    long count = 0;

    for(int time : times){
      count += t/time;
    }

    if(count >= n) return true;
    return false;
  }
}
