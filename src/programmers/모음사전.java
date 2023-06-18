package programmers;

import java.util.ArrayList;
import java.util.List;

public class 모음사전 {

  public static void main(String[] args) {
    new 모음사전().solution("AAAAE");
    new 모음사전().solution("AAAE");
  }
  static char[] dictionary = {'A','E','I','O','U'};
  public int solution(String word) {
    ArrayList<String> words = new ArrayList();
    dfs("", words);
    int answer = words.indexOf(word) + 1;
    return answer;
  }

  void dfs(String word, List<String> words){
    if(word.length() == 5) {
      return;
    }

    for(int i=0; i<5; i++){
      String tmp = word + dictionary[i];
      words.add(tmp);
      dfs(tmp, words);
    }
  }

}
