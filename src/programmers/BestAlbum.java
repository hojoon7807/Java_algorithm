package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BestAlbum {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        solution(genres, plays);
    }

    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genrePlayCountMap = new HashMap();
        List<String> genresList = new ArrayList();
        for (int i=0; i<genres.length; i++){
            genrePlayCountMap.put(genres[i], genrePlayCountMap.getOrDefault(genres[i],0)+plays[i]);
        }

        while(genrePlayCountMap.size() != 0){
            int max = -0;
            String maxKey = "";
            for(String key: genrePlayCountMap.keySet()){
                int tmp = genrePlayCountMap.get(key);
                if(tmp > max){
                    max = tmp;
                    maxKey = key;
                }
            }
            genresList.add(maxKey);
            genrePlayCountMap.remove(maxKey);
        }

        List<Integer> results = new ArrayList();

        for (String genre:genresList){
            HashMap<Integer, Integer> idxMap = new HashMap();

            for (int i=0; i<genres.length; i++){
                if(genres[i].equals(genre)){
                    idxMap.put(i, plays[i]);
                }
            }
            List<Integer> list = new ArrayList(idxMap.keySet());
            Collections.sort(list, (o1, o2)-> idxMap.get(o2) - idxMap.get(o1));
            System.out.println("sdfdsf");
            results.add(list.get(0));
            if (list.size() != 1){
                results.add(list.get(1));
            }
        }
        int[] answer = new int[results.size()];
        for (Integer i : results){
            answer[results.indexOf(i)] = i;
        }

        return answer;
    }
}
