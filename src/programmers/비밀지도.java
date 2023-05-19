package programmers;

public class 비밀지도 {

  public static void main(String[] args) {

    solution(6, new int[]{46,33,33,22,31,50}, new int[]{27,56,19,14,14,10});
  }

  public static String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];
    for (int i = 0; i < n; i++) {
      String password1 = Integer.toBinaryString(arr1[i]);
      String password2 = Integer.toBinaryString(arr2[i]);

      int pass1Len = password1.length();
      int pass21Len = password2.length();
      for (int j = 0; j < n - pass1Len; j++) {
        password1 = "0" + password1;
      }

      for (int j = 0; j < n - pass21Len; j++) {
        password2 = "0" + password2;
      }

      System.out.println(password1);
      System.out.println(password2);

      char[] result = new char[n];

      for (int j = 0; j < n; j++) {
        if (password1.charAt(j) == '1' || password2.charAt(j) == '1') {
          result[j] = '#';
        } else {
          result[j] = ' ';
        }
      }
      answer[i] = String.valueOf(result);
      System.out.println(answer[i]);
    }
    return answer;
  }
}
