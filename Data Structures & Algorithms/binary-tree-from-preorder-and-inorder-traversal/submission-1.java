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

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder == null || preorder.length == 0) {
            return null;
        }

        int length = preorder.length;
        return buildTree(preorder, inorder, 0, length-1, 0, length-1);
    }

    private TreeNode buildTree(int[] pre, int[] in, int preS, int preE, int inS, int inE) {

        if(preS == preE) {
            return new TreeNode(pre[preS]);
        }

        int root = pre[preS];

        if(map.get(root) == null) { 
            for(int i = inS; i <= inE; i++) {
                map.put(in[i], i);
                if(in[i] == root) {
                    break;
                }
            }
        }

        int rootIdx = map.get(root);

        if(rootIdx == inS) {
            return new TreeNode(root, null, buildTree(pre, in, preS+1, preE, inS+1, inE));
        }
        else if(rootIdx == inE) {
            return new TreeNode(root, buildTree(pre, in, preS+1, preE, inS, inE-1), null);
            
        }
        else {
            return new TreeNode(root, buildTree(pre, in, preS+1, preS+(rootIdx-inS), inS, rootIdx-1),
            buildTree(pre, in, preS+(rootIdx-inS)+1, preE, rootIdx+1, inE));
        }

    }
}
