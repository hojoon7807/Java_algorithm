package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B7682 {
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String input ="";
      while(!(input = br.readLine()).equals("end")) {
//        System.out.println(isValidBoard(input)? "valid" : "invalid");
      }
  }

//  static boolean isValidBoard(String testCase) {
//    int countX = 0, countO = 0, completedX = 0, completedO = 0;
//
//    for (int i = 0; i < testCase.length(); i++) {
//      char tmp = testCase.charAt(i);
//      if (tmp == 'X') {
//        countX++;
//      } else if (tmp == 'O') {
//        countO++;
//      }
//    }
//
//    if (countO > countX)
//      return false;
//
//    for (int i = 0; i < 9; i += 3) {
//      char tmp = testCase.charAt(i);
//      if (tmp == '.')
//        continue;
//      if (tmp == testCase.charAt(i + 1) && tmp == testCase.charAt(i + 2)) {
//        if (tmp == 'X') {
//          completedX++;
//        } else if (tmp == 'O') {
//          completedO++;
//        }
//      }
//    }
//
//    for (int i = 0; i < 3; i++) {
//      char tmp = testCase.charAt(i);
//      if (tmp == '.')
//        continue;
//      if (tmp == testCase.charAt(i + 3) && tmp == testCase.charAt(i + 6)) {
//        if (tmp == 'X') {
//          completedX++;
//        } else if (tmp == 'O') {
//          completedO++;
//        }
//      }
//    }
//
//    for (int i = 0; i < 2; i += 2) {
//      char tmp = testCase.charAt(i);
//      if (tmp == '.')
//        continue;
//      if (tmp == testCase.charAt(i + 3) && tmp == testCase.charAt(i + 6)) {
//        if (tmp == 'X') {
//          completedX++;
//        } else if (tmp == 'O') {
//          completedO++;
//        }
//      }
//    }
//
//  }
}
