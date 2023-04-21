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
    class MyNode{
        TreeNode node;
        int idx;
        MyNode(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        if(root == null) return max;
        Queue<MyNode> q = new LinkedList<>();
        q.add(new MyNode(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            int start = 0;
            int end = 0;
            for(int i = 0; i < size; i++){
                MyNode p = q.poll();
                int index = p.idx;

                if(i == 0) start = index;
                if(i == size-1) end = index;

                if(p.node.left != null){
                    q.add(new MyNode(p.node.left, index*2 + 1));
                }
                if(p.node.right != null){
                    q.add(new MyNode(p.node.right, index*2 + 2));
                }
            }

            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
