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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        traverse(root, res);

        return res;
    }

    private void traverse(TreeNode n, List<Integer> res) {
        if(n == null) {
            return;
        }

        traverse(n.left, res);
        res.add(n.val);
        traverse(n.right, res);
    }
}