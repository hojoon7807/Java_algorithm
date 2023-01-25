package programmers;

public class EditGround {
  public long solution(int[][] land, int P, int Q) {
    long min = Long.MAX_VALUE;

    long left =  Long.MAX_VALUE;
    long right = Long.MIN_VALUE;

    for (int i = 0; i < land.length; i++) {
      for (int j = 0; j < land[i].length; j++) {
        left = Math.min(left, land[i][j]);
        right = Math.max(right, land[i][j]);
      }
    }

    while (left <= right) {
      long mid = (left + right) / 2;
      long leftCost = calculateCost(land, mid, P, Q);
      long rightCost = calculateCost(land, mid+1, P, Q);
      if (leftCost < rightCost) {
        min = Math.min(min, leftCost);
        right = mid - 1;
      } else {
        min = Math.min(min, rightCost);
        left = mid + 1;
      }
    }

    return min;
  }

  long calculateCost(int[][] land,long mid, int P, int Q) {
    long cost = 0;
    for (int i = 0; i < land.length; i++) {
      for (int j = 0; j < land[i].length; j++){
        int level = land[i][j];
        if (level > mid) {
          cost += (level - mid) * Q;
        } else{
          cost += (mid - level) * P;
        }
      }
    }
    return cost;
  }

}
