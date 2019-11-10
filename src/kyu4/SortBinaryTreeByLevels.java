package kyu4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*You are given a binary tree:
Your task is to return the list with elements from tree sorted by levels,
which means the root element goes first, then root children (from left to right) are second and third, and so on.

Return empty list is root is 'null'.

Example 1 - following tree:
            2
        8        9
      1  3     4   5

Should return following list:
[2,8,9,1,3,4,5]
*/
public class SortBinaryTreeByLevels {
    public static List<Integer> treeByLevels(Node node) {
        List<Integer> out = new ArrayList<>();
        if (node == null) return out;
        out.add(node.value);
        if (node.left != null || node.right != null)
            Stream.concat(treeByLevels(node.left).stream(), treeByLevels(node.right).stream()).forEach(out::add);
        return out;
    }

    class Node {
        public Node left;
        public Node right;
        public int value;

        public Node(Node l, Node r, int v) {
            left = l;
            right = r;
            value = v;
        }
    }
}
