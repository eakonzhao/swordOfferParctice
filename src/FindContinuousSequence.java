import java.util.ArrayList;

/**
 * Created by Eakon on 2017/6/8.
 *
 * 和为S的连续正向序列
 *
 *
 * 题目描述
 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,
 他马上就写出了正确答案是100。但是他并不满足于此,
 他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!

 输出描述:
 输出所有和为S的连续正数序列。
 序列内按照从小至大的顺序，
 序列间按照开始数字从小到大的顺序
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
        if(sum>=3){
            int low=1;
            int high=2;
            int mid=(1+sum)/2;
            while(low<mid){
                int tempSum = (low+high)*(high-low+1)/2;
                if(tempSum==sum){
                    ArrayList<Integer>  list = new ArrayList<>();
                    for(int i=low; i<=high; i++){
                        list.add(i);
                    }
                    listAll.add(new ArrayList(list));
                    high++;
                }else if(tempSum<sum){
                    high++;
                }else if(tempSum>sum){
                    low++;
                }
            }
         }
         return listAll;
    }
}
