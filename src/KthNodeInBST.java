/**
 * Created by Eakon on 2017/6/12.
 *
 * 二叉搜索树的第k个节点
 *
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。
 * 例如，
 *    5
 *  /  \
 *  3   7
 * / \ / \
 * 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class KthNodeInBST {
    ArrayList<TreeNode> tempList = new ArrayList<>();
    public TreeNode KthNode(TreeNode pRoot,int k){
        if(pRoot==null||k<=0) return null;
        ArrayList<TreeNode> list = getLDR_recursion(pRoot);
        return list.size()<=k-1?null:list.get(k-1);
    }

    private ArrayList<TreeNode> getLDR_recursion(TreeNode node){
        if(node==null) return null;
        getLDR_recursion(node.left);
        tempList.add(node);
        getLDR_recursion(node.right);
        return tempList;
    }

    private ArrayList<TreeNode> getLDR_noRecursion(TreeNode node){
        if(node==null) return null;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(!stack.isEmpty()||node!=null){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }else{
                node=stack.pop();
                tempList.add(node);
                node=node.right;
            }
        }
        return tempList;
    }
}
