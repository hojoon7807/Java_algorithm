package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Set;

public class B2179 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String[] words = new String[n];

    for (int i = 0; i < n; i++) {
      words[i] = br.readLine();
    }

    LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
    for (String word : words) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        sb.append(c);
        map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
      }
    }

    String maxLenKey = "";

    Set<String> keySet = map.keySet();

    for (String key : keySet) {
      Integer value = map.get(key);
      if (value >= 2) {
        if (maxLenKey.length() < key.length()) {
          maxLenKey = key;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (count == 2) {
        break;
      }
      String word = words[i];
      if (word.length() < maxLenKey.length()) {
        continue;
      }
      String substring = word.substring(0, maxLenKey.length());

      if (substring.equals(maxLenKey)) {
        sb.append(word).append("\n");
        count++;
      }
    }
    System.out.println(sb);
  }

}
