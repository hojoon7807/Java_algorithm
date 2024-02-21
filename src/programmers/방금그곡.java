package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 방금그곡 {

  public static void main(String[] args) {
    String s = "CC#BCC#BCC#BCC#B";
    System.out.println(solution("CC#BCC#BCC#", new String[]{"03:00,03:08,FOO,CC#B"}));
  }

  public static String solution(String m, String[] musicinfos) {
    String answer = "";
    ArrayList<MusicInfo> list = new ArrayList<MusicInfo>();
    ArrayList<String> mList = toList(m);
    for(String musicInfo: musicinfos){
      MusicInfo music = new MusicInfo(musicInfo.split(","));
      list.add(music);
      System.out.println(Arrays.toString(music.lyric));
    }

    list.sort((o1,o2) -> o2.lyric.length - o1.lyric.length);

    for(MusicInfo music : list){
      if(music.isMatch(mList)){
        answer = music.name;
        break;
      }
    }

    if(answer.equals("")){
      answer = "(None)";
    }
    return answer;
  }

  static ArrayList<String> toList(String m){
    ArrayList<String> list = new ArrayList<String>();

    for(int i = 0; i<m.length(); i++){
      String s = String.valueOf(m.charAt(i));

      if(s.equals("#")){
        String last = list.get(list.size()-1);
        last += "#";
        list.set(list.size()-1, last);
      } else {
        list.add(s);
      }
    }

    return list;
  }

  static class MusicInfo{
    String name;
    String[] lyric;

    public MusicInfo(String[] musicInfo){
      this.name = musicInfo[2];
      this.lyric = getAllLengthLyrics(musicInfo);
    }

    public boolean isMatch(List<String> m){
      for(int i=0; i<=lyric.length - m.size(); i++){
        int count = 0;
        for(int j=i; j<i+m.size(); j++){
          if(!lyric[j].equals(m.get(j-i))){
            break;
          } else {
            count++;
          }
        }

        if(count == m.size()){
          return true;
        }
      }

      return false;
    }

    private String[] getAllLengthLyrics(String[] musicInfo){
      String[] startTime = musicInfo[0].split(":");
      String[] endTime = musicInfo[1].split(":");
      String lyric = musicInfo[3];

      int startHour = Integer.parseInt(startTime[0]);
      int endHour = Integer.parseInt(endTime[0]);
      int startMinute = Integer.parseInt(startTime[1]);
      int endMinute = Integer.parseInt(endTime[1]);

      int playTime = (endHour - startHour)* 60 + (endMinute - startMinute);

      String[] allLyric = new String[playTime];

      ArrayList<String> list = toList(lyric);
      int index = 0;
      // CC#B // time 6 C C
      for(int i=0; i<playTime; i++){
        allLyric[i] = list.get(i % list.size());
      }

      return allLyric;
    }
  }
}
