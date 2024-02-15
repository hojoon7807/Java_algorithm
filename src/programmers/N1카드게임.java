package programmers;

public class N1카드게임 {

  // [3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4]
  // coin = 4
  // my hand = 3, 6, 7, 2
  // round = (1,10) (5,9) (8,12) (11,4)
  // (6,7) (3,10)
  static boolean[] hand;
  static boolean[] keep;
  static int goal;

  public int solution(int coin, int[] cards) {

    init(cards);

    int curIdx = cards.length / 3;
    int round = 0;
    boolean flag = false;
    while (curIdx < cards.length) {
      round++;

      for (int i = 0; i < 2; i++) {
        keep[cards[curIdx]] = true;
        curIdx++;
      }

      if (canNoCoin()) {
      } else if (canOneCoin(coin)) {
        coin--;
      } else if (canTwoCoin(coin)) {
        coin -= 2;
      } else {
        flag = true;
        break;
      }

    }

    if (!flag) {
      round++;
    }

    return round;
  }

  boolean canOneCoin(int coin) {
    if (coin < 1) {
      return false;
    }
    for (int i = 1; i < hand.length; i++) {
      if (!hand[i]) {
        continue;
      }

      for (int j = 1; j < keep.length; j++) {
        if (!keep[j]) {
          continue;
        }

        if (i + j == goal) {
          hand[i] = false;
          keep[j] = false;
          return true;
        }
      }
    }

    return false;
  }

  boolean canTwoCoin(int coin) {
    if (coin < 2) {
      return false;
    }

    for (int i = 1; i < keep.length - 1; i++) {
      if (!keep[i]) {
        continue;
      }

      for (int j = i + 1; j < keep.length; j++) {
        if (!keep[j]) {
          continue;
        }

        if (i + j == goal) {
          keep[i] = false;
          keep[j] = false;
          return true;
        }
      }
    }
    return false;
  }


  boolean canNoCoin() {
    for (int i = 1; i < hand.length - 1; i++) {
      if (!hand[i]) {
        continue;
      }

      for (int j = i + 1; j < hand.length; j++) {
        if (!hand[j]) {
          continue;
        }

        if (i + j == goal) {
          hand[i] = false;
          hand[j] = false;
          return true;
        }
      }
    }

    return false;
  }


  void init(int[] cards) {
    hand = new boolean[cards.length + 1];
    keep = new boolean[cards.length + 1];
    for (int i = 0; i < cards.length / 3; i++) {
      hand[cards[i]] = true;
    }

    goal = cards.length + 1;
  }
}
