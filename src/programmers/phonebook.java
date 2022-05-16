package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class phonebook {
    public static void main(String[] args) {
        String[] phoneBook = {"119", "97674223", "1195524421"};
        System.out.println(solution(phoneBook));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for (int i = 0; i<phone_book.length -1; i++)
            if(phone_book[i+1].startsWith(phone_book[i]))
                answer = false;

        return answer;
    }

    public static boolean solution2(String[] phone_book) {
        boolean answer = true;
        Map<String, String> map = new HashMap();

        for(String phone:phone_book)
            map.put(phone,phone);

        for(String phone:phone_book)
            for(int i=0; i<phone.length(); i++)
                if (map.containsKey(phone.substring(0,i)))
                    answer = false;
        return answer;
    }
}
