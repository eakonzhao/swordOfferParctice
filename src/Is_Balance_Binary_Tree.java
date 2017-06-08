/**
 * Created by Eakon on 2017/6/7.
 * 平衡二叉树
 *
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Is_Balance_Binary_Tree {
    private boolean isBalance=true;
    public boolean IsBalanced_Solution(TreeNode root){
        getDepth(root);
        return isBalance;
    }

    private int getDepth(TreeNode root){
        if(root==null) return 0;
        int leftDepth=getDepth(root.left);
        int rightDepth=getDepth(root.right);
        if(Math.abs(leftDepth-rightDepth)>1) isBalance=false;
        return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
    }
}
