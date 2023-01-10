package programmers;

import java.util.ArrayList;

class 이모티콘할인행사 {

  static int[] discountRates = {10, 20, 30, 40};
  static ArrayList<int[]> combines = new ArrayList<>();
  static ArrayList<int[]> results = new ArrayList<>();

  public static void main(String[] args) {
    int[][] users = {{40, 10000}, {25, 10000}};
    int[] emoticons = {7000, 9000};
    이모티콘할인행사 o = new 이모티콘할인행사();
    o.solution(users, emoticons);
  }

  public int[] solution(int[][] users, int[] emoticons) {
    dfs(0, new int[emoticons.length], emoticons.length);

    for (int[] combine : combines) {
      int registCount = 0;
      int salesAmount = 0;
      for (int i = 0; i < users.length; i++) {
        int purchaseAmount = 0;
        for (int j = 0; j < emoticons.length; j++) {
          int discountRate = combine[j];

          if (discountRate >= users[i][0]) {
            purchaseAmount += emoticons[j] * (100 - discountRate) / 100;
          }
        }
        if (purchaseAmount >= users[i][1]) {
          registCount += 1;
        } else {
          salesAmount += purchaseAmount;
        }
      }

      results.add(new int[]{registCount, salesAmount});
    }

    results.sort(((o1, o2) -> {
      if (o1[0] == o2[0]) {
        return o2[1] - o1[1];
      }
      return o2[0] - o1[0];
    }));

    return results.get(0);
  }

  private static void dfs(int level, int[] arr, int end) {
    if (level == end) {
      combines.add(arr.clone());
      return;
    }

    for (int i = 0; i < 4; i++) {
      arr[level] = discountRates[i];
      dfs(level + 1, arr, end);
    }
  }
}