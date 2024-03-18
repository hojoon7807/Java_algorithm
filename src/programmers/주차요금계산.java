package programmers;

import java.util.Map.Entry;
import java.util.TreeMap;

public class 주차요금계산 {
  static TreeMap<String, Car> map = new TreeMap<>();
  static int defaultTime;
  static int defaultCost;
  static int unitTime;
  static int unitCost;

  public static int[] solution(int[] fees, String[] records) {
    defaultTime = fees[0];
    defaultCost = fees[1];
    unitTime = fees[2];
    unitCost = fees[3];

    // 출차 내역이 없으면 23:59

    // 기본시간 이하라면 기본요금
    // 초과라면 기본요금 + 단위 시간(올림)

    for (String record : records) {
      String[] split = record.split(" ");

      String time = split[0];
      String num = split[1];
      String status = split[2];

      if (status.equals("IN")) {
        // 이미 출차 기록이 있다면
        if (map.containsKey(num)) {
          Car car = map.get(num);
          car.in(toTime(time));
        } else {
          // 처음 입차
          map.put(num, new Car(num, toTime(time), false));
        }
      } else {
        // 나간다면 누적시간 계산
        Car car = map.get(num);
        car.accumulateTime(toTime(time));
        car.out();
      }
    }

    int[] answer = new int[map.size()];
    int index = 0;
    for (Entry<String, Car> entry : map.entrySet()) {
      Car car = entry.getValue();
      car.calculateCost();

      answer[index] = car.cost;
      index++;
    }

    return answer;
  }

  static int toTime(String time) {
    String[] split = time.split(":");
    int hours = Integer.parseInt(split[0]);
    int minutes = Integer.parseInt(split[1]);

    return hours * 60 + minutes;
  }

  static class Car {

    String num;
    int inTime;
    int accTime;
    int cost;
    boolean isOut;

    public Car(String num, int inTime, boolean isOut) {
      this.num = num;
      this.inTime = inTime;
      this.isOut = isOut;
    }

    void out() {
      isOut = true;
    }

    void in(int time) {
      inTime = time;
      isOut = false;
    }

    void accumulateTime(int outTime) {
      accTime += (outTime - inTime);
    }


    void calculateCost() {
      if (!isOut) {
        int maxTime = 23 * 60 + 59;
        accTime += (maxTime - inTime);
      }

      // 기본 요금
      if (accTime <= defaultTime) {
        cost += defaultCost;
      } else {
        // 추가요금
        cost += defaultCost;

        accTime -= defaultTime;

        int overCount = accTime / unitTime;

        if (accTime % unitTime != 0) {
          overCount++;
        }

        cost += overCount * unitCost;
      }
    }
  }
}
