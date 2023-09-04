package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1991 {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    String[] split = br.readLine().split(" ");
    String first = split[0];
    String second = split[1];
    String third = split[2];

    Node left = second.equals(".") ? null : new Node(second, null, null);
    Node right = third.equals(".") ? null : new Node(third, null, null);

    Node root = new Node(first, left, right);

    for (int i = 1; i < n; i++) {
      split = br.readLine().split(" ");
      String nFirst = split[0];
      String nSecond = split[1];
      String nThird = split[2];

      Node nLeft = nSecond.equals(".") ? null : new Node(nSecond, null, null);
      Node nRight = nThird.equals(".") ? null : new Node(nThird, null, null);
      insertNode(root, new Node(nFirst, nLeft, nRight));
    }

    StringBuilder sb = new StringBuilder();
    prefixOrder(sb, root);
    sb.append("\n");
    suffixOrder(sb, root);
    sb.append("\n");
    postfixOrder(sb, root);

    System.out.println(sb);
  }

  static void insertNode(Node parent, Node insertNode ){
    if (parent == null) {
      return;
    }

    if (parent.recent.equals(insertNode.recent)) {
      parent.left = insertNode.left;
      parent.right = insertNode.right;
      return;
    }

    insertNode(parent.left, insertNode);
    insertNode(parent.right, insertNode);
  }

  static void prefixOrder(StringBuilder sb, Node root){
    if (root == null) {
      return;
    }
    sb.append(root.recent);
    prefixOrder(sb, root.left);
    prefixOrder(sb, root.right);
  }

  static void suffixOrder(StringBuilder sb, Node root){
    if (root == null) {
      return;
    }

    suffixOrder(sb, root.left);
    sb.append(root.recent);
    suffixOrder(sb, root.right);
  }

  static void postfixOrder(StringBuilder sb, Node root){
    if (root == null) {
      return;
    }

    postfixOrder(sb, root.left);
    postfixOrder(sb, root.right);
    sb.append(root.recent);
  }

  static class Node {
    String recent;
    Node left;
    Node right;

    public Node(String recent, Node left, Node right) {
      this.recent = recent;
      this.left = left;
      this.right = right;
    }
  }
}
