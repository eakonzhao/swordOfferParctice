/**
 * Created by Eakon on 2017/6/8.
 *
 * 圆圈中最后剩下的数字
 *
 * 题目描述：0，1，...,n-1 这n个数字排成一个圆圈，从数字0开始每次
 * 从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 */
public class LastRemaining {
    /**
     * 用数组模拟循环链表
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m){
        if(n<1||m<1) return -1;
        int[] array = new int [n];
        int i=-1,step=0,count=n;
        while(count>0){//跳出循环时将最后一个元素也设置为了1
            i++;
            if(i>=n) i=0;//模拟环
            if(array[i]==-1) continue;//跳过被删除的元素
            step++;//记录走过的步数
            if(step==m){
                array[i]=-1;
                step=0;
                count--;
            }
        }
        return i;//返回跳出循环时的i，即最后一个被设置为-1的元素
    }

    /**
     * 利用数学归纳法
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution2(int n, int m){
        if(n<1||m<1) return -1;
        int last=0;
        for(int i=2; i<=n; i++){
            last=(last+m)%i;
        }
        return last;
    }
}
