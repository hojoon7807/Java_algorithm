import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeSet;

public class Main {
  /*
  정렬과 삭제를 빠르게 하기 위한 TreeSet를 사용해 last, first 를 받는다.
  삭제할 객체를 빠르게 찾기 위해 Index 번호를 key로 map에 객체를 저장한다.
   */

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, m;
  static TreeSet<Problem> treeSet = new TreeSet<>();
  static HashMap<Integer, Problem> map = new HashMap<>();

  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      int index = Integer.parseInt(input[0]);
      int level = Integer.parseInt(input[1]);

      Problem problem = new Problem(index, level);
      treeSet.add(problem);
      map.put(index, problem);
    }

    m = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < m; i++) {
      String[] input = br.readLine().split(" ");

      String command = input[0];

      if (command.equals("add")){
        int index = Integer.parseInt(input[1]);
        int level = Integer.parseInt(input[2]);

        Problem problem = new Problem(index, level);
        treeSet.add(problem);
        map.put(index, problem);
      } else if(command.equals("solved")){
        int index = Integer.parseInt(input[1]);

        Problem problem = map.get(index);
        treeSet.remove(problem);
      } else {
        int d = Integer.parseInt(input[1]);
        if (d == 1) {
          sb.append(treeSet.last().index).append("\n");
        } else {
          sb.append(treeSet.first().index).append("\n");
        }
      }
    }

    System.out.println(sb);
  }

  static class Problem implements Comparable<Problem> {

    int index;
    int level;

    public Problem(int index, int level) {
      this.index = index;
      this.level = level;
    }

    @Override
    public int compareTo(Problem o) {
      if (this.level == o.level) {
        return this.index - o.index;
      }

      return this.level - o.level;
    }
  }

}
