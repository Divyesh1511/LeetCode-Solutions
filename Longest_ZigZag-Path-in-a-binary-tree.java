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
    int max= 0;
    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0);
        dfs(root, false, 0);
        return max;
    }

    private void dfs(TreeNode root, boolean isLeft, int count){
        if(root == null) return;
        max = Math.max(max, count);

        if(isLeft){
            dfs(root.left, false, count+1);
            dfs(root.right, true, 1);
        }else{
            dfs(root.right, true, count+1);
            dfs(root.left, false, 1);
        }
    }
}
