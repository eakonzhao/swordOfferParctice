/**
 * Created by Eakon on 2017/6/9.
 *
 * 求1+2+3+...+n
 *
 * 求1+2+3+...+n，
 * for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Sum {
    public int Sum_Solution(int n){
        int sum=n;
        boolean temp=(n>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }
}
