/**
 * Created by Eakon on 2017/5/30.
 * 输入两个整数m和n,
 */
public class NumberOfConversions {

    public static int numberOfConversions(int num1, int num2){
        int numTemp = num1^num2;
        int count=0;
        while(numTemp!=0){
            count++;
            numTemp=numTemp&(numTemp-1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(numberOfConversions(11,4));
    }
}
