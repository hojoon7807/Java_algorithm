package programmers;

public class 광고삽입 {

  public static void main(String[] args) {
    solution("02:03:55", "00:14:15",
        new String[]{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"});

    solution("99:59:59", "25:00:00",
        new String[]{"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"});

    solution("50:00:00", "50:00:00",
        new String[]{"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"});
  }

  public static String solution(String play_time, String adv_time, String[] logs) {

    int playTimeSeconds = toSeconds(play_time);

    long[] timeline = new long[playTimeSeconds+1];

    for (String log : logs) {
      String[] split = log.split("-");
      int startSeconds = toSeconds(split[0]);
      int endSeconds = toSeconds(split[1]);

      timeline[startSeconds] ++;
      timeline[endSeconds] --;
    }

    for (int i = 0; i < playTimeSeconds-1; i++) {
      timeline[i + 1] += timeline[i];
    }

    for (int i = 0; i < playTimeSeconds-1; i++) {
      timeline[i + 1] += timeline[i];
    }

    int advSeconds = toSeconds(adv_time);

    long maxSeconds = 0;
    long minStart = 0;
    for (int i = 0; i < playTimeSeconds- advSeconds; i++) {
      long diffAdv = timeline[i + advSeconds] - timeline[i];
      if (diffAdv > maxSeconds) {
        maxSeconds = diffAdv;
        minStart = i+1;
      }
    }

    System.out.println(String.format("%02d:%02d:%02d", minStart/3600 , minStart/60%60, minStart%60));
    return String.format("%02d:%02d:%02d", minStart/3600 , minStart/60%60, minStart%60);
  }

  static int toSeconds(String time) {
    String[] split = time.split(":");
    int seconds = Integer.parseInt(split[2]);
    int minutes = Integer.parseInt(split[1]) * 60;
    int hours = Integer.parseInt(split[0]) * 3600;

    return seconds + minutes + hours;
  }
}
