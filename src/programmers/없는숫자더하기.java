package programmers;

public class 없는숫자더하기 {

  public static int solution(int[] numbers) {
    int answer = 45;

    for (int num: numbers){
      answer -= num;
    }
    return answer;
  }

}
