package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Fail {
  public static void main(String[] args) {
    solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
  }

  static HashMap<Integer, int[]> map = new HashMap<>();
  static ArrayList<StageInfo> stageInfos = new ArrayList<>();

  public static int[] solution(int N, int[] stages) {
    int[] answer = new int[N];

    for(int now:stages){
      if(now == N+1){
        for(int i=1; i<=now; i++){
          if(!map.containsKey(i)){
            map.put(i, new int[]{0,0});
          }
          map.get(i)[1] += 1;
        }
      } else {
        for(int i=1; i<=now; i++){
          if(!map.containsKey(i)){
            map.put(i, new int[]{0,0});
          }
          map.get(i)[1] += 1;
        }
        map.get(now)[0] += 1;
      }
    }

    for(int i=1; i<=N; i++){
      if(!map.containsKey(i)){
        stageInfos.add(new StageInfo(i, 0));
      } else {
        int[] clear = map.get(i);
        double whole = clear[1];
        double clearCount = clear[0];
        stageInfos.add(new StageInfo(i, clearCount/whole));
      }
    }

    Collections.sort(stageInfos, (o1,o2) -> {
      if(o1.failRate == o2.failRate){
        return o1.stageNum - o2.stageNum;
      }
      return Double.compare(o2.failRate, o1.failRate);
    });

    for(int i=0; i<N; i++){
      answer[i] = stageInfos.get(i).stageNum;
    }

    return answer;
  }

  static class StageInfo {
    int stageNum;
    double failRate;

    public StageInfo(int stageNum, double failRate){
      this.stageNum = stageNum;
      this.failRate = failRate;
    }
  }
}
