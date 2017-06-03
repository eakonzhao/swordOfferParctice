/**
 * Created by Eakon on 2017/5/30.
 * 判断一个数是否为2的整数次方
 * 即判断该十进制数对应的二进制有几个0
 * 若只有一个，说明该数为2的整数次方，否则不是2的整数次方
 */
public class AIntegerSquareOf2 {

    public static boolean isAIntegerSquareOf2(int target){
        int count=0;
        while(target!=0){
            count++;
            target = target&(target-1);
        }
        return count==1?true:false;
    }

    public static void main(String[] args) {
        System.out.println(isAIntegerSquareOf2(2));
        System.out.println(isAIntegerSquareOf2(10));
        System.out.println(isAIntegerSquareOf2(32));
    }
}
