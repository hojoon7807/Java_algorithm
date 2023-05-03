package programmers;

public class 타겟넘버 {
  static int answer = 0;
  static int length;

  public int solution(int[] numbers, int target) {
    length = numbers.length;
    dfs(0, target + numbers[0], numbers);
    dfs(0, target - numbers[0], numbers);
    return answer;
  }

  public static void dfs(int index, int target, int[] numbers) {
    if (index == length - 1) {
      if (target == 0) {
        answer++;
      }
      return;
    }

    dfs(index + 1, target + numbers[index + 1], numbers);
    dfs(index + 1, target - numbers[index + 1], numbers);
  }

}
