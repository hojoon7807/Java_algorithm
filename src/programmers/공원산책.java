package programmers;

public class 공원산책 {

  public static void main(String[] args) {

  }

  public int[] solution(String[] park, String[] routes) {
    int[] answer = {0,0};
    int h = park.length;
    int w = park[0].length();
    for(int i=0; i< park.length; i++){
      for(int j=0; j<park[0].length(); j++){
        if(park[i].charAt(j) == 'S'){
          answer = new int[]{i,j};
        }
      }
    }

    for(String route:routes){
      char direct = route.charAt(0);
      int move = route.charAt(2) - '0';

      int[] next = switch(direct) {
        case 'N' -> new int[]{answer[0] - move, answer[1]};
        case 'S' -> new int[]{answer[0] + move, answer[1]};
        case 'W' -> new int[]{answer[0], answer[1] - move};
        case 'E' -> new int[]{answer[0], answer[1] + move};
        default -> new int[]{};
      };

      if(next[0] >= 0 && next[0] < h && next[1] >=0 && next[1] < w) {
        boolean flag = false;
        for(int i=answer[0]; i<=next[0]; i++){
          if(park[i].charAt(answer[1]) == 'X') {
            flag = true;
            break;
          }
        }

        for(int j=answer[1]; j<=next[1]; j++){
          if(park[answer[0]].charAt(j) == 'X') {
            flag = true;
            break;
          }
        }

        if(!flag) {
          answer = next;
        }
      }

    }
    return answer;
  }
}
