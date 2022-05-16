package programmers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class marathon {
    public static void main(String[] args) throws IOException {
        String[] completion = {"eden", "kiki"};
        String[] participant = {"leo", "kiki", "eden"};

        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap();

        for (String player: participant){
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        for(String player:completion){
            map.put(player, map.get(player) - 1);
        }

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            if(entry.getValue() != 0){
                answer = entry.getKey();
                break;
            }
        }

        return answer;
    }
}
