import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Eakon on 2017/6/5.
 *
 * 把数组排成最小数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    /**
     * 下面是对数组元素能够组成的所有数进行全排列，排序之后
     * 取第一个
     * @param numbers
     * @return
     */
    public static String PrintMinNumber(int [] numbers) {
        if(numbers==null || numbers.length==0) return null;
        ArrayList<String> list = new ArrayList<>();
        Permutition(numbers,0,list);
        Collections.sort(list);
        return list.get(0);
    }

    private static void Permutition(int[] numbers, int index, ArrayList<String> list){
        if(numbers==null || numbers.length==0) return ;
        if(index==numbers.length-1){
            if(list.contains(intArrayToString(numbers))) return ;
            list.add(intArrayToString(numbers));
        }else{
            for(int i=index; i<numbers.length; i++){
                int temp = numbers[index];
                numbers[index] = numbers[i];
                numbers[i] = temp;

                Permutition(numbers,index+1,list);

                temp = numbers[index];
                numbers[index] = numbers[i];
                numbers[i] = temp;
            }
        }
    }

    private static String intArrayToString(int[] nums){
        StringBuilder sb = new StringBuilder();
        for(int element:nums){
            sb.append(element);
        }
        return sb.toString();
    }

    /**
     * 上面是全排列的方法
     */


    /**
     * 设定一个排序规则，数组根据这个排序规则排序之后能够排成一个最小的数字。要确定排序规则，就要比较两个数字，
     * 也就是给出两个数字m和n，我们需要确定一个规则判断m和n那个应该排在前面，而不是仅仅比较这两个数字哪个更大。
     * 根据题目要求，两个数字m和n能拼接成数字mn和nm。如果 mn<nm，那么我们应该打印出mn，也就是m应该排在n前面，
     * 我们定义此时m小于n；反之，如果mn>nm，我们定义n小于m。如果mn=nm,我们定义n=m。
     * @param numbers
     * @return
     */
    public static String PrintMinNumber2(int [] numbers) {
        ArrayList<Integer> list= new ArrayList<Integer>();
        StringBuilder sb = new StringBuilder("");
        if(numbers!=null||numbers.length!=0) {
            int n = numbers.length;
            for (int i = 0; i < n; i++) {
                list.add(numbers[i]);
            }
            Collections.sort(list, new Comparator<Integer>() {
                public int compare(Integer str1, Integer str2) {
                    StringBuilder s1 = new StringBuilder("").append(str1).append(str2);
                    StringBuilder s2 = new StringBuilder("").append(str2).append(str1);
                    return s1.toString().compareTo(s2.toString());
                }
            });
            for(int element:list){
                sb.append(element);
            }
        }
        return sb.toString();
    }
}
