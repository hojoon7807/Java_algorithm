package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 교점에별만들기 {

  public static void main(String[] args) {
    solution(new int[][]{{0, 1, -1}, {1, 0, 1}, {1, 0, -1}});
  }

  public static  String[] solution(int[][] line) {
    String[] answer;

    ArrayList<Point> points = new ArrayList<>();
    for (int i = 0; i < line.length; i++) {
      for (int j = i + 1; j < line.length; j++) {
        Point intersection = calIntersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1],
            line[j][2]);

        if (intersection != null) {
          points.add(intersection);
        }
      }
    }

    Point maxPoint = getMaxPoint(points);
    Point minPoint = getMinPoint(points);

    int width = (int)(maxPoint.x - minPoint.x + 1);
    int height = (int)(maxPoint.y - minPoint.y + 1);

    char[][] coordinates = new char[height][width];

    for (int i = 0; i < coordinates.length; i++) {
      Arrays.fill(coordinates[i], '.');
    }

    for (Point point : points) {
      int y = (int)(maxPoint.y - point.y);
      int x = (int)(point.x - minPoint.x);
      coordinates[y][x] = '*';
    }

    answer = new String[coordinates.length];

    for (int i = 0; i < answer.length; i++) {
      answer[i] = new String(coordinates[i]);
    }
    return answer;
  }

  private static Point getMinPoint(List<Point> points) {
    long x = Long.MAX_VALUE;
    long y = Long.MAX_VALUE;

    for (Point point : points) {
      x = Math.min(x, point.x);
      y = Math.min(y, point.y);
    }

    return new Point(x, y);
  }

  private static Point getMaxPoint(List<Point> points) {
    long x = Long.MIN_VALUE;
    long y = Long.MIN_VALUE;

    for (Point point : points) {
      x = Math.max(x, point.x);
      y = Math.max(y, point.y);
    }

    return new Point(x, y);
  }

  private static Point calIntersection(long a, long b, long e, long c, long d, long f){
    double x = (double) (b * f - e * d) / (a * d - b * c);
    double y = (double) (e * c - a * f) / (a * d - b * c);

    if (x % 1 != 0 || y % 1 != 0) {
      return null;
    }

    return new Point((long)x, (long)y);
  }

  private static class Point {
    long x, y;

    public Point(long x, long y) {
      this.x = x;
      this.y = y;
    }
  }
}
