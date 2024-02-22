package programmers;

public class 두큐합같게만들기 {

  public int solution(int[] queue1, int[] queue2) {
    // [1,2,1,2] [1,10,1,2]
    //  6 | 14
    //  20 -> 10 | 10

    // [1,2,1,2,1,10,1,2] index 5 start = 5 end = 6

    // [1,10,1,2,1,2,1,2] start=1 end=2;

    // [3,2,7,2] [4,6,5,1]
    // [3,2,7,2,4,6,5,1] start=1 end = 5
    // [4,6,5,1,3,2,7,2] start=0 end = 3

    long goal = 0;
    for (int i = 0; i < queue1.length; i++) {
      goal += queue1[i];
      goal += queue2[i];
    }

    // if(goal % 2 == 1){
    //     return -1;
    // }

    goal /= 2;

    int[] allOfQueue1 = new int[queue1.length * 2];
    int[] allOfQueue2 = new int[queue1.length * 2];

    for (int i = 0; i < queue1.length; i++) {
      allOfQueue1[i] = queue1[i];
      allOfQueue2[i] = queue2[i];
    }

    for (int i = queue1.length; i < queue1.length * 2; i++) {
      allOfQueue1[i] = queue2[i - queue1.length];
      allOfQueue2[i] = queue1[i - queue1.length];
    }

    int result1 = taskCount(allOfQueue1, goal);

    if (result1 == -1) {
      return -1;
    }
    int result2 = taskCount(allOfQueue2, goal);

    return Math.min(result1, result2);
  }

  int taskCount(int[] queue, long goal) {
    long sum = 0;
    int start = 0;
    int end = 0;

    while (start <= end && end < queue.length) {
      if (sum < goal) {
        sum += queue[end++];
      } else if (sum > goal) {
        sum -= queue[start++];
      }

      if (sum == goal) {
        if (start == 0 && end == queue.length / 2) {
          return 0;
        } else if (end == queue.length / 2) {
          return start;
        } else if (end > queue.length / 2) {
          return start + (end - queue.length / 2);
        } else {
          return start + end + queue.length / 2;
        }
      }
    }

    return -1;
  }

}
