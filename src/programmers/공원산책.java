package programmers;

public class 공원산책 {

  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};

  public int[] solution(String[] park, String[] routes) {
    int[] answer = {0, 0};
    int h = park.length;
    int w = park[0].length();
    for (int i = 0; i < park.length; i++) {
      for (int j = 0; j < park[0].length(); j++) {
        if (park[i].charAt(j) == 'S') {
          answer = new int[]{i, j};
        }
      }
    }

    for (String route : routes) {
      char direct = route.charAt(0);
      int move = route.charAt(2) - '0';

      int next = switch (direct) {
        case 'N' -> 0;
        case 'S' -> 1;
        case 'W' -> 2;
        case 'E' -> 3;
        default -> 4;
      };

      boolean flag = false;
      for (int i = 1; i <= move; i++) {
        int nr = answer[0] + dr[next] * i;
        int nc = answer[1] + dc[next] * i;
        if (nr < 0 || nr >= h || nc < 0 || nc >= w || park[nr].charAt(nc) == 'X') {
          flag = true;
          break;
        }
      }

      if (!flag) {
        answer = new int[]{answer[0] + dr[next] * move, answer[1] + dc[next] * move};
      }
    }

    return answer;
  }
}
