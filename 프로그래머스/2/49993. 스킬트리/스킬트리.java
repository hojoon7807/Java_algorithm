import java.util.*;

class Solution {
    static HashSet<Character> set = new HashSet<>();
    public int solution(String skill, String[] skill_trees) {
        int curIndex = 0;
        
        int len = skill.length();
        
        for(int i=0; i<len; i++){
            set.add(skill.charAt(i));
        }
        
        int answer = 0;
        
        
        for(String skillTree : skill_trees){
            boolean canLearn = true;
            for(char s : skillTree.toCharArray()){
                // 선행스킬이 없는 경우 
                if(!set.contains(s)){
                    continue;
                }
                
                // 선행스킬이 있는데 지금 배울 수 있는지 체크
                if(skill.charAt(curIndex) != s){
                    canLearn = false;
                    break;
                }
                
                curIndex++;
            }
            
            if(canLearn){
                answer++;
            }
            
            curIndex = 0;
        }
        
        return answer;
    }
}