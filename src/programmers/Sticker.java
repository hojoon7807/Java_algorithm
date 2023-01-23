package programmers;

public class Sticker {


  public int solution(int sticker[]) {

    int length = sticker.length;
    if (length == 1) {
      return sticker[0];
    }
    int[] dp = new int[length];

    dp[0] = sticker[0];
    dp[1] = dp[0];
    int[] dp2 = new int[length];

    for (int i = 2; i < length - 1; i++) {
      dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
    }

    for (int i = 1; i < length ; i++) {
      if (i == 1) {
        dp2[i] = sticker[i];
        continue;
      }
      dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
    }
    return Math.max(dp[length-2], dp2[length-1]);
  }
}
