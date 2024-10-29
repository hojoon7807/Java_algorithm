import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static Room[] infos;
  static boolean[] isVisited;
  static StringBuilder sb = new StringBuilder();
  static boolean result = false;

  public static void main(String[] args) throws IOException {
    String input;

    while (!(input = br.readLine()).equals("0")) {
      n = Integer.parseInt(input);
      infos = new Room[n + 1];
      isVisited = new boolean[n + 1];
      result = false;

      for (int i = 1; i <= n; i++) {
        String[] split = br.readLine().split(" ");

        Room room = new Room();
        room.type = split[0];
        room.cost = Integer.parseInt(split[1]);

        for (int j = 2; j < split.length - 1; j++) {
          room.path.add(Integer.parseInt(split[j]));
        }

        infos[i] = room;
      }

      dfs(1, 0);

      if (result) {
        sb.append("Yes").append("\n");
      } else {
        sb.append("No").append("\n");
      }
    }

    System.out.println(sb);
  }

  static void dfs(int recent, int money){
    if(result){
      return;
    }

    if (recent == n) {
      result = true;
      return;
    }

    for (Integer next : infos[recent].path) {
      if(isVisited[next]){
        continue;
      }

      Room room = infos[next];

      String type = room.type;

      boolean flag = true;

      if(type.equals("L")){
          if(money < room.cost){
            money = room.cost;
          }
      } else if(type.equals("T")){
        if (money < room.cost) {
          flag = false;
        } else {
          money -= room.cost;
        }
      }

      if (flag) {
        isVisited[next] = true;
        dfs(next, money);
        isVisited[next] = false;
      }
    }
  }


  static class Room {

    String type;
    int cost;
    ArrayList<Integer> path = new ArrayList<>();
  }
}
