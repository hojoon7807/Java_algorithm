package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B6549 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    while (true) {
      String input = br.readLine();

      if (input.equals(0)) {
        break;
      }
      String[] split = input.split(" ");

      int length = Integer.parseInt(split[0]);

      SegmentTree segmentTree = new SegmentTree(length);

      segmentTree.init(split, 1, 1, length);

      Arrays.sort(segmentTree.tree, (o1, o2) ->
          (int) ((o2[1] * o2[0]) - (o1[1] * o1[0])));
      System.out.println(segmentTree.tree[0][0] * segmentTree.tree[0][1]);
    }
  }

  static class SegmentTree {
    private long[][] tree;

    SegmentTree(int n) {
      // 트리의 높이 계산
      double treeHeight = Math.ceil(Math.log(n) / Math.log(2)) + 1;
      // 트리의 노드 수 계산
      long treeNodeCount = Math.round(Math.pow(2, treeHeight));
      // 트리의 길이 설정
      tree = new long[Math.toIntExact(treeNodeCount)][2];
    }

    // 세그먼트 트리의 노드 값 초기화
    long[] init(String[] arr, int node, int start, int end) {
      // 세그먼트 트리의 리프노드인 경우
      if (start == end) {
        // 리프노드에 배열의 값 저장 후 리턴
        return tree[node] = new long[]{Integer.parseInt(arr[start]), 1};
      } else {
        long[] left = init(arr, node * 2, start, (start + end) / 2);
        long[] right = init(arr, node * 2 + 1, (start + end) / 2 + 1, end);

        if (left[0] <= right[0]) {
          return tree[node] = new long[]{left[0], left[1] + right[1]};
        } else {
          return tree[node] = new long[]{right[0], left[1] + right[1]};
        }
      }
    }

    long[] sum(int node, int start, int end, int left, int right) {
      // 노드가 가지는 값의 구간이 구하려고 하는 합의 구간에 속하지 않는 경우 0리턴
      if (end < left || right < start) {
        return new long[]{0,0};
      } else if (left <= start && end <= right) {
        // 노드가 가지는 값의 구간이 구하려고 하는 합의 구간에 속하는 경우 노드 값 리턴
        return tree[node];
      } else {
        long[] sumLeft = sum(node * 2, start, (start + end) / 2, left, right);
        long[] sumRight = sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);

        if (sumLeft[0] <= sumLeft[0]) {
          return tree[node] = new long[]{sumLeft[0], sumLeft[1] + sumLeft[1]};
        } else {
          return tree[node] = new long[]{sumLeft[0], sumLeft[1] + sumLeft[1]};
        }
      }
    }
  }
}
