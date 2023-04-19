package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14425_Trie {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);

    Trie root = new Trie();
    while (N > 0) {
      String word = br.readLine();
      Trie now = root;
      for (int i = 0; i < word.length(); i++) {
        char tmp = word.charAt(i);

        if (now.next[tmp - 'a'] == null) {
          now.next[tmp - 'a'] = new Trie();
        }
        now = now.next[tmp - 'a'];

        if (i == word.length() - 1) {
          now.isLast = true;
        }
      }
      N--;
    }
    int count = 0;
    while (M > 0) {
      String word = br.readLine();
      Trie now = root;
      for (int i = 0; i < word.length(); i++) {
        char tmp = word.charAt(i);

        if (now.next[tmp - 'a'] == null) {
          break;
        }

        now = now.next[tmp - 'a'];
        if (now.isLast && i == word.length() - 1) {
          count++;
        }
      }
      M--;
    }

    System.out.println(count);
  }

  private static class Trie {

    Trie[] next = new Trie[26];
    boolean isLast = false;
  }
}
