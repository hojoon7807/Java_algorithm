package programmers;

import java.util.HashSet;
import java.util.Set;

public class CandidateKey {

  public static void main(String[] args) {
    System.out.println(
        solution(new String[][]{{"a", "1", "aaa", "c", "ng"},
            {"a", "1", "bbb", "e", "g"},
            {"c", "1", "aaa", "d", "ng"},
            {"d", "2", "bbb", "d", "ng"}}));
  }

  static int[] isVisited;
  static int colLen, rowLen;
  static Set<Set<Integer>> answerSet = new HashSet<>();

  public static int solution(String[][] relation) {
    colLen = relation[0].length;
    rowLen = relation.length;
    isVisited = new int[colLen];

    for (int i = 0; i < colLen; i++) {
      combine(0, i + 1, relation, new HashSet<>(), 0);
    }
    return answerSet.size();
  }

  static void combine(int depth, int len, String[][] relation, Set<Integer> key, int start) {
    if (depth == len) {
      if (isCandidate(relation)) {
        for (Set<Integer> savedKey : answerSet) {
          if (key.containsAll(savedKey)) {
            return;
          }
        }
        answerSet.add(key);
      }
      return;
    }

    for (int i = start; i < colLen; i++) {
      isVisited[i] = 1;
      key.add(i);
      combine(depth + 1, len, relation, key, i + 1);
      isVisited[i] = 0;
    }
  }


  static boolean isCandidate(String[][] relation) {
    Set<String> set = new HashSet();

    for (int i = 0; i < rowLen; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < colLen; j++) {
        if (isVisited[j] == 1) {
          sb.append(relation[i][j]);
        }
      }

      if (set.contains(sb.toString())) {
        return false;
      } else {
        set.add(sb.toString());
      }
    }

    return true;
  }

}
