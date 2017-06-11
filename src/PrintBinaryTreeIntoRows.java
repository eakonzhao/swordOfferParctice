import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Eakon on 2017/6/11.
 *
 * 把二叉树打印成多行
 *
 * 从上到下按层打印二叉树，
 * 同一层结点从左至右输出。
 * 每一层输出一行。
 */
public class PrintBinaryTreeIntoRows {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
        if(pRoot!=null){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(pRoot);
            while(!queue.isEmpty()){
                int index=0;
                int layerSize=queue.size();
                ArrayList<Integer> list = new ArrayList<>();
                while(index<layerSize){
                    TreeNode node = queue.poll();
                    if(node!=null){
                        list.add(node.val);
                        queue.add(node.left);
                        queue.add(node.right);
                    }
                    index++;
                }
                if(list!=null&&list.size()!=0){
                    listAll.add(new ArrayList(list));
                }
            }
        }
        return listAll;
    }
}
