package programmers;

public class 숫자카드나누기 {

  public int solution(int[] arrayA, int[] arrayB) {
    int aGcd = arrayA[0];
    for (int i = 1; i < arrayA.length; i++) {
      aGcd = getGcd(aGcd, arrayA[i]);
    }

    int bGcd = arrayB[0];
    for (int i = 1; i < arrayB.length; i++) {

      bGcd = getGcd(bGcd, arrayB[i]);

    }

    for (int i = 0; i < arrayA.length; i++) {
      if (arrayA[i] % bGcd == 0) {
        bGcd = 0;
        break;
      }
    }

    for (int i = 0; i < arrayB.length; i++) {
      if (arrayB[i] % aGcd == 0) {
        aGcd = 0;
        break;
      }
    }

    return Math.max(aGcd, bGcd);
  }

  public int getGcd(int num1, int num2) {
    if (num1 % num2 == 0) {
      return num2;
    }
    return getGcd(num2, num1 % num2);
  }
}
