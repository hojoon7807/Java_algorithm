package programmers;

public class 신규아이디추천 {

  class Solution {
    public String solution(String new_id) {
      String firstStepString = firstStep(new_id);
      String secondStepString = secondStep(firstStepString);
      String thirdStepString = thirdStep(secondStepString);
      String fourthStepString = fourthStep(thirdStepString);
      String fifthStepString = fifthStep(fourthStepString);
      String sixthStepString = sixthStep(fifthStepString);
      String seventhStepString = seventhStep(sixthStepString);
      return seventhStepString;
    }

    private String firstStep(String s) {
      return s.toLowerCase();
    }

    private String secondStep(String s) {
      StringBuilder sb = new StringBuilder();
      for(char c : s.toCharArray()){
        if(c >= '0' && c<= '9' || c>='a'  && c <= 'z' || c=='-'|| c=='_'||c=='.'){
          sb.append(c);
        }
      }
      return sb.toString();
    }

    private String thirdStep(String s) {
      StringBuilder sb = new StringBuilder();
      boolean flag = false;
      for(char c : s.toCharArray()){
        if(c == '.'){
          if(!flag) {
            sb.append(c);
            flag = true;
          }
        } else {
          if(flag) {
            flag = false;
          }
          sb.append(c);
        }
      }
      return sb.toString();
    }

    private String fourthStep(String s) {
      StringBuilder sb = new StringBuilder();

      for(int i=0; i<s.length(); i++){
        if(i == 0 || i == s.length() - 1){
          if(s.charAt(i) == '.'){
            continue;
          }
        }
        sb.append(s.charAt(i));
      }

      return sb.toString();
    }

    private String fifthStep(String s){
      if(s.length() == 0){
        return "a";
      } else {
        return s;
      }
    }

    private String sixthStep(String s){
      String transString;
      if(s.length() > 15){
        if(s.charAt(14) == '.'){
          transString = s.substring(0,14);
        } else {
          transString = s.substring(0,15);
        }
      } else {
        transString = s;
      }

      return transString;
    }

    private String seventhStep(String s){
      String transString;

      if(s.length() < 3){
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i<3-s.length(); i++){
          sb.append(s.charAt(s.length()-1));
        }

        transString = sb.toString();
      } else {
        transString = s;
      }

      return transString;
    }
  }
}
