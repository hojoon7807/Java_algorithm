
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int t, k;
  static TreeMap<Integer, Integer> map = new TreeMap<>();
  static StringBuilder sb = new StringBuilder();

  /*
  개념 및 풀이
  =======================
  최소힙, 최대 힙 사용하게 되면 각 위치를 찾아서 삭제하는 경우 때문에 시간 초과 예상
  TreeMap 사용하면 레드블랙트리로 first last 받을 수 있음
   */
  public static void main(String[] args) throws IOException {
    t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      run();
      sb.append("\n");
      map.clear();
    }

    System.out.println(sb);
  }

  static void run() throws IOException {
    k = Integer.parseInt(br.readLine());

    for (int i = 0; i < k; i++) {
      String[] input = br.readLine().split(" ");
      String command = input[0];
      int value = Integer.parseInt(input[1]);

      switch (command) {
        case "I":
          map.put(value, map.getOrDefault(value, 0) + 1);
          break;
        case "D":
          if (map.isEmpty()) {
            continue;
          }
          // 최댓값 제거
          if (value == 1) {
            deleteMax();
          } else {
            deleteMin();
          }
      }
    }
    print();
  }

  static void print() {
    if (map.isEmpty()) {
      sb.append("EMPTY");
    } else {
      sb.append(map.lastKey()).append(" ").append(map.firstKey());
    }
  }

  static void deleteMax() {
    Integer maxKey = map.lastKey();

    if (map.get(maxKey) == 1) {
      map.remove(maxKey);
    } else {
      map.put(maxKey, map.get(maxKey) - 1);
    }
  }

  static void deleteMin() {
    Integer minKey = map.firstKey();

    if (map.get(minKey) == 1) {
      map.remove(minKey);
    } else {
      map.put(minKey, map.get(minKey) - 1);
    }
  }

}
