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
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return root;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        else {

            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            TreeNode min = getMin(root.right); // 4
            root.val = min.val;
            root.right = deleteNode(root.right, min.val);
        }
        return root;
    }

    public TreeNode removeLeaf(TreeNode root, int key) {

        if(root.val == key) {
            return null;
        }

        if(key < root.val) {
            root.left = removeLeaf(root.left, key);
        }
        else {
            root.right = removeLeaf(root.right, key);
        }

        return root;
    }

    public TreeNode search(TreeNode root, int key) {
        if(root == null) {
            return null;
        }

        if(key < root.val) {
            return search(root.left, key);
        }
        else if (key > root.val) {
            return search(root.right, key);
        }
        else {
            return root;
        }
    }

    public TreeNode getMin(TreeNode root) {
        if(root == null || root.left == null) {
            return root;
        }

        return getMin(root.left);
    }
}