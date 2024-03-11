package programmers;

import java.util.HashMap;

public class 롤케이크자르기 {
  static HashMap<Integer, Integer> aMap = new HashMap<>();
  static HashMap<Integer, Integer> bMap = new HashMap<>();
  public int solution(int[] topping) {
    int answer = 0;

    // 한쪽으로 모두
    for(int i=0; i<topping.length; i++){
      aMap.put(topping[i], aMap.getOrDefault(topping[i], 0) + 1);
    }

    for(int i=0; i<topping.length; i++){
      int toppingCount = aMap.get(topping[i]);

      if(toppingCount == 1){
        aMap.remove(topping[i]);
      } else {
        aMap.put(topping[i], toppingCount-1);
      }

      bMap.put(topping[i], bMap.getOrDefault(topping[i], 0) + 1);

      if(aMap.size() == bMap.size()){
        answer++;
      }

    }
    return answer;
  }
}
