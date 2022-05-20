package programmers;

import java.util.Arrays;

public class Hindex {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        for(int i=0; i<citations.length; i++){
            int h = citations.length - i;
            if(citations[i]>=h){
                answer = h;
                break;
            }
        }

        return answer;
    }

    public int solution2(int[] citations) {
        reverse(citations);
        if (citations[0] == 0) {
            return 0;
        }
        System.out.println(Arrays.toString(citations));
        int answer = 0;
        int count = 0;
        for (int citation : citations) {
            for (int i = 0; i < citations.length; i++) {
                if (count == citation) {
                    break;
                }
                if (citations[i] >= citation) {
                    count++;
                }
                if (count >= answer) {
                    answer = count;
                }

            }
            count = 0;
        }
        System.out.println(count);

        return answer;
    }

    static void reverse(int[] arr){
        Arrays.sort(arr);

        for (int i=0; i<arr.length/2; i++){
            int tmp = arr[arr.length-i-1];
            arr[arr.length-i-1] = arr[i];
            arr[i] = tmp;
        }
    }
}
