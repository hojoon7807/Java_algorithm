package programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class KakaoPressure {

  public static void main(String[] args) {
    solution("TOBEORNOTTOBEORTOBEORNOT");
    System.out.println(1);
  }

  static HashMap<String, Integer> dict = new HashMap<>();
  static int lastIndex = 27;

  public static int[] solution(String msg) {
    ArrayList<Integer> answerList = new ArrayList<>();
    // 1. dict init
    initDict();
    // 2. find the longest word
    for (int i = 0; i < msg.length(); i++) {
      for (int j = i; j < msg.length(); j++) {
        String substring = msg.substring(i, j + 1);

        if (j == msg.length() - 1) {
          if (dict.containsKey(substring)) {
            answerList.add(dict.get(substring));
            i = j;
            break;
          }
        }

        if (!dict.containsKey(substring)) {
          String prevSubString = msg.substring(i, j);

          //3. print index and move i index;
          answerList.add(dict.get(prevSubString));
          i = j - 1;

          //4. put dict w+c
          dict.put(substring, lastIndex);
          lastIndex++;

          break;
        }
      }
    }
    int[] answer = new int[answerList.size()];

    for (int i = 0; i < answer.length; i++) {
      answer[i] = answerList.get(i);
    }

    return answer;
  }

  static void initDict() {
    char word = 'A';

    for (int i = 1; i <= 26; i++) {
      dict.put(String.valueOf(word), i);
      word++;
    }
  }
}
