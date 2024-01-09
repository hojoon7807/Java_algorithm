package programmers;

import java.util.HashMap;

public class KakaoOne {

  static HashMap<String, Info> map = new HashMap<>();

  public static void main(String[] args) {
    solution(new String[]{"a", "b", "c"}, new String[]{"a b", "b a", "c a", "a c", "a c", "c a"});
  }

  public static int solution(String[] friends, String[] gifts) {
    int answer = 0;

    for (String name : friends) {
      map.put(name, new Info());
    }

    for (String gift : gifts) {
      String[] persons = gift.split(" ");
      String give = persons[0];
      String get = persons[1];

      Info giver = map.get(give);
      giver.addGive(get);
      Info getter = map.get(get);
      getter.addGet();
    }

    for (Info person : map.values()) {
      person.calculateFactor();
    }

    int len = friends.length;

    for (int i = 0; i < len - 1; i++) {
      for (int j = i + 1; j < len; j++) {
        String aName = friends[i];
        Info aInfo = map.get(aName);
        String bName = friends[j];
        Info bInfo = map.get(bName);

        int countToB = aInfo.getHistoryTo(bName);
        int countToA = bInfo.getHistoryTo(aName);

        if (countToB == 0 && countToA == 0 || countToB == countToA) {
          int aFactor = aInfo.factor;
          int bFactor = bInfo.factor;

          if (aFactor == bFactor) {
            continue;
          }

          if (aFactor > bFactor) {
            aInfo.addGift();
          } else {
            bInfo.addGift();
          }

          continue;
        }

        if (countToB > countToA) {
          aInfo.addGift();
        } else {
          bInfo.addGift();
        }
      }
    }

    for (Info person : map.values()) {
      answer = Math.max(answer, person.gift);
    }
    return answer;
  }

  static class Info {

    int give;
    int get;
    int factor;
    int gift;

    HashMap<String, Integer> giftHistory = new HashMap<>();

    public void addGive(String getter) {
      give++;
      giftHistory.put(getter, giftHistory.getOrDefault(getter, 0) + 1);
    }

    public void addGet() {
      get++;
    }

    public void addGift() {
      gift++;
    }

    public void calculateFactor() {
      factor = give - get;
    }


    public int getHistoryTo(String name) {
      return giftHistory.getOrDefault(name, 0);
    }
  }
}
