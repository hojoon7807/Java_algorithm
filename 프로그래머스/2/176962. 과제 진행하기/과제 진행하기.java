import java.util.*;

class Solution {
    public static String[] solution(String[][] plans) {
        Stack<Assignment> stack = new Stack<>();
        Arrays.sort(plans, (o1,o2) -> o1[1].compareTo(o2[1]));
        
        Assignment curAssignment = null;
        
        ArrayList<String> complete = new ArrayList<>();
        
        for(int i=0; i<plans.length; i++){
            String[] plan = plans[i];
            String name = plan[0];
            int startTime = toIntTime(plan[1]);
            int playTime = Integer.parseInt(plan[2]);
            
            Assignment assignment = new Assignment(name, startTime, playTime);
            // 시작 할당
            if(curAssignment == null){
                curAssignment = assignment;
                continue;
            }
            
            // 현재 작업이 끝나기전 새로운 과제 시작
            int endTime = curAssignment.start + curAssignment.playTime;
  
            // 대기 스택에 넣기
            if(endTime > startTime){
                // 남은 시간 갱신
                curAssignment.playTime = endTime - startTime;
                stack.push(curAssignment);
                curAssignment = assignment;
            } else {
                //완료 넣기
                complete.add(curAssignment.name);
                // 대기 스택 확인
                while(true){
                    // 대기 스택 없으면 종료
                    if(stack.isEmpty()){
                        break;
                    }
                    
                    Assignment wait = stack.pop();
                    endTime += wait.playTime;
                    
                    if(endTime > startTime){
                        // 남은 시간 갱신
                        wait.playTime = endTime - startTime;
                        stack.push(wait);
                        break;
                    } else {
                        complete.add(wait.name); 
                    }
                }
                curAssignment = assignment;
            }
            
            if(i == plans.length - 1){
                complete.add(name);
            }
        }
        
        while(!stack.isEmpty()){
            complete.add(stack.pop().name);
        }
        
        String[] answer = complete.toArray(new String[0]);
             
        return answer;
    }
    
    static int toIntTime(String time){
        String[] split = time.split(":");
        int hours = Integer.parseInt(split[0]);
        int minutes = Integer.parseInt(split[1]);
        
        return hours * 60 + minutes; 
    }
    
    static class Assignment{
        String name;
        int start;
        int playTime;
        
        public Assignment(String name, int start, int playTime){
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
    }
}