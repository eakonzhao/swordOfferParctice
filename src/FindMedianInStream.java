import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Eakon on 2017/6/13.
 *
 * 数据流中的中位数
 *
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class FindMedianInStream {

    private int count=0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11,new Comparator<Integer>(){
        @Override
        public int compare(Integer o1,Integer o2){
            return o2.compareTo(o1);
        }
    });

    public void Insert(int num){
        count++;
        if((count&1)==1){
            if(!minHeap.isEmpty() && num>minHeap.peek()){
                minHeap.offer(num);
                num=minHeap.poll();
            }
            maxHeap.offer(num);
        }else{
            if(!maxHeap.isEmpty() && num<maxHeap.peek()){
                maxHeap.offer(num);
                num=maxHeap.poll();
            }
            minHeap.offer(num);
        }
    }

    public Double GetMedian(){
        if(count==0) return (Double)null;
        double result;
        if((count&1)==1){
            result=maxHeap.peek();
        }else{
            result=(maxHeap.peek()+minHeap.peek())/2.0;
        }
        return result;
    }
}
