package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CandidateKey {

  public static void main(String[] args) {
    System.out.println(
        solution(new String[][]{
            {"100", "ryan", "music", "2"},
            {"200", "apeach", "math", "2"},
            {"300", "tube", "computer", "3"},
            {"400", "con", "computer", "4"},
            {"500", "muzi", "music", "3"},
            {"600", "apeach", "music", "2"}}));
  }

  static int rowLen;
  static int colLen;
  static HashSet<String> combineSet = new HashSet();
  static List<Set<Integer>> keySet = new ArrayList();
  static int answer = 0;

  public static int solution(String[][] relation) {
    // 컬럼의 최대 조합 개수 2^8 - 1
    rowLen = relation.length;
    colLen = relation[0].length;

    for (int i = 1; i <= colLen; i++) {
      combine(0, i, 0, new HashSet<Integer>(), relation);
    }

    System.out.println(answer);

    return answer;
  }

  static void combine(int depth, int select, int index, HashSet<Integer> key, String[][] relation) {
    if (depth == select) {
      if (checkKey(key, relation)) {
        answer++;
        keySet.add(key);
      }

      combineSet.clear();
      return;
    }

    for (int i = index; i < colLen; i++) {
      HashSet<Integer> newKey = new HashSet<>(key);
      newKey.add(i);
      combine(depth + 1, select, i + 1, newKey, relation);
    }
  }

  static boolean checkKey(HashSet<Integer> key, String[][] relation) {
    if (!isMinimal(key)) {
      return false;
    }
    for (int i = 0; i < rowLen; i++) {
      String combine = "";
      for (Integer k : key) {
        combine += relation[i][k];
      }
      if (!combineSet.contains(combine)) {
        combineSet.add(combine);
      } else {
        return false;
      }
    }
    return true;
  }

  static boolean isMinimal(HashSet<Integer> key) {
    for (Set<Integer> minimal : keySet) {
      if (key.containsAll(minimal)) {
        return false;
      }
    }
    return true;
  }


}
