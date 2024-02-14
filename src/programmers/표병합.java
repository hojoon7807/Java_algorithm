package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 표병합 {

  static Map<Integer, List<Cell>> mergeMap = new HashMap();
  static Cell[] cells = new Cell[2501];

  public static void main(String[] args) {
    solution(new String[]{"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap",
        "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean",
        "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian",
        "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik",
        "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"});
  }


  public static String[] solution(String[] commands) {
    List<String> prints = new ArrayList<>();
    for (int i = 0; i <= 2500; i++) {
      cells[i] = new Cell(0, "");
    }
    for (String command : commands) {
      String[] detail = command.split(" ");

      switch (detail[0]) {
        case "UPDATE":
          if (detail.length == 4) {
            int r = Integer.parseInt(detail[1]);
            int c = Integer.parseInt(detail[2]);
            int convertIndex = convertIndex(r, c);

            if (cells[convertIndex].id != 0) {
              List<Cell> cellList = mergeMap.get(cells[convertIndex].id);
              for (Cell cell : cellList) {
                cell.value = detail[3];
              }
            } else {
              cells[convertIndex].value = detail[3];
            }
          } else if (detail.length == 3) {
            for (Cell cell : cells) {
              if (cell.value.equals(detail[1])) {
                cell.value = detail[2];
              }
            }
          }
          break;
        case "MERGE":
          int r1 = Integer.parseInt(detail[1]);
          int c1 = Integer.parseInt(detail[2]);
          int r2 = Integer.parseInt(detail[3]);
          int c2 = Integer.parseInt(detail[4]);

          if (r1 == r2 && c1 == c2) {
            break;
          }

          int convertIndex1 = convertIndex(r1, c1);
          int convertIndex2 = convertIndex(r2, c2);

          int id1 = cells[convertIndex1].id;
          int id2 = cells[convertIndex2].id;

          if (id1 != 0 && id2 != 0 && id1 == id2) {
            break;
          }

          if (id1 == 0) {
            id1 = convertIndex1;
          }

          if (id2 == 0) {
            id2 = convertIndex2;
          }

          if (!mergeMap.containsKey(id1)) {
            List<Cell> mergeList = new ArrayList<>();
            mergeList.add(cells[convertIndex1]);
            mergeMap.put(id1, mergeList);
          }

          if (!mergeMap.containsKey(id2)) {
            List<Cell> mergeList = new ArrayList<>();
            mergeList.add(cells[convertIndex2]);
            mergeMap.put(id2, mergeList);
          }

          List<Cell> mergeList1 = mergeMap.get(id1);
          List<Cell> mergeList2 = mergeMap.get(id2);

          String value1 = mergeList1.get(0).value;
          String value2 = mergeList2.get(0).value;

          mergeList1.addAll(mergeList2);

          if (value1.equals("") && value2.equals("")) {
            for (Cell cell : mergeList1) {
              cell.id = id1;
            }
          } else if (value1.equals("") && !value2.equals("")) {
            for (Cell cell : mergeList1) {
              cell.id = id1;
              cell.value = value2;
            }
          } else {
            for (Cell cell : mergeList1) {
              cell.id = id1;
              cell.value = value1;
            }
          }

          mergeMap.remove(id2);
          break;
        case "UNMERGE": {
          int r = Integer.parseInt(detail[1]);
          int c = Integer.parseInt(detail[2]);

          int convertIndex = convertIndex(r, c);

          int id = cells[convertIndex].id;
          if (mergeMap.containsKey(id)) {
            List<Cell> mergeList = mergeMap.get(id);
            String value = mergeList.get(0).value;

            for (Cell cell : mergeList) {
              cell.id = 0;
              cell.value = "";
            }

            cells[convertIndex].value = value;
            mergeMap.remove(id);
          }
          break;
        }
        case "PRINT": {
          int r = Integer.parseInt(detail[1]);
          int c = Integer.parseInt(detail[2]);

          int convertIndex = convertIndex(r, c);

          String value = cells[convertIndex].value;
          prints.add(!value.equals("") ? value : "EMPTY");
          break;
        }
      }
    }
    return prints.toArray(new String[0]);
  }

  static int convertIndex(int r, int c) {
    return 50 * (r - 1) + c;
  }

  static class Cell {

    int id;
    String value;

    public Cell(int id, String value) {
      this.id = id;
      this.value = value;
    }
  }

}
