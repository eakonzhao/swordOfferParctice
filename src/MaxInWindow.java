import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Eakon on 2017/6/13.
 *
 * 滑动窗口的最大值
 *
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}
 */
public class MaxInWindow {

   /* public ArrayList<Integer> maxInWindows(int[] num,int size){
        ArrayList<Integer> result = new ArrayList<>();
        if(size!=0){
            int begin=0;
            LinkedList<Integer> deque = new LinkedList<>();
            for(int i=0; i<num.length; i++){
                begin=i-size+1;
                if(deque.isEmpty()) deque.add(i);
                else if(begin>deque.peekFirst()) deque.pollFirst();
                while((!deque.isEmpty()) && num[deque.peekLast()]<=num[i]){
                    deque.pollLast();
                }
                deque.add(i);
                if(begin>=0) result.add(num[deque.peekFirst()]);
            }
        }
        return result;
    }*/

   public static ArrayList<Integer> maxInWindows(int[] num,int size){
       ArrayList<Integer> result = new ArrayList<>();
       if(num!=null&&num.length>=size&&size>0){
           LinkedList<Integer> deque = new LinkedList<>();
           for(int i=0; i<size; i++){
               while(!deque.isEmpty()&&num[i]>num[deque.peekLast()]){
                   deque.removeLast();
               }
               deque.addLast(i);
           }
           for(int i=size-1; i<num.length; i++){
               while(!deque.isEmpty()&&num[i]>num[deque.peekLast()]){
                   deque.removeLast();
               }
               deque.addLast(i);
               if(i-deque.getFirst()+1>size){
                   deque.removeFirst();
               }
               result.add(num[deque.getFirst()]);
           }
       }
       return result;
   }

    public static void main(String[] args) {
        int[] array={2,3,4,2,6,2,5,1};
        ArrayList<Integer> list=maxInWindows(array,3);
        System.out.println(list.toString());
    }
}
