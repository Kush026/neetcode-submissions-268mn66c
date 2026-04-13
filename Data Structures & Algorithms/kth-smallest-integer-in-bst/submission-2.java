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
    public int kthSmallest(TreeNode root, int k) {

        TreeNode cur = root;

        while(cur != null) {
            if(cur.left == null) {
                k--;
                if(k == 0) {
                    return cur.val;
                }
                // System.out.println(cur.val);
                cur = cur.right;
            }
            else {
                TreeNode temp = cur.left; // 2

                while(temp.right != null && temp.right != cur) {
                    temp = temp.right; // 1 
                }

                if(temp.right == null) {
                    temp.right = cur;
                    cur = cur.left;
                } else {
                    k--;
                    // System.out.println("non null: " + cur.val);
                    if(k == 0) {
                        return cur.val;
                    }

                    temp.right = null;
                    cur = cur.right;
                }
            }
        }

        return -1;
    }
}
