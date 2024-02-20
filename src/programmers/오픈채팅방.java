package programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class 오픈채팅방 {

  static HashMap<String, String> map = new HashMap();

  public String[] solution(String[] record) {
    String[] answer = new String[record.length];

    for (String r : record) {
      String[] split = r.split(" ");
      String command = split[0];

      switch (command) {
        case "Enter":
          map.put(split[1], split[2]);
          break;
        case "Change":
          map.put(split[1], split[2]);
        default:
          break;
      }
    }

    ArrayList<String> list = new ArrayList();

    for (String r : record) {
      String[] split = r.split(" ");
      String command = split[0];

      switch (command) {
        case "Enter":
          list.add(map.get(split[1]) + "님이 들어왔습니다.");
          break;
        case "Leave":
          list.add(map.get(split[1]) + "님이 나갔습니다.");
          break;
        default:
          break;
      }
    }

    return list.toArray(new String[1]);
  }

}
