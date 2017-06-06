/**
 * Created by Eakon on 2017/6/6.
 *
 * 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * input:
 *         1,2,3,4,5,6,7,0
 * output:
 *         7
 */
public class InversePairs {
    /**
     * 暴力循环法
     * @param array
     * @return
     */
    public static int InversePairs(int [] array) {
        if(array==null || array.length==0) return 0;
        int length = array.length;
        int count = 0;
        for(int i=0; i<length-1; i++){
            for(int j=i+1; j<length; j++){
                if(array[i]>array[j]) count++;
            }
        }
        return count%1000000007;
    }

    /**
     * 利用类似于归并排序的方法
     * @param array
     * @return
     */
    public  int InversePairs2(int[] array){
        if(array==null || array.length==0) return 0;
        int n = array.length;
        int[] copy = new int[n];
        for(int i=0; i<n; i++){
            copy[i] = array[i];
        }
        int count = InversePairs(array,copy,0,n-1);
        return count;
    }

    private int InversePairs(int[] array, int[] copy, int start, int end){
        if(start==end) return 0;
        int mid = (start+end)>>1;
        int leftCount = InversePairs(copy,array,start,mid)%1000000007;
        int rightCount = InversePairs(copy,array,mid+1,end)%1000000007;
        int count = 0;
        int leftEnd = mid;
        int rightEnd = end;
        int copyIndex = end;
        while(leftEnd>=start&&rightEnd>mid){
            if(array[leftEnd]>array[rightEnd]){
                copy[copyIndex--] = array[leftEnd--];
                count += rightEnd-mid;
                if(count>=1000000007){
                    count %= 1000000007;
                }
            }else{
                copy[copyIndex--] = array[rightEnd--];
            }
        }
        for( ; leftEnd>=start; leftEnd--){
            copy[copyIndex--] = array[leftEnd];
        }
        for( ; rightEnd>mid; rightEnd--){
            copy[copyIndex--] = array[rightEnd];
        }
        return (rightCount+leftCount+count)%1000000007;
    }
}
