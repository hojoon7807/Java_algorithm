package programmers;

import java.util.Arrays;

public class MaxValue {
    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        String[] stringArr = new String[numbers.length];
        //StringBuilder sb = new StringBuilder();
        String answer = "";
        int i = 0;
        for (int num: numbers){
            stringArr[i] = String.valueOf(num);
            i++;
        }

        Arrays.sort(stringArr, (o1,o2) -> (o2+o1).compareTo(o1+o2));

        if (stringArr[0].equals("0")) return "0";
//        for(String s: stringArr){
//            sb.append(s);
//        }
        answer = String.join("", stringArr);
        return answer;
    }
}
