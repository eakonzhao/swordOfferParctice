/**
 * Created by Eakon on 2017/6/2.
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySequenceOfBST {

    public boolean verifySequenceOfBST(int[] sequence){
        if(sequence==null || sequence.length==0) return false;
        return isBST(sequence,0,sequence.length-1);
    }

    private boolean isBST(int[] sequence, int left, int right){
        if(left>right) return true;
        int leftIndex=0;
        while(leftIndex<right && sequence[leftIndex]<sequence[right]) leftIndex++;

        for(int i=leftIndex; i<right; i++){
            if(sequence[i]<sequence[right]) return false;
        }

        boolean leftSub=isBST(sequence,left,leftIndex-1);
        boolean rightSub=isBST(sequence,leftIndex,right-1);
        return leftSub&&rightSub;
    }
}
