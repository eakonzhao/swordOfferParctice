import java.util.ArrayList;

/**
 * Created by Eakon on 2017/5/30.
 */
public class NumberOf1 {
    public static int NumberOf1(int n){
        int count=0;
        while(n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(1));
        System.out.println(NumberOf1(5));//0101
        ArrayList list = new ArrayList();
    }
}
