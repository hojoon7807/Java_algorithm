package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

public class 주차요금계산 {
  private static class Record{
    int time;
    String status;

    public Record(int time, String status) {
      this.time = time;
      this.status = status;
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] fees = new int[]{120, 0, 60, 591};
    String[] records = new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};

    int endTime = 23 * 60 + 59;

    int[] answer;
    TreeMap<Integer, Record> map = new TreeMap();
    for (String record : records) {
      String[] info = record.split(" ");
      String time = info[0];
      String status = info[2];
      int num = Integer.parseInt(info[1]);

      String[] timeSplit = time.split(":");
      String hour = timeSplit[0];
      String min = timeSplit[1];

      int calTime = (Integer.parseInt(hour) * 60) + Integer.parseInt(min);

      Record recent = map.get(num);
      if (recent == null) {
        map.put(num, new Record(calTime, status));
      } else {
          recent.time = calTime - recent.time;
          recent.status = status;

      }
    }

    answer = new int[map.size()];

    int index = 0;
    for (Record record : map.values()) {
      int totalTime = record.time;
      if (record.status.equals("IN")) {
        totalTime = endTime - totalTime;
      }
      if (totalTime <= fees[0]) {
        answer[index] = fees[1];
      } else {
        int remainTime = (totalTime - fees[0]) / fees[2];

        if ((totalTime - fees[0]) % fees[2] > 0) {
          remainTime++;
        }
        answer[index] = fees[1] + remainTime * fees[3];
      }
      index++;
    }

    System.out.println(Arrays.toString(answer));
  }
}
