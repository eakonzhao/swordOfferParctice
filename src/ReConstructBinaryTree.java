/**
 * Created by Eakon on 2017/5/29.
 * 重建二叉树
 * int[] pre = {1,2,4,7,3,5,6,8}
 * int[] in = {4,7,2,1,5,3,8,6}
 */
public class ReConstructBinaryTree {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = null;
        if(pre!=null && in!=null){
            root = reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        }
        return root;
    }

    private TreeNode reConstructBinaryTree(int[] pre,int preBegin,int preEnd,int[] in,int inBegin,int inEnd){
        if(preBegin > preEnd){
            return null;
        }
        TreeNode root = new TreeNode(pre[preBegin]);
        int rootIndex = -1;
        for(int i=inBegin; i<=inEnd; i++){
            if(pre[preBegin]==in[i]){
                rootIndex=i;
            }
        }
        root.left = reConstructBinaryTree(pre,preBegin+1,preBegin+(rootIndex-inBegin),in,inBegin,rootIndex-1);
        root.right = reConstructBinaryTree(pre,preBegin+(rootIndex-inBegin)+1,preEnd,in,rootIndex+1,inEnd);
        return  root;
    }

}
