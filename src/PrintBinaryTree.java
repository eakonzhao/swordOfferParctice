import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Eakon on 2017/6/11.
 *
 * 按之字形顺序打印二叉树
 *
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推
 */
public class PrintBinaryTree {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
        if(pRoot!=null){
            int layer=1;
            LinkedList<TreeNode> stack1 = new LinkedList<>();//存放奇数层节点
            LinkedList<TreeNode> stack2 = new LinkedList<>();//存放偶数层节点
            stack1.push(pRoot);

            while(!stack1.isEmpty()||!stack2.isEmpty()){
                if(layer%2!=0){
                    ArrayList<Integer> temp = new ArrayList<>();
                    while(!stack1.isEmpty()){
                        TreeNode node = stack1.pop();
                        if(node!=null){
                            temp.add(node.val);
                            stack2.push(node.left);
                            stack2.push(node.right);
                        }
                    }
                    if(!temp.isEmpty()){
                        listAll.add(new ArrayList(temp));
                    }
                }else{
                    ArrayList<Integer> temp = new ArrayList<>();
                    while(!stack2.isEmpty()){
                        TreeNode node = stack2.pop();
                        if(node!=null){
                            temp.add(node.val);
                            stack1.push(node.right);
                            stack1.push(node.left);
                        }
                    }
                    if(!temp.isEmpty()){
                        listAll.add(new ArrayList(temp));
                    }
                }
                layer++;
            }
        }
        return listAll;
    }
}
