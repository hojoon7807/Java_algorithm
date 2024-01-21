package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class FileSort {

  public static void main(String[] args) {
    System.out.println(extract("f - 10.ext")[0]);
    String[] solution = solution(
        new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});

    String[] solution1 = solution(
        new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II",
            "F-14 Tomcat"});
    System.out.println(1);
  }

  public static String[] solution(String[] files) {
    Arrays.sort(files, (Comparator<String>) (o1, o2) -> {
      String[] o1Split = extract(o1);
      String[] o2Split = extract(o2);

      String o1Head = o1Split[0];
      String o2Head = o2Split[0];

      String o1Number = o1Split[1];
      String o2Number = o2Split[1];

      if (o1Head.equals(o2Head)) {
        return Integer.parseInt(o1Number) - Integer.parseInt(o2Number);
      } else {
        return o1Head.compareTo(o2Head);
      }
    });
    return files;
  }

  static String[] extract(String file) {
    String[] split = new String[2];

    StringBuilder head = new StringBuilder();
    StringBuilder number = new StringBuilder();
    int index = 0;
    // head
    for (int i = index; i < file.length(); i++) {
      char c = file.charAt(i);
      if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || c == ' ' || c == '-') {
        head.append(c);
      }
      if (c >= '0' && c <= '9') {
        index = i;
        break;
      }
    }

    for (int i = index; i < file.length(); i++) {
      if (number.length() == 5) {
        break;
      }
      char c = file.charAt(i);
      if (c >= '0' && c <= '9') {
        number.append(c);
      } else {
        break;
      }
    }

    split[0] = head.toString().toUpperCase();
    split[1] = number.toString();

    return split;
  }

}
