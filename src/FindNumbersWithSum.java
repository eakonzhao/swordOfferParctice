import java.util.ArrayList;

/**
 * Created by Eakon on 2017/6/8.
 *
 * 和为S的两个数字
 *
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if(array!=null&&array.length>=2){
            int low=0;
            int high=array.length-1;
            while(low<high){
               if(array[low]+array[high]==sum){
                   list.add(array[low]);
                   list.add(array[high]);
                   break;
               }else if(array[low]+array[high]>sum){
                   high--;
               }else if(array[low]+array[high]<sum){
                   low++;
               }
            }
        }
        return list;
    }
}
