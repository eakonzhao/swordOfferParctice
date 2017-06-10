/**
 * Created by Eakon on 2017/6/11.
 *
 * 二叉树的下一个节点
 *
 * 给定一个二叉树和其中的一个结点，
 * 请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class GetNextNodeInBinaryTree {

    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if(pNode==null) return null;
        TreeLinkNode node=pNode;
        //有右子树，中序遍历的下一个节点为右子树的最左子节点
        if(node.right!=null){
            node=node.right;
            while(node.left!=null) node=node.left;
            return node;
        }
        while(node.next!=null){
            if(node==node.next.left) return node;
            node=node.next;
        }
        return null;
    }
}
