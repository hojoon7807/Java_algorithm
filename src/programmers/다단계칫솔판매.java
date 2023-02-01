package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class 다단계칫솔판매 {

  public static void main(String[] args) {
    solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
        new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
        new String[]{"young", "john", "tod", "emily", "mary"}, new int[]{12, 4, 2, 5, 10});
  }

  public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
    HashMap<String, String> enrollMap = new HashMap<>();
    HashMap<String, Integer> amountMap = new LinkedHashMap<>();

    for (int i = 0; i < enroll.length; i++) {
      amountMap.put(enroll[i], 0);
    }

    for (int i = 0; i < referral.length; i++) {
      enrollMap.put(enroll[i], referral[i]);
    }

    for (int i = 0; i < seller.length; i++) {
      int totalPrice = amount[i] * 100;
      int profit = totalPrice / 10;
      if (profit == 0) {
        amountMap.put(seller[i], amountMap.get(seller[i]) + totalPrice);
        continue;
      }
      int income = totalPrice - profit;

      String recommender = enrollMap.get(seller[i]);
      amountMap.put(seller[i], amountMap.get(seller[i]) + income);

      while (!recommender.equals("-")) {
        int recommenderProfit = profit / 10;
        if (recommenderProfit == 0) {
          amountMap.put(recommender, amountMap.get(recommender) + profit);
          break;
        }

        int recommenderIncome = profit - recommenderProfit;
        amountMap.put(recommender, amountMap.get(recommender) + recommenderIncome);

        profit = recommenderProfit;
        recommender = enrollMap.get(recommender);
      }
    }

    int[] answer =
        Arrays.stream(amountMap.values().toArray(new Integer[amountMap.size()]))
            .mapToInt(Integer::intValue)
            .toArray();

    return answer;
  }

}
