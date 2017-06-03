/**
 * Created by Eakon on 2017/6/1.
 * 二叉树的镜像
 */

import java.util.LinkedList;

public class Mirror {

    /**
     * 递归
     * @param root
     */
    public void Mirror1(TreeNode root){
        if(root==null || (root.left==null&&root.right==null)){
            return ;
        }
        TreeNode temp=root.left;
        root.left = root.right;
        root.right = temp;
        Mirror1(root.left);
        Mirror1(root.right);
    }

    /**
     * 非递归
     * @param root
     */
    public void Mirror2(TreeNode root){
        if(root==null || (root.left==null&&root.right==null)){
            return ;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current=null;
        TreeNode temp=null;
        stack.addLast(root);
        while(!stack.isEmpty()){
            current=stack.removeLast();
            if(current.right!=null || current.left!=null){
                temp=current.left;
                current.left=current.right;
                current.right=temp;
            }
            if(current.left!=null){
                stack.addLast(current.left);
            }
            if(current.right!=null){
                stack.addLast(current.right);
            }
        }
    }
}
