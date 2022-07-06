package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

public class well {

  public static void main(String[] args) {
    String[] answer = {};
    String[] logs = {"morgan sort", "felix sort", "morgan sqrt", "morgan sqrt", "rohan reverse", "rohan reverse"};
    HashMap<String, Integer> problem = new HashMap<String, Integer>();
    HashSet<String> people = new HashSet<>();
    HashSet<String> deleteDup = new HashSet<>();

    for (String s:logs){
      deleteDup.add(s);
    }


    for (String s : deleteDup) {
      String[] splitStirng = s.split(" ");
      people.add(splitStirng[0]);
      problem.put(splitStirng[1], problem.getOrDefault(splitStirng[1],0)+1);
    }

    int wellKnownCount = 0;
    if(people.size()%2 == 0){
      wellKnownCount = people.size()/2;
    }else {
      wellKnownCount = people.size()/2 + 1;
    }

    Iterator<Entry<String, Integer>> iterator = problem.entrySet().iterator();
    ArrayList<String> result = new ArrayList<>();
    while (iterator.hasNext()) {
      Entry<String, Integer> entry = iterator.next();
      if (entry.getValue() >= wellKnownCount){
        result.add(entry.getKey());
      }
    }
    answer = new String[result.size()];
    result.toArray(answer);
  }
  

}
