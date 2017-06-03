import java.util.ArrayList;

/**
 * Created by Eakon on 2017/6/2.
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class FindPath {

    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        if(root==null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target==0&&root.left==null&&root.right==null){
            listAll.add(new ArrayList(list));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);
        return listAll;
    }
}
