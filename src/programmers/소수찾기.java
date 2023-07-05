package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {

  public static void main(String[] args) {
    solution("17");
    solution("011");
  }

  public static int solution(String numbers) {
    int[] nums = Arrays.stream(numbers.split("")).mapToInt(Integer::parseInt).toArray();
    HashSet<Integer> set = new HashSet<>();
    permutation(0, nums, 0, set, new boolean[nums.length]);

    return set.size();
  }


  private static void permutation(int count, int[] arr, int num, Set<Integer> set, boolean[] isVisited) {
    if (count == arr.length) {
      if (isPrime(num)) {
        set.add(num);
      }

      return;
    }

    for (int i = 0; i < arr.length; i++) {
      if(!isVisited[i]) {
        int nextNum = num * 10 + arr[i];
        isVisited[i] = true;
        permutation(count + 1, arr, nextNum, set, isVisited);
        permutation(count + 1, arr, num, set, isVisited);
        isVisited[i] = false;
      }
    }
  }

  private static boolean isPrime(int num) {
    if (num <= 1) {
      return false;
    }

    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) {
        return false;
      }
    }

    return true;
  }

}
