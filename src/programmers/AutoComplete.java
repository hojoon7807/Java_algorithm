package programmers;

public class AutoComplete {

  public static void main(String[] args) {
    solution(new String[]{"go", "gone", "guild"});
    solution(new String[]{"abc", "def", "ghi", "jklm"});
    solution(new String[]{"word", "war", "warrior", "world"});
  }

  public static int solution(String[] words) {
    int answer = 0;
    Trie root = new Trie();

    for (String word : words) {
      insert(root, word);
    }

    for (String word : words) {
      answer += search(root, word);
    }

    return answer;
  }

  private static int search(Trie node, String word) {
    int len = 0;
    for (char c : word.toCharArray()) {
      len++;
      if (node.child[c - 'a'].count == 1) {
        return len;
      } else {
        node = node.child[c - 'a'];
      }
    }

    return len;
  }

  private static void insert(Trie node, String word) {
    for (char c : word.toCharArray()) {
      if (node.child[c - 'a'] == null) {
        node.child[c - 'a'] = new Trie();
      }

      node = node.child[c - 'a'];
      node.count++;
    }
  }

  private static class Trie {

    Trie[] child;
    int count;

    public Trie() {
      this.child = new Trie[26];
    }
  }

}
