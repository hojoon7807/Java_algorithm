import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int t, k;
  static TreeMap<Long, Integer> map = new TreeMap<>();
  static StringBuilder sb = new StringBuilder();

  /*
  개념 및 풀이
  =======================
  최소힙, 최대 힙 사용하게 되면 각 위치를 찾아서 삭제하는 경우 때문에 시간 초과 예상
  deque 정렬 작업 추가 될 경우 nlogn 추가로 시간초과
  TreeMap 사용하면 레드블랙트리로 first last 받을 수 있음
  2^31 은 Integer 범위 초과
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
      long value = Long.parseLong(input[1]);

      switch (command) {
        case "I":
          map.put(value, map.getOrDefault(value, 0) + 1);
          break;
        case "D":
          // 최댓값 제거
          if (value == 1L) {
            deleteMax();
          } else {
            deleteMin();
          }
      }
    }
    print();
  }

  static void print(){
    if (map.isEmpty()) {
      sb.append("EMPTY");
    } else {
      sb.append(map.lastKey()).append(" ").append(map.firstKey());
    }
  }

  static void deleteMax() {
    if (map.isEmpty()) {
      return;
    }
    Long maxKey = map.lastKey();
    map.put(maxKey, map.get(maxKey) - 1);
    if (map.get(maxKey) == 0) {
      map.remove(maxKey);
    }
  }

  static void deleteMin() {
    if (map.isEmpty()) {
      return;
    }
    Long minKey = map.firstKey();
    map.put(minKey, map.get(minKey) - 1);
    if (map.get(minKey) == 0) {
      map.remove(minKey);
    }
  }

}
