/**
 * Created by Eakon on 2017/6/9.
 *
 * 构建乘积数组
 *
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Multiply {

    public int[] Multiply(int[] A){
        int[] B=new int[A.length];
        if(A.length!=0){
            B[0]=1;
            for(int i=1; i<A.length; i++){
                B[i]=B[i-1]*A[i-1];
            }
            int temp=1;
            for(int j=A.length-2; j>=0; j--){
                temp*=A[j+1];
                B[j]*=temp;
            }
        }
        return B;
    }
}
