/**
 * Created by Eakon on 2017/6/11.
 *
 * 序列化二叉树
 *
 * 请实现两个函数，
 * 分别用来序列化和反序列化二叉树
 */
public class SerializableBinaryTree {
    int index=-1;
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("");
        if(root==null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val+",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        index++;
        int length=str.length();
        if(index>=length) return null;
        String[] strArray=str.split(",");
        TreeNode node=null;
        if(!strArray[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strArray[index]));
            node.left=Deserialize(str);
            node.right=Deserialize(str);
        }
        return node;
    }
}
