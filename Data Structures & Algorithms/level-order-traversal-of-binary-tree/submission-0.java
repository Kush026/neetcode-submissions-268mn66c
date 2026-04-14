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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new LinkedList<>();

        Queue<TreeNode> que = new LinkedList<TreeNode>();

        if(root != null) {
            que.add(root);
        }

        while(!que.isEmpty()) {

            int size = que.size();
            List<Integer> level = new LinkedList<Integer>();

            for(int i = 0; i < size; i++) {
                TreeNode n = que.poll();
                level.add(n.val);
                
                if(n.left != null) {
                    que.add(n.left);
                }
                
                if(n.right != null) {
                    que.add(n.right);
                }
            }

            res.add(level);

        }

        return res;
    }
}
