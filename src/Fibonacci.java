/**
 * Created by Eakon on 2017/5/30.
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 */
public class Fibonacci {
    public int Fibonacci(int n){
        if(n<2){
            return n;
        }
        int pre=1;
        int prePre=0;
        int result=0;
        for(int i=2; i<=n; i++){
            result=pre+prePre;
            prePre=pre;
            pre=result;
        }
        return result;
    }

    /***
     * 递归斐波那契，时间复杂度太高
     * @param n
     * @return
     */
    public int FibonacciRescursion(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        return FibonacciRescursion(n-1)+FibonacciRescursion(n-2);
    }
}
