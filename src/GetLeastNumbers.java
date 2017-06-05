import java.util.ArrayList;

/**
 * Created by Eakon on 2017/6/4.
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbers {

    /**
     * 基于堆排序 时间复杂度 O(nlogk)
     * @param input
     * @param k
     * @return
     */
    public  ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input!=null&&input.length!=0&&k>0){
            for(int i=k/2-1; i>=0; i--){
                adjustMaxHeap(input,i,k-1);
            }
            for(int i=k; i<input.length; i++){
                if(input[i]<input[0]){
                    int temp = input[i];
                    input[i] = input[0];
                    input[0] = temp;
                    adjustMaxHeap(input,0,k-1);
                }
            }
            for(int i=k-1; i>=0; i--){
                int temp=input[i];
                input[i] = input[0];
                input[0] = temp;
                adjustMaxHeap(input,0,i-1);
            }
            for(int i=0; i<k; i++){
                list.add(input[i]);
            }
        }
        return list;
    }

    private  void adjustMaxHeap(int[] input, int pos, int length){
        int temp;
        int child;
        for(temp=input[pos]; pos*2+1<=length; pos=child){
            child=pos*2+1;
            if(child<length&&input[child]<input[child+1]){
                child++;
            }
            if(temp<input[child]){
                input[pos] = input[child];
            }else{
                break;
            }
        }
        input[pos]=temp;
    }
    /**
     *
     *
     */





    /**
     * 基于快排的Partition函数
     * @param input
     * @param k
     * @return
     */
    public  ArrayList<Integer> GetLeastNumbers_Solution2(int[] input,int k){
        ArrayList<Integer> list = new ArrayList<>();
        if(input!=null&&input.length!=0&&k<=input.length&&k>0){
            int low=0;
            int high=input.length-1;
            int index = Partition(input,k,low,high);
            while(index!=k-1){
                if(index > k-1){
                    high=index-1;
                    index = Partition(input,k,low,high);
                }else{
                    low = index+1;
                    index = Partition(input,k,low,high);
                }
            }
            for(int i=0; i<k; i++){
                list.add(input[i]);
            }
        }
        return list;
    }

    private  int Partition(int[] input, int k, int low, int high){
        int pivot = input[low];
        while(low<high){
            while(low<high&&input[high]>=pivot) high--;
            swap(input,low,high);
            while(low<high&&input[low]<=pivot) low++;
            swap(input,low,high);
        }
        return low;
    }

    private  void swap(int[] input, int low, int high){
        int temp = input[low];
        input[low] = input[high];
        input[high] = temp;
    }
}