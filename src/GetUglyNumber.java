/**
 * Created by Eakon on 2017/6/6.
 *
 * 丑数
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumber {
    public int GetUglyNumber_Solution(int index){
        if(index<=0) return 0;
        int[] uglyArray = new int[index];
        uglyArray[0] = 1;
        int nextUglyIndex = 1;
        int _2Index =0;
        int _3Index =0;
        int _5Index = 0;
        while(nextUglyIndex<index){
           uglyArray[nextUglyIndex] = min(2*uglyArray[_2Index],3*uglyArray[_3Index],5*uglyArray[_5Index]);
            while(2*uglyArray[_2Index]<=uglyArray[nextUglyIndex]) _2Index++;
            while(3*uglyArray[_3Index]<=uglyArray[nextUglyIndex]) _3Index++;
            while(5*uglyArray[_5Index]<=uglyArray[nextUglyIndex]) _5Index++;
            nextUglyIndex++;
        }
        return uglyArray[index-1];
    }

    private int min(int a, int b, int c){
        int min = (a<b)?a:b;
        min = (c<min)?c:min;
        return min;
    }
}
