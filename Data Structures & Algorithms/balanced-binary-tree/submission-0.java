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
    public boolean isBalanced(TreeNode root) {

        if(root == null) {
            return true;
        }

        return metadata(root).isBalanced;
    }

    private MetaData metadata(TreeNode node) {
        if(node == null) {
            return new MetaData(0, true);
        }

        MetaData l = metadata(node.left);
        MetaData r = metadata(node.right);

        int height = 1 + Math.max(l.height, r.height);

        boolean balanced = true;

        if(!l.isBalanced || !r.isBalanced) {
            balanced = false;
        }
        else {
            balanced = Math.abs(l.height - r.height) <= 1;
        }

        return new MetaData(height, balanced);
    }

    public static class MetaData {
        int height;
        boolean isBalanced;

        public MetaData(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
}
