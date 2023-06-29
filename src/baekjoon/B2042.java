package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2042 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);
    int k = Integer.parseInt(input[2]);

    m += k;

    long[] numArr = new long[n];

    for (int i = 0; i < n; i++) {
      numArr[i] = Long.parseLong(br.readLine());
    }

    int h = (int) Math.ceil(Math.log(n) / Math.log(2));
    int treeSize = (int) Math.pow(2, h + 1);

    SegmentTree segmentTree = new SegmentTree(treeSize);
    segmentTree.init(numArr, 0, n - 1, 1);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      input = br.readLine().split(" ");
      int a = Integer.parseInt(input[0]);
      int b = Integer.parseInt(input[1]);
      long c = Long.parseLong(input[2]);

      if (a == 1) {
        numArr[b - 1] = c;
        segmentTree.update(1, 0, n - 1, b - 1, c);
      } else {
        sb.append(segmentTree.query(1, 0, n - 1, b - 1, (int) c - 1) + "\n");
      }
    }

    System.out.println(sb);

  }


  private static class SegmentTree {

    long[] tree;

    public SegmentTree(int size) {
      tree = new long[size];
    }

    void init(long[] numArr, int start, int end, int node) {
      if (start == end) {
        tree[node] = numArr[start];
      } else {
        init(numArr, start, (start + end) / 2, node * 2);
        init(numArr, (start + end) / 2 + 1, end, node * 2 + 1);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
      }
    }

    long query(int node, int start, int end, int left, int right) {
      if (left > end || start > right) {
        return 0;
      }

      if (left <= start && end <= right) {
        return tree[node];
      }

      long lSum = query(node * 2, start, (start + end) / 2, left, right);
      long rSum = query(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
      return lSum + rSum;
    }

    void update(int node, int start, int end, int index, long value) {
      if (index < start || index > end) {
        return;
      }
      if (start == end) {
        tree[node] = value;
        return;
      }

      update(node * 2, start, (start + end) / 2, index, value);
      update(node * 2 + 1, (start + end) / 2 + 1, end, index, value);
      tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
  }
}
