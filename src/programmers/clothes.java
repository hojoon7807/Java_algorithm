package programmers;

import java.util.HashMap;

public class clothes {
    public static void main(String[] args) {
        String [][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap();

        for (String[] array: clothes)
            map.put(array[1], map.getOrDefault(array[1],0)+1);
        for(Integer value: map.values())
            answer *= value+1;
        answer -= 1;
        return answer;
    }
}
