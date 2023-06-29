package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 불량사용자 {

  public static void main(String[] args) {
    solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
        new String[]{"*rodo", "*rodo", "******"});
  }

  public static int solution(String[] user_id, String[] banned_id) {
    String[][] replaceBannedId = Arrays.stream(banned_id)
        .map(banned -> banned.replace("*", "."))
        .map(banned -> Arrays.stream(user_id)
            .filter(id -> id.matches(banned))
            .toArray(String[]::new))
        .toArray(String[][]::new);

    Set<Set<String>> set = new HashSet();

    combine(0, replaceBannedId, new HashSet(), set);

    return set.size();
  }

  static void combine(int idx, String[][] bans, Set<String> banned, Set<Set<String>> bannedSet) {
    if (idx == bans.length) {
      bannedSet.add(new HashSet<>(banned));
      return;
    }

    for (String banId : bans[idx]) {
      if (banned.contains(banId)) {
        continue;
      }

      banned.add(banId);
      combine(idx + 1, bans, banned, bannedSet);
      banned.remove(banId);
    }
  }
}
