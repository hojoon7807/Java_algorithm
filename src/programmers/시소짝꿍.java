package programmers;

public class 시소짝꿍 {

  public long solution(int[] weights) {
    long answer = 0;
    int[] realWeight = new int[1001];
    int[] compareWeight = new int[4001];

    for(int weight: weights){
      int realCount = realWeight[weight];

      int w2 = weight * 2;
      int w3 = weight * 3;
      int w4 = weight * 4;

      // 자신과 같은 무게의 사람이 있는 경우
      if(realCount > 0){
        answer += realCount;

        answer += compareWeight[w2] - realCount;
        answer += compareWeight[w3] - realCount;
        answer += compareWeight[w4] - realCount;
      } else {
        answer += compareWeight[w2];
        answer += compareWeight[w3];
        answer += compareWeight[w4];
      }

      realWeight[weight]++;
      compareWeight[w2]++;
      compareWeight[w3]++;
      compareWeight[w4]++;
    }

    return answer;
  }

}
