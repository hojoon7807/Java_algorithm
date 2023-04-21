package programmers;

import java.util.Arrays;

public class DartGame {

  public static void main(String[] args) {
    solution("1D2S#10S");
  }

  public static int solution(String dartResult) {
    int[] dart = new int[3];
    int index = 0;
    int score = -1;
    String tmp = "";
    for (int i = 0; i < dartResult.length(); i++) {
      char c = dartResult.charAt(i);
      if (Character.isDigit(c)) {
        tmp += String.valueOf(c);
      } else if(Character.isAlphabetic(c)){
        score = Integer.parseInt(tmp);
        switch (c) {
          case 'S':
            dart[index++] = (int) Math.pow(score, 1);
            break;
          case 'D':
            dart[index++] = (int) Math.pow(score, 2);
            break;
          case 'T':
            dart[index++] = (int) Math.pow(score, 3);
            break;
          case '*':
            dart[index - 1] *= 2;
            if (index > 1) {
              dart[index - 2] *= 2;
            }
            break;
          case '#':
            dart[index - 1] *= -1;
            break;
          default:
            break;
        }
        tmp = "";
      }
      else {
        switch (c) {
          case '*':
            dart[index - 1] *= 2;
            if (index > 1) {
              dart[index - 2] *= 2;
            }
            break;
          case '#':
            dart[index - 1] *= -1;
            break;
          default:
            break;
        }
      }
    }

    return Arrays.stream(dart).reduce(Integer::sum).getAsInt();
  }

}
