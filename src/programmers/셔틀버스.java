package programmers;

import java.util.PriorityQueue;

public class 셔틀버스 {

  public static void main(String[] args) {
    System.out.println(solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"}));
    System.out.println(solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"}));
    System.out.println(solution(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00"}));
    System.out.println(
        solution(1, 1, 5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"}));
    System.out.println(solution(1, 1, 1, new String[]{"23:59"}));
    System.out.println(solution(10, 60, 45,
        new String[]{"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59",
            "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}));
  }

  public static String solution(int n, int t, int m, String[] timetable) {
    PriorityQueue<Integer> pq = new PriorityQueue();
    int lastTime = t * (n - 1) + 540;
    String answer = "";

    for (int i = 0; i < timetable.length; i++) {
      String[] split = timetable[i].split(":");
      String hours = split[0];
      String minutes = split[1];
      int orderTime = Integer.parseInt(hours) * 60 + Integer.parseInt(minutes);

      if (orderTime > lastTime) {
        continue;
      }
      pq.add(orderTime);
    }

    int arriveTime = 540;

    for (int i = 0; i < n; i++) {
      // 마지막 시간
      if (i == n - 1) {
        for (int j = 0; j < m - 1; j++) {
          if (!pq.isEmpty()) {
            pq.poll();
          }
        }

        if (pq.isEmpty()) {
          answer = String.format("%02d:%02d", arriveTime / 60, arriveTime % 60);
        } else {
          answer = String.format("%02d:%02d", (pq.peek() - 1) / 60, (pq.peek() - 1) % 60);
        }
      }

      // 탑승 인원만큼 큐에서 제거, 대기 시간이 도착시간보다 클 경우 종료
      for (int j = 0; j < m; j++) {
        if (!pq.isEmpty()) {
          if (pq.peek() <= arriveTime) {
            pq.poll();
          } else {
            break;
          }
        }
      }
      arriveTime += t;

    }
    return answer;
  }

}
