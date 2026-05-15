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
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> out = new ArrayList<>();
        dfs(root, out);

        return out;
        
    }

    private void dfs(TreeNode node, List<Integer> out) {
        if(node == null) return;
        dfs(node.left, out);
        dfs(node.right, out);
        out.add(node.val);
    }

    
}