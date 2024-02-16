package programmers;

public class 산모양타일링 {

  public int solution(int n, int[] tops) {
    int[] dp1 = new int[n];
    int[] dp2 = new int[n];

    if (tops[0] == 1) {
      dp1[0] = 3;
      dp2[0] = 1;
    } else {
      dp1[0] = 2;
      dp2[0] = 1;
    }

    for (int i = 1; i < tops.length; i++) {
      dp1[i] = (dp1[i - 1] * (tops[i] + 2) + dp2[i - 1] * (tops[i] + 1)) % 10007;
      dp2[i] = (dp1[i - 1] + dp2[i - 1]) % 10007;
    }
    return (dp1[tops.length - 1] + dp2[tops.length - 1]) % 10007;

  }

}
