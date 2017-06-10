/**
 * Created by Eakon on 2017/6/11.
 *
 * 对称的二叉树
 *
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class IsSymmertical {
    public boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot==null) return true;
        return isSymmetrical(pRoot.left,pRoot.right);
    }

    private boolean isSymmetrical(TreeNode pRoot1,TreeNode pRoot2){
        if(pRoot1==null&&pRoot2==null) return true;
        if(pRoot1==null||pRoot2==null) return false;
        return isSymmetrical(pRoot1.left,pRoot2.right)&&isSymmetrical(pRoot1.right,pRoot2.left);
    }
}
