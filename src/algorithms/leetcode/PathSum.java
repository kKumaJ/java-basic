package algorithms.leetcode;

//112
public class PathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean solution(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == sum;
        int newSum = sum - root.val;
        return solution(root.left, newSum) || solution(root.right, newSum);
    }
}
