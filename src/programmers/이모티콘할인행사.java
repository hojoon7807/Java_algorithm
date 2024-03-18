package programmers;

import java.util.ArrayList;

class 이모티콘할인행사 {

  static int[] discountRatio = {10, 20, 30, 40};
  static ArrayList<int[]> results = new ArrayList<>();

  public int[] solution(int[][] users, int[] emoticons) {
    combine(0, 0, new int[emoticons.length], users, emoticons);

    results.sort((o1, o2) -> {
      if (o1[0] == o2[0]) {
        return o2[1] - o1[1];
      }

      return o2[0] - o1[0];
    });

    return results.get(0);
  }

  void combine(int depth, int index, int[] discounts, int[][] users, int[] emoticons) {
    if (depth == discounts.length) {
      int[] result = calculate(discounts, users, emoticons);
      results.add(result);
      return;
    }

    for (int j = 0; j < 4; j++) {
      discounts[index] = discountRatio[j];
      combine(depth + 1, index + 1, discounts, users, emoticons);
    }
  }

  int[] calculate(int[] discounts, int[][] users, int[] emoticons) {
    int plusUser = 0;
    int totalSell = 0;

    for (int[] user : users) {
      int ratio = user[0];
      int canUseMoney = user[1];

      boolean isPlus = false;

      for (int i = 0; i < discounts.length; i++) {
        int discount = discounts[i];

        if (discount >= ratio) {
          int discountPrice = emoticons[i] * (100 - discount) / 100;
          if (canUseMoney - discountPrice <= 0) {
            plusUser++;
            isPlus = true;
            break;
          } else {
            canUseMoney -= discountPrice;
          }
        }
      }

      if (!isPlus) {
        totalSell += user[1] - canUseMoney;
      }
    }

    return new int[]{plusUser, totalSell};
  }
}