package programmers;

public class Cookie {
  static int max = 0;

  public int solution(int[] cookie) {

    for(int i = 0; i < cookie.length -1; i++){
      dfs(cookie[i], cookie[i+1], i, i+1 , cookie);
    }

    return max;
  }

  void dfs(int leftSum, int rightSum, int left, int right, int[] cookie) {
    if(leftSum == rightSum){
      max = Math.max(max, leftSum);
    }

    if(left > 0 && leftSum <= rightSum){
      dfs(leftSum + cookie[left - 1], rightSum, left-1, right, cookie);
    } else if(right < cookie.length-1 && leftSum>= rightSum){
      dfs(leftSum, rightSum + cookie[right+1], left, right+1, cookie);
    }
  }
}
