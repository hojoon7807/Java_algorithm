package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B21737 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    String input = br.readLine();

    StringBuilder intSb = new StringBuilder();

    StringBuilder sb = new StringBuilder();
    ArrayList<Integer> values = new ArrayList<>();
    StringBuilder commands = new StringBuilder();

    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (c <= '9' && c >= '0') {
        intSb.append(c);
      } else {
        if(intSb.length() == 0){
          commands.append(c);
          continue;
        }
        values.add(Integer.valueOf(intSb.toString()));
        intSb = new StringBuilder();
        commands.append(c);
      }
    }

    int index = 0;

    String commandString = commands.toString();
    for (int i = 0; i < n; i++) {
      char command = commandString.charAt(i);
      if (command == 'C') {
        sb.append(values.get(index)).append(" ");
        continue;
      }

      if (index == values.size() - 1) {
        break;
      }
      if (command == 'S') {
        int result = values.get(index) - values.get(index + 1);
        index ++;
        values.set(index, result);
        continue;
      }

      if (command == 'M') {
        int result = values.get(index) * values.get(index + 1);
        index ++;
        values.set(index, result);
        continue;
      }

      if (command == 'U') {
        int result = values.get(index) / values.get(index + 1);
        index ++;
        values.set(index, result);
        continue;
      }

      if (command == 'P') {
        int result = values.get(index) + values.get(index + 1);
        index ++;
        values.set(index, result);
        continue;
      }
    }

    System.out.println(sb.length() == 0 ? "NO OUTPUT" : sb.toString());

  }

}
