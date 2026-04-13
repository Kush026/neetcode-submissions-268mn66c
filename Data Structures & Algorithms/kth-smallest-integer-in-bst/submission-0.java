/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    private int res = -1;
    private int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);

        return res;
    }

    public void traverse(TreeNode node, int k) {

        if(node == null) {
            return;
        }

        traverse(node.left, k);

        if(count == k) {
            return;
        }
        else {
            count++;
            res = node.val;
        }

        traverse(node.right, k);
    }
}
