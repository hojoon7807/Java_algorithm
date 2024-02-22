package programmers;

public class K진수소수 {

  public static void main(String[] args) {
    System.out.println(solution(437674, 3));
  }

  public static int solution(int n, int k) {
    int answer = 0;
    String kString = Integer.toString(n, k);

    int start = 0;
    int end = 1;

    long number = -1;
    while (start < kString.length()) {

      if (end == kString.length() || kString.charAt(end) == '0') {
        number = Long.parseLong(kString.substring(start, end));
        start = end + 1;
        end = end + 2;

        if (isPrime(number)) {
          answer++;
        }
      } else {
        end++;
      }

//             if(end == kString.length()){
//                 number = Long.parseLong(kString.substring(start, end));
//                 start = end + 1;
//                 end = end + 2;
//             }
    }
    return answer;
  }

  static boolean isPrime(long number) {
    if (number == 1 || number == 0) {
      return false;
    }

    for (int i = 2; i <= Math.sqrt(number); i++) {
      if (number % i == 0) {
        return false;
      }
    }

    return true;
  }

}
