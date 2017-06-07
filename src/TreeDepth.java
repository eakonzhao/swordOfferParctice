import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Eakon on 2017/6/7.
 * 二叉树的深度
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 */
public class TreeDepth {
    /**
     * 递归
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root){
        if(root==null) return 0;
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        return (leftDepth>rightDepth)?leftDepth+1:rightDepth+1;
    }


    /**
     * 层次遍历，广度优先搜索 30ms 503k
     * @param root
     * @return
     */
    public int TreeDepthBFS(TreeNode root){
        if(root==null) return 0;
        int level=0;
        TreeNode current=null;
        int cur,last;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            cur=0;
            last=queue.size();
            while(cur<last){
                current=queue.poll();
                cur++;
                if(current.left!=null){
                    queue.offer(current.left);
                }
                if(current.right!=null){
                    queue.offer(current.right);
                }
            }
            level++;
        }
        return level;
    }
}
