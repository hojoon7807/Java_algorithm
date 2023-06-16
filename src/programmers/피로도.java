package programmers;

public class 피로도 {

  static int max = -1;
  static boolean[] isVisited;
  static int[] seq;

  public int solution(int k, int[][] dungeons) {
    isVisited = new boolean[dungeons.length];
    seq = new int[dungeons.length];
    dfs(k, dungeons, 0);
    return max;
  }

  public void dfs(int k, int[][] dungeons, int count) {
    for (int i = 0; i < dungeons.length; i++) {
      if (!isVisited[i] && k >= dungeons[i][0]) {
        isVisited[i] = true;
        dfs(k - dungeons[i][1], dungeons, count + 1);
        isVisited[i] = false;
      }
    }
    max = Math.max(max, count);
  }

}
