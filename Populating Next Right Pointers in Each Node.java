/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null){
            return;
        }
        connect(root.left);
        connect(root.right);
        TreeLinkNode lRight=root.left,rLeft=root.right,rRight=root.right;
        while(lRight!=null){
            lRight.next=rLeft;
            rRight.next=null;
            lRight=lRight.right;
            rLeft=rLeft.left;
            rRight=rRight.right;
        }
    }
}