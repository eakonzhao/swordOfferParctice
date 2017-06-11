/**
 * Created by Eakon on 2017/6/11.
 *
 * 序列化二叉树
 *
 * 请实现两个函数，
 * 分别用来序列化和反序列化二叉树
 */
public class SerializableBinaryTree {
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("");
        if(root!=null){
            sb.append(root.val+",");
            
        }
        sb.append("$,");
        return sb.toString();
    }

    TreeNode Deserialize(String str) {

    }
}
