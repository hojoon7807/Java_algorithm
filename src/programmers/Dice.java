package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class Dice {
  static int max = -1;
  static int[] answer;

  public static int[] solution(int[][] dice) {

    // 6 6 6 6 1296
    // 10,000,000,000
    // 5,000,000,000

    // 100,000*log100,000 = 100,000 * 16.x
    // 4C2 =  4*3 / 2*1
    // 10C2 = 10 9 / 2 = 45
    // 10 10 10 10 100000
    // 6
    // 123/456, 124/356, 125/346, 126/345,
    answer = new int[dice.length / 2];

    selectDice(0, 0, new boolean[dice.length], dice);
    return answer;
  }

  static void selectDiceForSum(int depth, int[][] dice, int[] select,
      ArrayList<Integer> sumList, String user) {
    if (depth == dice.length / 2) {
      sum(select, sumList, user, dice);
      return;
    }

    for (int j = 0; j < 6; j++) {
      select[depth] = j;
      selectDiceForSum(depth + 1, dice, select, sumList, user);
    }

  }

  static void sum(int[] select, ArrayList<Integer> sumList, String user,
      int[][] dice) {
    int sum = 0;
    for (int i = 0; i < select.length; i++) {
      sum += dice[user.charAt(i) - '0'][select[i]];
    }

    sumList.add(sum);
  }

  static void selectDice(int depth, int index, boolean[] select, int[][] dice) {
    if (depth == dice.length / 2) {
      String a = "";
      String b = "";
      for (int i = 0; i < select.length; i++) {
        if (select[i]) {
          a += i;
        } else {
          b += i;
        }
      }

      ArrayList<Integer> aList = new ArrayList<>();
      ArrayList<Integer> bList = new ArrayList<>();

      selectDiceForSum(0, dice, new int[dice.length / 2], aList, a);
      selectDiceForSum(0, dice, new int[dice.length / 2], bList, b);

      // 정렬
      Collections.sort(aList);

      // 이분 탐색 시작
      // 이기는 경우가 true lower bound a[i] > b
      int win = 0;
      for (int value : bList) {
        int temp = 0;
        int lo = -1;
        int hi = aList.size();
        while (lo + 1 < hi) {
          int mid = (lo + hi) / 2;
          if (!(aList.get(mid) > value)) {
            lo = mid;
          } else {
            hi = mid;
          }
        }

        win += (aList.size() - hi);
      }

      if (win > max) {
        max = win;
        for (int i = 0; i < a.length(); i++) {
          answer[i] = a.charAt(i) - '0' + 1;
        }
      }

      //System.out.println("asdf: " + a);

      return;
    }

    for (int i = index; i < dice.length; i++) {
      select[i] = true;
      selectDice(depth + 1, i + 1, select, dice);
      select[i] = false;
    }
  }
}
