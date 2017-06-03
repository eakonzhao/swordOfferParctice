/**
 * Created by Eakon on 2017/6/1.
 * 二叉树的子结构
 */
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2){
        boolean result=false;
        if(root1!=null&&root2!=null){
            if(root1.val==root2.val){
                result=isSubtree(root1,root2);
            }
            if(!result){
                result=isSubtree(root1.left,root2);
            }
            if(!result){
                result=isSubtree(root1.right,root2);
            }
        }
        return result;
    }

    private boolean isSubtree(TreeNode node1, TreeNode node2){
        if(node2==null){
            return true;
        }
        if(node1==null){
            return false;
        }
        if(node1.val!=node2.val){
            return false;
        }
        return isSubtree(node1.left,node2.left) && isSubtree(node1.right,node2.right);
    }
}
