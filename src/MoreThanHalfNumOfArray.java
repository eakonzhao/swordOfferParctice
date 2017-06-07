/**
 * Created by Eakon on 2017/6/3.
 * 数组中出现次数超过一半的数字
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */

import java.util.HashMap;
import java.util.Map;
public class MoreThanHalfNumOfArray {
    public int MoreThanHalfNum_Solution(int [] array){
        if(array!=null || array.length!=0) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < array.length; i++) {
                if (map.containsKey(array[i])) {
                    map.put(array[i], map.get(array[i]) + 1);
                } else {
                    map.put(array[i], 1);
                }
            }
            for (int i = 0; i < array.length; i++) {
                if (map.get(array[i]) > array.length / 2) {
                    return map.get(array[i]);
                }
            }
        }
        return 0;
    }


    /**
     * 采用阵地攻守的思想： 第一个数字作为第一个士兵，守阵地；count = 1；
     * 遇到相同元素，count++; 遇到不相同元素，即为敌人，同归于尽,count--；
     * 当遇到count为0的情况，又以新的i值作为守阵地的士兵，继续下去，
     * 到最后还留在阵地上的士兵，有可能是主元素。 再加一次循环，记录这个士兵的个数看是否大于数组一般即可
     * @param array
     * @return
     */
    public int MoreThanHalfNum(int[] array){
        if(array==null||array.length==0) return 0;
        int result=0;
        int times=0;
        int length = array.length;
        for(int i=0; i<length; i++){
            if(times==0){
                times=1;
                result=array[i];
            }else if(array[i]==result){
                times++;
            }else{
                times--;
            }
        }
        times=0;
        for(int j=0; j<length; j++){
            if(result==array[j]) times++;
        }
        if(times<=length) result=0;
        return result;
    }
}
