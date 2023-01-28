package programmers;

public class Truck {

  public static void main(String[] args) {
    Truck truck = new Truck();
    long solution = truck.solution(2, 7, new int[]{1,0,2,0,1,0,2}, new int[]{0,2,0,1,0,2,0});
    System.out.println(solution);

  }
  public long solution(int cap, int n, int[] deliveries, int[] pickups) {
    int dIndex = n-1;
    int pIndex = n-1;

    long answer = 0;

    while(true) {
      if (dIndex == 0 && pIndex == 0) {
        break;
      }
      int dTruck = 0;
      int pTruck = 0;

      int maxD = 0;
      int maxP = 0;

      for(int i = dIndex; i >= 0; i--){
        if(dTruck == cap) {
          break;
        }

        if(deliveries[i] == 0) {
          if (dIndex > 0) {
            dIndex --;
          }
          continue;
        }

        dTruck += deliveries[i];

        // 트럭이 가득차면 반복문 종료
        if(dTruck > cap) {
          deliveries[i] = dTruck - cap;
          dTruck = cap;
          maxD = Math.max(maxD, i);
          break;
        } else {
          deliveries[i] = 0;
          maxD = Math.max(maxD, i);
          if (dIndex > 0) {
            dIndex --;
          }
        }
      }

      for(int i = pIndex; i >=0; i --){
        if(pTruck == cap) {
          break;
        }
        if(pickups[i] == 0){
          if (pIndex > 0) {
            pIndex --;
          }
          continue;
        }

        pTruck += pickups[i];
        // 트럭이 가득차면 반복문 종료
        if(pTruck > cap){
          pickups[i] = pTruck - cap;
          pTruck = cap;
          maxP = Math.max(maxP,i);
          break;
        } else {
          pickups[i] = 0;
          maxP = Math.max(maxP,i);
          if (pIndex > 0) {
            pIndex --;
          }
        }
      }

      answer += 2 * (Math.max(maxD, maxP) + 1);
    }
    return answer;
  }
}
