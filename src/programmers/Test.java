package programmers;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static int[] solution(int[] answers) {
        int[] answer = {};
        int max = 0;
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores= new int[3];

        for(int i=0; i<answers.length; i++){
            if(student1[i%5] == answers[i]) scores[0] ++;
            if(student2[i%8] == answers[i]) scores[1] ++;
            if(student3[i%10] == answers[i]) scores[2] ++;
        }

        for(int i=0; i<scores.length; i++){
            if(scores[i] >= max) max = scores[i];
        }

        List<Integer> result = new ArrayList();

        for(int i=0; i<scores.length; i++){
            if(scores[i] == max) result.add(i+1);
        }
        //answer = result.stream().mapToInt(Integer::intValue).toArray();
        answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;
    }
}
